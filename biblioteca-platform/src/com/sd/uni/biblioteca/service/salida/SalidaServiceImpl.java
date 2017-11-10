package com.sd.uni.biblioteca.service.salida;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.dao.salida.ISalidaDao;
import com.sd.uni.biblioteca.dao.salida.SalidaDaoImpl;
import com.sd.uni.biblioteca.dao.motivoSalida.IMotivoSalidaDao;
import com.sd.uni.biblioteca.domain.salida.SalidaDomain;
import com.sd.uni.biblioteca.dto.salida.SalidaDTO;
import com.sd.uni.biblioteca.dto.salida.SalidaResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class SalidaServiceImpl extends BaseServiceImpl<SalidaDTO, SalidaDomain, SalidaDaoImpl, SalidaResult>
		implements ISalidaService {
	@Autowired
	private ISalidaDao salidaDao;
	
	@Autowired
	private IMotivoSalidaDao salidaMotivoDao;

	@Override
	@Transactional
	public SalidaDTO save(SalidaDTO dto) {
		final SalidaDomain domain = convertDtoToDomain(dto);
		final SalidaDomain salidaDomain = salidaDao.save(domain);
		return convertDomainToDto(salidaDomain);
	}

	@Override
	@Transactional
	public SalidaDTO getById(Integer id) throws BibliotecaException {
		final SalidaDomain domain = salidaDao.getById(id);
		final SalidaDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public SalidaResult getAll() {
		final List<SalidaDTO> salida = new ArrayList<>();
		for (SalidaDomain domain : salidaDao.findAll()) {
			final SalidaDTO dto = convertDomainToDto(domain);
			salida.add(dto);
		}
		final SalidaResult salidaResult = new SalidaResult();
		salidaResult.setSalidas(salida);
		return salidaResult;
	}

	@Override
	@Transactional
	public SalidaResult find(String textToFind) {
		final List<SalidaDTO> salidas = new ArrayList<>();
		for (SalidaDomain domain : salidaDao.find(textToFind)) {
			final SalidaDTO dto = convertDomainToDto(domain);
			salidas.add(dto);
		}
		final SalidaResult salidaResult = new SalidaResult();
		salidaResult.setSalidas(salidas);
		return salidaResult;
	}
	
	@Override
	@Transactional(readOnly = true)
	public SalidaResult find(String textToFind, int page, int maxItems) throws BibliotecaException, ParseException {
		final List<SalidaDTO> salidas = new ArrayList<>();
		for (SalidaDomain domain : salidaDao.find(textToFind, page, maxItems)) {
			final SalidaDTO dto = convertDomainToDto(domain);
			salidas.add(dto);
		}
		final SalidaResult salidaResult = new SalidaResult();
		salidaResult.setSalidas(salidas);
		return salidaResult;
	}

	@Override
	protected SalidaDTO convertDomainToDto(SalidaDomain domain) {
		final SalidaDTO dto = new SalidaDTO();
		dto.setId(domain.getId());
		dto.setDescripcion(domain.getDescripcion());
		dto.setFecha(domain.getFecha());
		dto.setMotivoSalidaId(domain.getMotivoSalida().getId());
		return dto;
	}

	@Override
	protected SalidaDomain convertDtoToDomain(SalidaDTO dto) {
		final SalidaDomain domain = new SalidaDomain();
		domain.setId(dto.getId());
		domain.setDescripcion(dto.getDescripcion());
		domain.setFecha(dto.getFecha());
		domain.setMotivoSalida(salidaMotivoDao.getById(dto.getMotivoSalidaId()));
		
		return domain;
	}

}