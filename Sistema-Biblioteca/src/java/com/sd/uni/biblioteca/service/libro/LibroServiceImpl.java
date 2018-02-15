package com.sd.uni.biblioteca.service.libro;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sd.uni.biblioteca.beans.libro.LibroB;
import com.sd.uni.biblioteca.rest.libro.ILibroResource;
import com.sd.uni.biblioteca.rest.libro.LibroResourceImpl;
import com.sd.uni.biblioteca.dto.libro.LibroDTO;
import com.sd.uni.biblioteca.dto.libro.LibroResult;
import com.sd.uni.biblioteca.service.autor.AutorServiceImpl;
import com.sd.uni.biblioteca.service.autor.IAutorService;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;
import com.sd.uni.biblioteca.service.categoria.CategoriaServiceImpl;
import com.sd.uni.biblioteca.service.categoria.ICategoriaService;
@Service("libroService")
public class LibroServiceImpl extends BaseServiceImpl<LibroB, LibroDTO> implements ILibroService {
	@Autowired
	private  ILibroResource _libroResource= new LibroResourceImpl();
	@Autowired
	private IAutorService _autorService=new AutorServiceImpl();
	@Autowired
	private ICategoriaService _categoriaService=new CategoriaServiceImpl();

	public LibroServiceImpl() {
	}

	@Override
	@CacheEvict(value="biblioteca-platform-web-cache", key="'libro_'")
	@CachePut(value="biblioteca-platform-web-cache", key="'libro_'+#bean.getId()", condition="#bean.getId() != null")
	public LibroB save(LibroB bean) {
		final LibroDTO dto = convertBeanToDto(bean);
		final LibroDTO libroDTO = _libroResource.save(dto);
		return convertDtoToBean(libroDTO);
	}

	@Override
	@Cacheable(value="biblioteca-platform-web-cache", key="'libro_'")	
	public List<LibroB> find(String textToFind, int page, int maxItems) {
		final LibroResult result = _libroResource.find(textToFind, page, maxItems);
		final List<LibroDTO> uList = null == result.getLibros() ? new ArrayList<LibroDTO>() : result.getLibros();
		final List<LibroB> libros = new ArrayList<LibroB>();

		for (LibroDTO dto : uList) {
			final LibroB libro = convertDtoToBean(dto);
			libros.add(libro);
		}
		return libros;
	}
	
		@Override
		@Cacheable(value="biblioteca-platform-web-cache", key="'libro_'")	
		public List<LibroB> find(int page, int maxItems) {
			final LibroResult result = _libroResource.find(page, maxItems);
			final List<LibroDTO> uList = null == result.getLibros() ? new ArrayList<LibroDTO>() : result.getLibros();
			final List<LibroB> libros = new ArrayList<LibroB>();

			for (LibroDTO dto : uList) {
				final LibroB libro = convertDtoToBean(dto);
				libros.add(libro);
			}
			return libros;
		}

	@Override
	@Cacheable(value="biblioteca-platform-web-cache", key="'libro_'")	
	public List<LibroB> getAll() {
		final LibroResult result = _libroResource.getAll();
		final List<LibroDTO> uList = null == result.getLibros() ? new ArrayList<LibroDTO>() : result.getLibros();
		final List<LibroB> libros = new ArrayList<LibroB>();

		for (LibroDTO dto : uList) {
			final LibroB libro = convertDtoToBean(dto);
			libros.add(libro);
		}
		return libros;
	}

	@Override
	@Cacheable(value="biblioteca-platform-web-cache", key="'libro_' +#id")
	public LibroB getById(Integer id) {
		final LibroDTO dto = _libroResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected LibroB convertDtoToBean(LibroDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("nombre", dto.getNombre());
		params.put("anho", dto.getAnho());
		params.put("cantidad", String.valueOf(dto.getCantidad()));
		final LibroB libro = new LibroB(params);
		libro.setAutor(_autorService.getById(dto.getAutorId()));
		libro.setCategoria(_categoriaService.getById(dto.getCategoriaId()));
		return libro;
	}

	@Override
	protected LibroDTO convertBeanToDto(LibroB bean) {
		final LibroDTO dto = new LibroDTO();
		dto.setId(bean.getId());
		dto.setAutorId(bean.getAutor().getId());
		dto.setCategoriaId(bean.getCategoria().getId());
		dto.setNombre(bean.getNombre());
		dto.setAnho(bean.getAnho());
		dto.setCantidad(bean.getCantidad());
		return dto;
	}

}
