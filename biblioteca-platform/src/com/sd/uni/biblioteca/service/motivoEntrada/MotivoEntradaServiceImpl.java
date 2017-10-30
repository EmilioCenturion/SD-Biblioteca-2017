package com.sd.uni.biblioteca.service.motivoEntrada;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.dao.motivoEntrada.IMotivoEntradaDao;
import com.sd.uni.biblioteca.dao.motivoEntrada.MotivoEntradaDaoImpl;
import com.sd.uni.biblioteca.domain.motivoEntrada.MotivoEntradaDomain;
import com.sd.uni.biblioteca.dto.motivoEntrada.MotivoEntradaDTO;
import com.sd.uni.biblioteca.dto.motivoEntrada.MotivoEntradaResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class MotivoEntradaServiceImpl extends BaseServiceImpl<MotivoEntradaDTO, MotivoEntradaDomain, MotivoEntradaDaoImpl, MotivoEntradaResult>
		implements IMotivoEntradaService {
	@Autowired
	private IMotivoEntradaDao motivoEntradaDao;

	@Override
	@Transactional
	public MotivoEntradaDTO save(MotivoEntradaDTO dto) {
		final MotivoEntradaDomain domain = convertDtoToDomain(dto);
		final MotivoEntradaDomain motivoEntradaDomain = motivoEntradaDao.save(domain);
		return convertDomainToDto(motivoEntradaDomain);
	}

	@Override
	@Transactional
	public MotivoEntradaDTO getById(Integer id) throws BibliotecaException {
		final MotivoEntradaDomain domain = motivoEntradaDao.getById(id);
		final MotivoEntradaDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public MotivoEntradaResult getAll() {
		final List<MotivoEntradaDTO> motivoEntradas = new ArrayList<>();
		for (MotivoEntradaDomain domain : motivoEntradaDao.findAll()) {
			final MotivoEntradaDTO dto = convertDomainToDto(domain);
			motivoEntradas.add(dto);
		}
		final MotivoEntradaResult motivoEntradaResult = new MotivoEntradaResult();
		motivoEntradaResult.setMotivoEntradas(motivoEntradas);
		return motivoEntradaResult;
	}

	@Override
	@Transactional
	public MotivoEntradaResult find(String textToFind) {
		final List<MotivoEntradaDTO> motivoEntradas = new ArrayList<>();
		for (MotivoEntradaDomain domain : motivoEntradaDao.find(textToFind)) {
			final MotivoEntradaDTO dto = convertDomainToDto(domain);
			motivoEntradas.add(dto);
		}
		final MotivoEntradaResult motivoEntradaResult = new MotivoEntradaResult();
		motivoEntradaResult.setMotivoEntradas(motivoEntradas);
		return motivoEntradaResult;
	}

	@Override
	protected MotivoEntradaDTO convertDomainToDto(MotivoEntradaDomain domain) {
		final MotivoEntradaDTO dto = new MotivoEntradaDTO();
		dto.setId(domain.getId());
		dto.setDescripcion(domain.getDescripcion());
		return dto;
	}

	@Override
	protected MotivoEntradaDomain convertDtoToDomain(MotivoEntradaDTO dto) {
		final MotivoEntradaDomain domain = new MotivoEntradaDomain();
		domain.setId(dto.getId());
		domain.setDescripcion(dto.getDescripcion());
		return domain;
	}

}
