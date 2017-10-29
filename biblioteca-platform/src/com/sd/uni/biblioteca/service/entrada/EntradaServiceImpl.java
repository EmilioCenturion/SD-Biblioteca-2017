package com.sd.uni.biblioteca.service.entrada;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;










import com.sd.uni.biblioteca.dao.entrada.IEntradaDao;
import com.sd.uni.biblioteca.dao.entrada.EntradaDaoImpl;
import com.sd.uni.biblioteca.dao.motivoEntrada.IMotivoEntradaDao;
import com.sd.uni.biblioteca.domain.entrada.EntradaDomain;
import com.sd.uni.biblioteca.dto.entrada.EntradaDTO;
import com.sd.uni.biblioteca.dto.entrada.EntradaResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class EntradaServiceImpl extends BaseServiceImpl<EntradaDTO, EntradaDomain, EntradaDaoImpl, EntradaResult>
		implements IEntradaService {
	@Autowired
	private IEntradaDao entradaDao;
	
	@Autowired
	private IMotivoEntradaDao entradaMotivoDao;

	@Override
	@Transactional
	public EntradaDTO save(EntradaDTO dto) {
		final EntradaDomain domain = convertDtoToDomain(dto);
		final EntradaDomain entradaDomain = entradaDao.save(domain);
		return convertDomainToDto(entradaDomain);
	}

	@Override
	@Transactional
	public EntradaDTO getById(Integer id) throws BibliotecaException {
		final EntradaDomain domain = entradaDao.getById(id);
		final EntradaDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public EntradaResult getAll() {
		final List<EntradaDTO> entrada = new ArrayList<>();
		for (EntradaDomain domain : entradaDao.findAll()) {
			final EntradaDTO dto = convertDomainToDto(domain);
			entrada.add(dto);
		}
		final EntradaResult entradaResult = new EntradaResult();
		entradaResult.setEntradas(entrada);
		return entradaResult;
	}

	@Override
	@Transactional
	public EntradaResult find(String textToFind) {
		final List<EntradaDTO> entradas = new ArrayList<>();
		for (EntradaDomain domain : entradaDao.find(textToFind)) {
			final EntradaDTO dto = convertDomainToDto(domain);
			entradas.add(dto);
		}
		final EntradaResult entradaResult = new EntradaResult();
		entradaResult.setEntradas(entradas);
		return entradaResult;
	}

	@Override
	protected EntradaDTO convertDomainToDto(EntradaDomain domain) {
		final EntradaDTO dto = new EntradaDTO();
		dto.setId(domain.getId());
		dto.setDescripcion(domain.getDescripcion());
		dto.setFecha(domain.getFecha());
		dto.setMotivoEntradaId(domain.getMotivoEntrada().getId());
		return dto;
	}

	@Override
	protected EntradaDomain convertDtoToDomain(EntradaDTO dto) {
		final EntradaDomain domain = new EntradaDomain();
		domain.setId(dto.getId());
		domain.setDescripcion(dto.getDescripcion());
		domain.setFecha(dto.getFecha());
		domain.setMotivoEntrada(entradaMotivoDao.getById(dto.getMotivoEntradaId()));
		
		return domain;
	}

}

