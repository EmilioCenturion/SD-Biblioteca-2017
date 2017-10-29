package com.sd.uni.biblioteca.service.salidaDetalle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sd.uni.biblioteca.dao.salida.ISalidaDao;
import com.sd.uni.biblioteca.dao.salidaDetalle.ISalidaDetalleDao;
import com.sd.uni.biblioteca.dao.salidaDetalle.SalidaDetalleDaoImpl;
import com.sd.uni.biblioteca.domain.salidaDetalle.SalidaDetalleDomain;
import com.sd.uni.biblioteca.dto.salidaDetalle.SalidaDetalleDTO;
import com.sd.uni.biblioteca.dto.salidaDetalle.SalidaDetalleResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class SalidaDetalleServiceImpl extends BaseServiceImpl<SalidaDetalleDTO, SalidaDetalleDomain, SalidaDetalleDaoImpl, SalidaDetalleResult>
		implements ISalidaDetalleService {
	@Autowired
	private ISalidaDetalleDao salidaDetalleDao;
	
	@Autowired
	private ISalidaDao salidaDao;
	
	@Autowired
	private ILibroDao libroDao;

	@Override
	@Transactional
	public SalidaDetalleDTO save(SalidaDetalleDTO dto) {
		final SalidaDetalleDomain domain = convertDtoToDomain(dto);
		final SalidaDetalleDomain salidaDetalleDomain = salidaDetalleDao.save(domain);
		return convertDomainToDto(salidaDetalleDomain);
	}

	@Override
	@Transactional
	public SalidaDetalleDTO getById(Integer id) throws BibliotecaException {
		final SalidaDetalleDomain domain = salidaDetalleDao.getById(id);
		final SalidaDetalleDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public SalidaDetalleResult getAll() {
		final List<SalidaDetalleDTO> salidaDetalle = new ArrayList<>();
		for (SalidaDetalleDomain domain : salidaDetalleDao.findAll()) {
			final SalidaDetalleDTO dto = convertDomainToDto(domain);
			salidaDetalle.add(dto);
		}
		final SalidaDetalleResult salidaDetalleResult = new SalidaDetalleResult();
		salidaDetalleResult.setSalidaDetalles(salidaDetalle);
		return salidaDetalleResult;
	}

	@Override
	@Transactional
	public SalidaDetalleResult find(String textToFind) {
		final List<SalidaDetalleDTO> salidaDetalles = new ArrayList<>();
		for (SalidaDetalleDomain domain : salidaDetalleDao.find(textToFind)) {
			final SalidaDetalleDTO dto = convertDomainToDto(domain);
			salidaDetalles.add(dto);
		}
		final SalidaDetalleResult salidaDetalleResult = new SalidaDetalleResult();
		salidaDetalleResult.setSalidaDetalles(salidaDetalles);
		return salidaDetalleResult;
	}

	@Override
	protected SalidaDetalleDTO convertDomainToDto(SalidaDetalleDomain domain) {
		final SalidaDetalleDTO dto = new SalidaDetalleDTO();
		dto.setId(domain.getId());
		dto.setSalidaId(domain.getSalida().getId());
		dto.setLibroId(domain.getLibro().getId());
		return dto;
	}

	@Override
	protected SalidaDetalleDomain convertDtoToDomain(SalidaDetalleDTO dto) {
		final SalidaDetalleDomain domain = new SalidaDetalleDomain();
		domain.setId(dto.getId());
		domain.setSalida(salidaDao.getById(dto.getSalidaId()));
		domain.setLibro(libroDao.getById(dto.getLibroId()));
		
		return domain;
	}

}



