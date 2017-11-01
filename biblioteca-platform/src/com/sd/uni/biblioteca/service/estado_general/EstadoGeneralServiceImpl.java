package com.sd.uni.biblioteca.service.estado_general;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.dao.estado_general.EstadoGeneralDaoImpl;
import com.sd.uni.biblioteca.dao.estado_general.IEstadoGeneralDao;
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
		final EstadoGeneralDomain estado_generalDomain = estadoGeneralDao.save(domain);
		return convertDomainToDto(estado_generalDomain);
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
		final List<EstadoGeneralDTO> estado_general = new ArrayList<>();
		for (EstadoGeneralDomain domain : estadoGeneralDao.findAll()) {
			final EstadoGeneralDTO dto = convertDomainToDto(domain);
			estado_general.add(dto);
		}
		final EstadoGeneralResult estado_generalResult = new EstadoGeneralResult();
		estado_generalResult.setEstadosGenerales(estado_general);
		return estado_generalResult;
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
		final List<EstadoGeneralDTO> estados = new ArrayList<>();
		for (EstadoGeneralDomain domain : estadoGeneralDao.find(textToFind)) {
			final EstadoGeneralDTO dto = convertDomainToDto(domain);
			estados.add(dto);
		}
		final EstadoGeneralResult estadoResult = new EstadoGeneralResult();
		estadoResult.setEstadosGenerales(estados);
		return estadoResult;
	}

}
