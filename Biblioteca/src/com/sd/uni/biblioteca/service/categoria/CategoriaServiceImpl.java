package com.sd.uni.biblioteca.service.categoria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.dao.categoria.CategoriaDaoImpl;
import com.sd.uni.biblioteca.dao.categoria.ICategoriaDao;
import com.sd.uni.biblioteca.domain.categoria.CategoriaDomain;
import com.sd.uni.biblioteca.dto.categoria.CategoriaDTO;
import com.sd.uni.biblioteca.dto.categoria.CategoriaResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;




@Service
public class CategoriaServiceImpl extends BaseServiceImpl<CategoriaDTO, CategoriaDomain, CategoriaDaoImpl, CategoriaResult>
		implements ICategoriaService {
	@Autowired
	private ICategoriaDao categoriaDao;
	
	
	@Autowired
	private CacheManager cacheManager;

	@Override
	@Transactional
	@CacheEvict(value= "biblioteca-platform-cache",key = "'categoria_'")
	@CachePut(value = "biblioteca-platform-cache", key = "'categoria_' + #dto.id", condition="#dto.id!=null")
	public CategoriaDTO save(CategoriaDTO dto) {
		final CategoriaDomain domain = convertDtoToDomain(dto);
		final CategoriaDomain categoriaDomain = categoriaDao.save(domain);
		return convertDomainToDto(categoriaDomain);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value="biblioteca-platform-cache", key="'categoria_'+#id")
	public CategoriaDTO getById(Integer id) throws BibliotecaException {
		final CategoriaDomain domain = categoriaDao.getById(id);
		final CategoriaDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value= "biblioteca-platform-cache")
	public CategoriaResult getAll() {
		final List<CategoriaDTO> categorias = new ArrayList<>();
		for (CategoriaDomain domain : categoriaDao.findAll()) {
			final CategoriaDTO dto = convertDomainToDto(domain);
			cacheManager.getCache("biblioteca-platform-cache")
						.put("categoria_" + domain.getId(), domain);
			categorias.add(dto);
		}
		final CategoriaResult categoriaResult = new CategoriaResult();
		categoriaResult.setCategorias(categorias);
		return categoriaResult;
	}

	@Override
	@Transactional
	public CategoriaResult find(String textToFind) {
		final List<CategoriaDTO> categoriaes = new ArrayList<>();
		for (CategoriaDomain domain : categoriaDao.find(textToFind)) {
			final CategoriaDTO dto = convertDomainToDto(domain);
			categoriaes.add(dto);
		}
		final CategoriaResult categoriaResult = new CategoriaResult();
		categoriaResult.setCategorias(categoriaes);
		return categoriaResult;
	}

	@Override
	protected CategoriaDTO convertDomainToDto(CategoriaDomain domain) {
		final CategoriaDTO dto = new CategoriaDTO();
		dto.setId(domain.getId());
		dto.setDescripcion(domain.getDescripcion());
		return dto;
	}

	@Override
	protected CategoriaDomain convertDtoToDomain(CategoriaDTO dto) {
		final CategoriaDomain domain = new CategoriaDomain();
		domain.setId(dto.getId());
		domain.setDescripcion(dto.getDescripcion());
		return domain;
	}
	
	@Override
	@Transactional(readOnly = true)
	public CategoriaResult find(String textToFind, int page, int maxItems) throws BibliotecaException {
		final List<CategoriaDTO> categoriaes = new ArrayList<>();
		for (CategoriaDomain domain : categoriaDao.find(textToFind, page, maxItems)) {
			final CategoriaDTO dto = convertDomainToDto(domain);
			categoriaes.add(dto);
		}
		final CategoriaResult categoriaResult = new CategoriaResult();
		categoriaResult.setCategorias(categoriaes);
		return categoriaResult;
	}

}
