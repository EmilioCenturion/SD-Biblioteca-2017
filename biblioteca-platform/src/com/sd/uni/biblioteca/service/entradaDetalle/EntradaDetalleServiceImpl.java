package com.sd.uni.biblioteca.service.entradaDetalle;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;





import com.sd.uni.biblioteca.dao.entrada.IEntradaDao;
import com.sd.uni.biblioteca.dao.entradaDetalle.IEntradaDetalleDao;
import com.sd.uni.biblioteca.dao.entradaDetalle.EntradaDetalleDaoImpl;
import com.sd.uni.biblioteca.dao.libro.ILibroDao;
import com.sd.uni.biblioteca.domain.entradaDetalle.EntradaDetalleDomain;
import com.sd.uni.biblioteca.dto.entradaDetalle.EntradaDetalleDTO;
import com.sd.uni.biblioteca.dto.entradaDetalle.EntradaDetalleResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class EntradaDetalleServiceImpl extends BaseServiceImpl<EntradaDetalleDTO, EntradaDetalleDomain, EntradaDetalleDaoImpl, EntradaDetalleResult>
		implements IEntradaDetalleService {
	@Autowired
	private IEntradaDetalleDao entradaDetalleDao;
	
	@Autowired
	private IEntradaDao entradaDao;
	
	@Autowired
	private ILibroDao libroDao;
	
	//@Autowired
	//private ILibroDao libroDao;

	@Override
	@Transactional
	public EntradaDetalleDTO save(EntradaDetalleDTO dto) {
		final EntradaDetalleDomain domain = convertDtoToDomain(dto);
		final EntradaDetalleDomain entradaDetalleDomain = entradaDetalleDao.save(domain);
		return convertDomainToDto(entradaDetalleDomain);
	}

	@Override
	@Transactional
	public EntradaDetalleDTO getById(Integer id) throws BibliotecaException {
		final EntradaDetalleDomain domain = entradaDetalleDao.getById(id);
		final EntradaDetalleDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public EntradaDetalleResult getAll() {
		final List<EntradaDetalleDTO> entradaDetalle = new ArrayList<>();
		for (EntradaDetalleDomain domain : entradaDetalleDao.findAll()) {
			final EntradaDetalleDTO dto = convertDomainToDto(domain);
			entradaDetalle.add(dto);
		}
		final EntradaDetalleResult entradaDetalleResult = new EntradaDetalleResult();
		entradaDetalleResult.setEntradaDetalles(entradaDetalle);
		return entradaDetalleResult;
	}

	@Override
	@Transactional
	public EntradaDetalleResult find(String textToFind) {
		final List<EntradaDetalleDTO> entradaDetalles = new ArrayList<>();
		for (EntradaDetalleDomain domain : entradaDetalleDao.find(textToFind)) {
			final EntradaDetalleDTO dto = convertDomainToDto(domain);
			entradaDetalles.add(dto);
		}
		final EntradaDetalleResult entradaDetalleResult = new EntradaDetalleResult();
		entradaDetalleResult.setEntradaDetalles(entradaDetalles);
		return entradaDetalleResult;
	}

	@Override
	protected EntradaDetalleDTO convertDomainToDto(EntradaDetalleDomain domain) {
		final EntradaDetalleDTO dto = new EntradaDetalleDTO();
		dto.setId(domain.getId());
		dto.setCantidad(domain.getCantidad());
		dto.setEntradaId(domain.getEntrada().getId());
		dto.setLibroId(domain.getLibro().getId());
		return dto;
	}

	@Override
	protected EntradaDetalleDomain convertDtoToDomain(EntradaDetalleDTO dto) {
		final EntradaDetalleDomain domain = new EntradaDetalleDomain();
		domain.setId(dto.getId());
		domain.setCantidad(dto.getCantidad());
		domain.setEntrada(entradaDao.getById(dto.getEntradaId()));
		domain.setLibro(libroDao.getById(dto.getLibroId()));
		
		return domain;
	}

}
