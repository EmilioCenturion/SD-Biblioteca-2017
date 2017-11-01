package com.sd.uni.biblioteca.service.estado;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.dao.rol.IRolDao;
import com.sd.uni.biblioteca.dao.estado.IEstadoDao;
import com.sd.uni.biblioteca.dao.estado.EstadoDaoImpl;
import com.sd.uni.biblioteca.domain.entrada.EntradaDomain;
import com.sd.uni.biblioteca.domain.estado.EstadoDomain;
import com.sd.uni.biblioteca.dto.categoria.CategoriaDTO;
import com.sd.uni.biblioteca.dto.entrada.EntradaDTO;
import com.sd.uni.biblioteca.dto.entrada.EntradaResult;
import com.sd.uni.biblioteca.dto.estado.EstadoDTO;
import com.sd.uni.biblioteca.dto.estado.EstadoResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class EstadoServiceImpl extends BaseServiceImpl<EstadoDTO, EstadoDomain, EstadoDaoImpl, EstadoResult>
		implements IEstadoService {
	
	@Autowired
	private IEstadoDao estadoDao;

	@Override
	@Transactional
	public EstadoDTO save(EstadoDTO dto) {
		final EstadoDomain domain = convertDtoToDomain(dto);
		final EstadoDomain estadoDomain = estadoDao.save(domain);
		return convertDomainToDto(estadoDomain);
	}

	@Override
	@Transactional
	public EstadoDTO getById(Integer id) throws BibliotecaException {
		final EstadoDomain domain = estadoDao.getById(id);
		final EstadoDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public EstadoResult getAll() {
		final List<EstadoDTO> estado = new ArrayList<>();
		for (EstadoDomain domain : estadoDao.findAll()) {
			final EstadoDTO dto = convertDomainToDto(domain);
			estado.add(dto);
		}
		final EstadoResult estadoResult = new EstadoResult();
		estadoResult.setEstados(estado);
		return estadoResult;
	}

	@Override
	protected EstadoDTO convertDomainToDto(EstadoDomain domain) {
		final EstadoDTO dto = new EstadoDTO();
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

	@Override
	@Transactional
	public EstadoResult find(String textToFind) {
		final List<EstadoDTO> estados = new ArrayList<>();
		for (EstadoDomain domain : estadoDao.find(textToFind)) {
			final EstadoDTO dto = convertDomainToDto(domain);
			estados.add(dto);
		}
		final EstadoResult estadoResult = new EstadoResult();
		estadoResult.setEstados(estados);
		return estadoResult;
	}

}
