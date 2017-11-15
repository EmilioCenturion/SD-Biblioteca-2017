package com.sd.uni.biblioteca.service.libro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.dao.autor.IAutorDao;
import com.sd.uni.biblioteca.dao.categoria.ICategoriaDao;
import com.sd.uni.biblioteca.dao.libro.ILibroDao;
import com.sd.uni.biblioteca.dao.libro.LibroDaoImpl;
import com.sd.uni.biblioteca.domain.libro.LibroDomain;
import com.sd.uni.biblioteca.dto.libro.LibroDTO;
import com.sd.uni.biblioteca.dto.libro.LibroResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class LibroServiceImpl extends BaseServiceImpl<LibroDTO, LibroDomain, LibroDaoImpl, LibroResult>
		implements ILibroService {
	@Autowired
	private ILibroDao libroDao;
	
	@Autowired
	private IAutorDao autorDao;
	
	@Autowired
	private ICategoriaDao categoriaDao;

	@Override
	@Transactional
	public LibroDTO save(LibroDTO dto) {
		final LibroDomain domain = convertDtoToDomain(dto);
		final LibroDomain libroDomain = libroDao.save(domain);
		return convertDomainToDto(libroDomain);
	}

	@Override
	@Transactional
	public LibroDTO getById(Integer id) throws BibliotecaException {
		final LibroDomain domain = libroDao.getById(id);
		final LibroDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public LibroResult getAll() {
		final List<LibroDTO> libros = new ArrayList<>();
		for (LibroDomain domain : libroDao.findAll()) {
			final LibroDTO dto = convertDomainToDto(domain);
			libros.add(dto);
		}
		final LibroResult libroResult = new LibroResult();
		libroResult.setLibros(libros);
		return libroResult;
	}

	@Override
	@Transactional
	public LibroResult find(String textToFind) {
		final List<LibroDTO> libros = new ArrayList<>();
		for (LibroDomain domain : libroDao.find(textToFind)) {
			final LibroDTO dto = convertDomainToDto(domain);
			libros.add(dto);
		}
		final LibroResult libroResult = new LibroResult();
		libroResult.setLibros(libros);
		return libroResult;
	}

	@Override
	protected LibroDTO convertDomainToDto(LibroDomain domain) {
		final LibroDTO dto = new LibroDTO();
		dto.setId(domain.getId());
		dto.setNombre(domain.getNombre());
		dto.setAnho(domain.getAnho());
		dto.setAutorId(domain.getAutor().getId());
		dto.setCategoriaId(domain.getCategoria().getId());
		return dto;
	}

	@Override
	protected LibroDomain convertDtoToDomain(LibroDTO dto) {
		final LibroDomain domain = new LibroDomain();
		domain.setId(dto.getId());
		domain.setNombre(dto.getNombre());
		domain.setAnho(dto.getAnho());
		domain.setAutor(autorDao.getById(dto.getAutorId()));
		domain.setCategoria(categoriaDao.getById(dto.getCategoriaId()));
		return domain;
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public LibroResult find(String textToFind, int page, int maxItems) throws BibliotecaException {
		final List<LibroDTO> libros = new ArrayList<>();
		for (LibroDomain domain : libroDao.find(textToFind, page, maxItems)) {
			final LibroDTO dto = convertDomainToDto(domain);
			libros.add(dto);
		}
		final LibroResult libroResult = new LibroResult();
		libroResult.setLibros(libros);
		return libroResult;
	}

}