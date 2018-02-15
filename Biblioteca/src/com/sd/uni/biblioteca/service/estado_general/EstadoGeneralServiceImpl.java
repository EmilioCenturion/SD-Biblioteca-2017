package com.sd.uni.biblioteca.service.estado_general;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sd.uni.biblioteca.dao.estado_general.IEstadoGeneralDao;
import com.sd.uni.biblioteca.dao.estado_general.EstadoGeneralDaoImpl;
import com.sd.uni.biblioteca.domain.estado_general.EstadoGeneralDomain;
import com.sd.uni.biblioteca.dto.estado_general.EstadoGeneralDTO;
import com.sd.uni.biblioteca.dto.estado_general.EstadoGeneralResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class EstadoGeneralServiceImpl extends BaseServiceImpl<EstadoGeneralDTO, EstadoGeneralDomain, EstadoGeneralDaoImpl, EstadoGeneralResult>
		implements IEstadoGeneralService {
	
	@Autowired
	private IEstadoGeneralDao estadoGeneralDao;

	@Override
	@Transactional
	public EstadoGeneralDTO save(EstadoGeneralDTO dto) {
		final EstadoGeneralDomain domain = convertDtoToDomain(dto);
		final EstadoGeneralDomain estadoGeneralDomain = estadoGeneralDao.save(domain);
		return convertDomainToDto(estadoGeneralDomain);
	}

	@Override
	@Transactional
	public EstadoGeneralDTO getById(Integer id) throws BibliotecaException {
		final EstadoGeneralDomain domain = estadoGeneralDao.getById(id);
		final EstadoGeneralDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public EstadoGeneralResult getAll() {
		final List<EstadoGeneralDTO> estadoGeneral = new ArrayList<>();
		for (EstadoGeneralDomain domain : estadoGeneralDao.findAll()) {
			final EstadoGeneralDTO dto = convertDomainToDto(domain);
			estadoGeneral.add(dto);
		}
		final EstadoGeneralResult estadoGeneralResult = new EstadoGeneralResult();
		estadoGeneralResult.setEstadoGenerales(estadoGeneral);
		return estadoGeneralResult;
	}

	@Override
	protected EstadoGeneralDTO convertDomainToDto(EstadoGeneralDomain domain) {
		final EstadoGeneralDTO dto = new EstadoGeneralDTO();
		dto.setId(domain.getId());
		dto.setDescripcion(domain.getDescripcion());
		return dto;
	}

	@Override
	protected EstadoGeneralDomain convertDtoToDomain(EstadoGeneralDTO dto) {
		final EstadoGeneralDomain domain = new EstadoGeneralDomain();
		domain.setId(dto.getId());
		domain.setDescripcion(dto.getDescripcion());
		return domain;
	}

	@Override
	@Transactional
	public EstadoGeneralResult find(String textToFind) {
		final List<EstadoGeneralDTO> estadoGenerals = new ArrayList<>();
		for (EstadoGeneralDomain domain : estadoGeneralDao.find(textToFind)) {
			final EstadoGeneralDTO dto = convertDomainToDto(domain);
			estadoGenerals.add(dto);
		}
		final EstadoGeneralResult estadoGeneralResult = new EstadoGeneralResult();
		estadoGeneralResult.setEstadoGenerales(estadoGenerals);
		return estadoGeneralResult;
	}

}
