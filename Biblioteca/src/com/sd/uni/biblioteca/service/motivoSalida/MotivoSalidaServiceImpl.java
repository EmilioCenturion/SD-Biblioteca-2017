package com.sd.uni.biblioteca.service.motivoSalida;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.dao.motivoSalida.IMotivoSalidaDao;
import com.sd.uni.biblioteca.dao.motivoSalida.MotivoSalidaDaoImpl;
import com.sd.uni.biblioteca.domain.motivo_salida.MotivoSalidaDomain;
import com.sd.uni.biblioteca.dto.motivoSalida.MotivoSalidaDTO;
import com.sd.uni.biblioteca.dto.motivoSalida.MotivoSalidaResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class MotivoSalidaServiceImpl extends BaseServiceImpl<MotivoSalidaDTO, MotivoSalidaDomain, MotivoSalidaDaoImpl, MotivoSalidaResult>
		implements IMotivoSalidaService {
	@Autowired
	private IMotivoSalidaDao motivoDao;

	@Override
	@Transactional
	public MotivoSalidaDTO save(MotivoSalidaDTO dto) {
		final MotivoSalidaDomain domain = convertDtoToDomain(dto);
		final MotivoSalidaDomain MotivoSalidaDomain = motivoDao.save(domain);
		return convertDomainToDto(MotivoSalidaDomain);
	}

	@Override
	@Transactional
	public MotivoSalidaDTO getById(Integer id) throws BibliotecaException {
		final MotivoSalidaDomain domain = motivoDao.getById(id);
		final MotivoSalidaDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public MotivoSalidaResult getAll() {
		final List<MotivoSalidaDTO> motivos = new ArrayList<>();
		for (MotivoSalidaDomain domain : motivoDao.findAll()) {
			final MotivoSalidaDTO dto = convertDomainToDto(domain);
			motivos.add(dto);
		}
		final MotivoSalidaResult motivoResult = new MotivoSalidaResult();
		motivoResult.setMotivos(motivos);
		return motivoResult;
	}

	@Override
	@Transactional
	public MotivoSalidaResult find(String textToFind) {
		final List<MotivoSalidaDTO> motivos = new ArrayList<>();
		for (MotivoSalidaDomain domain : motivoDao.find(textToFind)) {
			final MotivoSalidaDTO dto = convertDomainToDto(domain);
			motivos.add(dto);
		}
		final MotivoSalidaResult motivoResult = new MotivoSalidaResult();
		motivoResult.setMotivos(motivos);
		return motivoResult;
	}

	@Override
	protected MotivoSalidaDTO convertDomainToDto(MotivoSalidaDomain domain) {
		final MotivoSalidaDTO dto = new MotivoSalidaDTO();
		dto.setId(domain.getId());
		dto.setDescripcion(domain.getDescripcion());
		return dto;
	}

	@Override
	protected MotivoSalidaDomain convertDtoToDomain(MotivoSalidaDTO dto) {
		final MotivoSalidaDomain domain = new MotivoSalidaDomain();
		domain.setId(dto.getId());
		domain.setDescripcion(dto.getDescripcion());
		return domain;
	}

}
