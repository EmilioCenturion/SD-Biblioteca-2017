package com.sd.uni.biblioteca.service.categoria;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sd.uni.biblioteca.beans.categoria.CategoriaB;
import com.sd.uni.biblioteca.beans.libro.LibroB;
import com.sd.uni.biblioteca.rest.categoria.ICategoriaResource;
import com.sd.uni.biblioteca.rest.categoria.CategoriaResourceImpl;
import com.sd.uni.biblioteca.dto.categoria.CategoriaDTO;
import com.sd.uni.biblioteca.dto.categoria.CategoriaResult;
import com.sd.uni.biblioteca.dto.libro.LibroDTO;
import com.sd.uni.biblioteca.dto.libro.LibroResult;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service("categoriaService")
public class CategoriaServiceImpl extends BaseServiceImpl<CategoriaB, CategoriaDTO>
		implements ICategoriaService {
	@Autowired
	private ICategoriaResource _categoriaResource=new CategoriaResourceImpl();
	
	@Override
	@CacheEvict(value="biblioteca-platform-web-cache", key="'categoria_'")
	@CachePut(value="biblioteca-platform-web-cache", key="'categoria_'+#bean.getId()", condition="#bean.getId() != null")
	public CategoriaB save(CategoriaB bean) {
		final CategoriaDTO dto = convertBeanToDto(bean);
		final CategoriaDTO categoriaDTO = _categoriaResource.save(dto);
		return convertDtoToBean(categoriaDTO);
	}
	
	@Override
	@Cacheable(value="biblioteca-platform-web-cache", key="'categoria_'")	
	public List<CategoriaB> find(int page, int maxItems) {
		final CategoriaResult result = _categoriaResource.find(page, maxItems);
		final List<CategoriaDTO> uList = null == result.getCategorias() ? new ArrayList<CategoriaDTO>() : result.getCategorias();
		final List<CategoriaB> categorias = new ArrayList<CategoriaB>();

		for (CategoriaDTO dto : uList) {
			final CategoriaB categoria = convertDtoToBean(dto);
			categorias.add(categoria);
		}
		return categorias;
	}
	
	@Override
	@Cacheable(value="biblioteca-platform-web-cache", key="'categoria_'")	
	public List<CategoriaB> find(String textToFind, int page, int maxItems) {
		final CategoriaResult result = _categoriaResource.find(page, maxItems);
		final List<CategoriaDTO> uList = null == result.getCategorias() ? new ArrayList<CategoriaDTO>() : result.getCategorias();
		final List<CategoriaB> categorias = new ArrayList<CategoriaB>();

		for (CategoriaDTO dto : uList) {
			final CategoriaB categoria = convertDtoToBean(dto);
			categorias.add(categoria);
		}
		return categorias;
	}

	@Override
	@Cacheable(value="biblioteca-platform-web-cache", key="'categoria_'")	
	public List<CategoriaB> getAll() {
		final CategoriaResult result = _categoriaResource.getAll();
		final List<CategoriaDTO> rList = null == result.getCategorias() ? new ArrayList<CategoriaDTO>()
				: result.getCategorias();
		final List<CategoriaB> categorias = new ArrayList<CategoriaB>();

		for (CategoriaDTO dto : rList) {
			final CategoriaB categoriaB = convertDtoToBean(dto);
			categorias.add(categoriaB);
		}
		return categorias;
	}

	@Override
	@Cacheable(value="biblioteca-platform-web-cache", key="'categoria_' +#id")
	public CategoriaB getById(Integer id) {
		final CategoriaDTO dto = _categoriaResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected CategoriaB convertDtoToBean(CategoriaDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("descripcion", dto.getDescripcion());
		final CategoriaB categoriaB = new CategoriaB(params);
		return categoriaB;
	}

	@Override
	protected CategoriaDTO convertBeanToDto(CategoriaB bean) {
		final CategoriaDTO dto = new CategoriaDTO();
		dto.setId(bean.getId());
		dto.setDescripcion(bean.getDescripcion());
		return dto;
	}

}
