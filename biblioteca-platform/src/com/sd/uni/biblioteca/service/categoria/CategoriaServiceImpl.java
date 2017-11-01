package com.sd.uni.biblioteca.service.categoria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.dao.categoria.ICategoriaDao;
import com.sd.uni.biblioteca.dao.categoria.CategoriaDaoImpl;
import com.sd.uni.biblioteca.domain.categoria.CategoriaDomain;
import com.sd.uni.biblioteca.dto.categoria.CategoriaDTO;
import com.sd.uni.biblioteca.dto.categoria.CategoriaResult;
import com.sd.uni.biblioteca.dto.estado_general.EstadoGeneralDTO;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class CategoriaServiceImpl extends BaseServiceImpl<CategoriaDTO, CategoriaDomain, CategoriaDaoImpl, CategoriaResult>
		implements ICategoriaService {
	@Autowired
	private ICategoriaDao categoriaDao;

	@Override
	@Transactional
	public CategoriaDTO save(CategoriaDTO dto) {
		final CategoriaDomain domain = convertDtoToDomain(dto);
		final CategoriaDomain categoriaDomain = categoriaDao.save(domain);
		return convertDomainToDto(categoriaDomain);
	}

	@Override
	@Transactional
	public CategoriaDTO getById(Integer id) throws BibliotecaException {
		final CategoriaDomain domain = categoriaDao.getById(id);
		final CategoriaDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public CategoriaResult getAll() {
		final List<CategoriaDTO> categorias = new ArrayList<>();
		for (CategoriaDomain domain : categoriaDao.findAll()) {
			final CategoriaDTO dto = convertDomainToDto(domain);
			categorias.add(dto);
		}
		final CategoriaResult categoriaResult = new CategoriaResult();
		categoriaResult.setCategorias(categorias);
		return categoriaResult;
	}

	@Override
	@Transactional
	public CategoriaResult find(String textToFind) {
		final List<CategoriaDTO> categorias = new ArrayList<>();
		for (CategoriaDomain domain : categoriaDao.find(textToFind)) {
			final CategoriaDTO dto = convertDomainToDto(domain);
			categorias.add(dto);
		}
		final CategoriaResult categoriaResult = new CategoriaResult();
		categoriaResult.setCategorias(categorias);
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

}
