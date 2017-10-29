package com.sd.uni.biblioteca.service.estado_general;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.dao.rol.IRolDao;
import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.dao.estado_general.IEstado_generalDao;
import com.sd.uni.biblioteca.dao.estado_general.Estado_generalDaoImpl;
import com.sd.uni.biblioteca.domain.estado_general.Estado_generalDomain;
import com.sd.uni.biblioteca.domain.rol.RolDomain;
import com.sd.uni.biblioteca.dto.estado_general.Estado_generalDTO;
import com.sd.uni.biblioteca.dto.estado_general.Estado_generalResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class Estado_generalServiceImpl extends BaseServiceImpl<Estado_generalDTO, Estado_generalDomain, Estado_generalDaoImpl, Estado_generalResult>
		implements IEstado_generalService {
	@Autowired
	private IEstado_generalDao usuarioDao;
	
	@Autowired
	private IEstado_generalDao estadoDao;

	@Override
	@Transactional
	public Estado_generalDTO save(Estado_generalDTO dto) {
		final Estado_generalDomain domain = convertDtoToDomain(dto);
		IBaseDao<RolDomain> estado_generalDao;
		final Estado_generalDomain estado_generalDomain = estado_generalDao.save(domain);
		Estado_generalDomain estado_generalDomain1;
		return convertDomainToDto(estado_generalDomain1);
	}

	@Override
	@Transactional
	public Estado_generalDTO getById(Integer id) throws BibliotecaException {
		final Estado_generalDomain domain = estadoDao.getById(id);
		final Estado_generalDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public Estado_generalResult getAll() {
		final List<Estado_generalDTO> estado_general = new ArrayList<>();
		IBaseDao<RolDomain> estado_generalDao;
		for (Estado_generalDomain domain : estado_generalDao.findAll()) {
			final Estado_generalDTO dto = convertDomainToDto(domain);
			estado_general.add(dto);
		}
		final Estado_generalResult estado_generalResult = new Estado_generalResult();
		estado_generalResult.setEstados_generals(estado_general);
		return estado_generalResult;
	}

	@Override
	protected Estado_generalDTO convertDomainToDto(Estado_generalDomain domain) {
		final Estado_generalDTO dto = new Estado_generalDTO();
		dto.setId(domain.getId());
		dto.setDescripcion(domain.getDescripcion());
		return dto;
	}

	@Override
	protected EstadoDomain convertDtoToDomain(EstadoDTO dto) {
		final EstadoDomain domain = new EstadoDomain();
		domain.setId(dto.getId());
		domain.setDescripcion(dto.getDescripcion());
		return domain;
	}

}
