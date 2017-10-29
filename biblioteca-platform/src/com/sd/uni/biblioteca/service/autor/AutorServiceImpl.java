package com.sd.uni.biblioteca.service.autor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.dao.autor.IAutorDao;
import com.sd.uni.biblioteca.dao.autor.AutorDaoImpl;
import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.autor.AutorDomain;
import com.sd.uni.biblioteca.dto.autor.AutorDTO;
import com.sd.uni.biblioteca.dto.autor.AutorResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class AutorServiceImpl extends BaseServiceImpl<AutorDTO, AutorDomain, AutorDaoImpl, AutorResult>
		implements IAutorService {
	@Autowired
	private IAutorDao rolDao;

	@Override
	@Transactional
	public AutorDTO save(AutorDTO dto) {
		final AutorDomain domain = convertDtoToDomain(dto);
		IBaseDao<AutorDomain> autorDao;
		final AutorDomain autorDomain = autorDao.save(domain);
		return convertDomainToDto(autorDomain);
	}

	@Override
	@Transactional
	public AutorDTO getById(Integer id) throws BibliotecaException {
		final AutorDomain domain = autorDao.getById(id);
		final AutorDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public AutorResult getAll() {
		final List<AutorDTO> autors = new ArrayList<>();
		for (AutorDomain domain : autorDao.findAll()) {
			final AutorDTO dto = convertDomainToDto(domain);
			autors.add(dto);
		}
		final AutorResult autorResult = new AutorResult();
		autorResult.setAutors(autors);
		return autorResult;
	}

	@Override
	@Transactional
	public AutorResult find(String textToFind) {
		final List<AutorDTO> autors = new ArrayList<>();
		IAutorDao autorDao;
		for (AutorDomain domain : autorDao.find(textToFind)) {
			final AutorDTO dto = convertDomainToDto(domain);
			autors.add(dto);
		}
		final AutorResult autorResult = new AutorResult();
		autorResult.setAutors(autors);
		return autorResult;
	}

	@Override
	protected AutorDTO convertDomainToDto(AutorDomain domain) {
		final AutorDTO dto = new AutorDTO();
		dto.setId(domain.getId());
		dto.setName(domain.getName());
		return dto;
	}

	@Override
	protected AutorDomain convertDtoToDomain(AutorDTO dto) {
		final AutorDomain domain = new AutorDomain();
		domain.setId(dto.getId());
		domain.setName(dto.getName());
		return domain;
	}

}