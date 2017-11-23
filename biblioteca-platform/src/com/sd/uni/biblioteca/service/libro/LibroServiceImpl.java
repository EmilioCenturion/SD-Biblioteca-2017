package com.sd.uni.biblioteca.service.libro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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
	
	@Autowired
	private CacheManager cacheManager;

	@Override
	@Transactional
	@CacheEvict(value= "biblioteca-platform-cache",key = "'libro_'")
	@CachePut(value = "biblioteca-platform-cache", key = "'libro_' + #dto.id", condition="#dto.id!=null")
	public LibroDTO save(LibroDTO dto) {
		final LibroDomain domain = convertDtoToDomain(dto);
		final LibroDomain libroDomain = libroDao.save(domain);
		return convertDomainToDto(libroDomain);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "biblioteca-platform-cache", key = "'libro_' + #id")
	public LibroDTO getById(Integer id) throws BibliotecaException {
		final LibroDomain domain = libroDao.getById(id);
		final LibroDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value= "biblioteca-platform-cache")
	public LibroResult getAll() {
		final List<LibroDTO> libros = new ArrayList<>();
		for (LibroDomain domain : libroDao.findAll()) {
			final LibroDTO dto = convertDomainToDto(domain);
			cacheManager.getCache("biblioteca-platform-cache")
						.put("libro_" + domain.getId(), domain);
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
		dto.setCantidad(domain.getCantidad());
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
		domain.setCantidad(dto.getCantidad());
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

	@Override
	@Transactional
	public LibroDTO entrada(Integer id, Integer cantidad) throws BibliotecaException { 
		final LibroDomain libroDomain = libroDao.getById(id);
		libroDomain.setCantidad((libroDomain.getCantidad() + cantidad));
		final LibroDomain libro = libroDao.save(libroDomain);
		return convertDomainToDto(libro);
	}
	
	@Override
	@Transactional
	public LibroDTO salida(Integer id, Integer cantidad) throws BibliotecaException, StockException{
		final LibroDomain libroDomain = libroDao.getById(id);
		if (cantidad <= libroDomain.getCantidad()) {
			libroDomain.setCantidad((libroDomain.getCantidad() - cantidad));
			final LibroDomain libro = libroDao.save(libroDomain);
			return convertDomainToDto(libro);
		} else {
			throw new StockException("Stock del libro insuficiente");
		}
	}

}