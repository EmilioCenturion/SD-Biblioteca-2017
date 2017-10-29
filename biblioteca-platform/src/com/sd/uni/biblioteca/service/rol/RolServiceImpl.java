package com.sd.uni.biblioteca.service.rol;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.dao.rol.IRolDao;
import com.sd.uni.biblioteca.dao.rol.RolDaoImpl;
import com.sd.uni.biblioteca.domain.rol.RolDomain;
import com.sd.uni.biblioteca.dto.rol.RolDTO;
import com.sd.uni.biblioteca.dto.rol.RolResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class RolServiceImpl extends BaseServiceImpl<RolDTO, RolDomain, RolDaoImpl, RolResult>
		implements IRolService {
	@Autowired
	private IRolDao rolDao;

	@Override
	@Transactional
	public RolDTO save(RolDTO dto) {
		final RolDomain domain = convertDtoToDomain(dto);
		final RolDomain rolDomain = rolDao.save(domain);
		return convertDomainToDto(rolDomain);
	}

	@Override
	@Transactional
	public RolDTO getById(Integer id) throws BibliotecaException {
		final RolDomain domain = rolDao.getById(id);
		final RolDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public RolResult getAll() {
		final List<RolDTO> rols = new ArrayList<>();
		for (RolDomain domain : rolDao.findAll()) {
			final RolDTO dto = convertDomainToDto(domain);
			rols.add(dto);
		}
		final RolResult rolResult = new RolResult();
		rolResult.setRols(rols);
		return rolResult;
	}

	@Override
	@Transactional
	public RolResult find(String textToFind) {
		final List<RolDTO> rols = new ArrayList<>();
		for (RolDomain domain : rolDao.find(textToFind)) {
			final RolDTO dto = convertDomainToDto(domain);
			rols.add(dto);
		}
		final RolResult rolResult = new RolResult();
		rolResult.setRols(rols);
		return rolResult;
	}

	@Override
	protected RolDTO convertDomainToDto(RolDomain domain) {
		final RolDTO dto = new RolDTO();
		dto.setId(domain.getId());
		dto.setNombre(domain.getNombre());
		return dto;
	}

	@Override
	protected RolDomain convertDtoToDomain(RolDTO dto) {
		final RolDomain domain = new RolDomain();
		domain.setId(dto.getId());
		domain.setNombre(dto.getNombre());
		return domain;
	}

}
