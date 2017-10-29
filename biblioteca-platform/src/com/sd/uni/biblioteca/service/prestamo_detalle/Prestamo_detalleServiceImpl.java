package com.sd.uni.biblioteca.service.prestamo_detalle;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.dao.rol.IRolDao;
import com.sd.uni.biblioteca.dao.prestamo_detalle.IPrestamo_detalleDao;
import com.sd.uni.biblioteca.dao.prestamo_detalle.Prestamo_detalleDaoImpl;
import com.sd.uni.biblioteca.domain.prestamo_detalle.Prestamo_detalleDomain;
import com.sd.uni.biblioteca.dto.prestamo_detalle.Prestamo_detalleDTO;
import com.sd.uni.biblioteca.dto.prestamo_detalle.Prestamo_detalleResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class Prestamo_detalleServiceImpl extends BaseServiceImpl<Prestamo_detalleDTO, Prestamo_detalleDomain, Prestamo_detalleDaoImpl, Prestamo_detalleResult>
		implements IPrestamo_detalleService {
	@Autowired
	private IPrestamo_detalleDao prestamo_detalleDao;
	
	@Override
	@Transactional
	public Prestamo_detalleDTO save(Prestamo_detalleDTO dto) {
		final Prestamo_detalleDomain domain = convertDtoToDomain(dto);
		final Prestamo_detalleDomain prestamo_detalleDomain = prestamo_detalleDao.save(domain);
		return convertDomainToDto(prestamo_detalleDomain);
	}

	@Override
	@Transactional
	public Prestamo_detalleDTO getById(Integer id) throws BibliotecaException {
		final Prestamo_detalleDomain domain = prestamo_detalleDao.getById(id);
		final Prestamo_detalleDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public Prestamo_detalleResult getAll() {
		final List<Prestamo_detalleDTO> prestamo_detalle = new ArrayList<>();
		for (Prestamo_detalleDomain domain : prestamo_detalleDao.findAll()) {
			final Prestamo_detalleDTO dto = convertDomainToDto(domain);
			prestamo_detalle.add(dto);
		}
		final Prestamo_detalleResult prestamo_detalleResult = new Prestamo_detalleResult();
		prestamo_detalleResult.setprestamos_detalles(prestamo_detalle);
		return prestamo_detalleResult;
	}


	@Override
	protected Prestamo_detalleDTO convertDomainToDto(Prestamo_detalleDomain domain) {
		final Prestamo_detalleDTO dto = new Prestamo_detalleDTO();
		dto.setId(domain.getId());
		dto.setPrestamo(domain.getPrestamo().getId());
		dto.setLibro(domain.getLibro().getId());
		dto.setEstado(domain.getEstado());
		dto.setFecha_devolucion(domain.getFecha_devolucion());
		return dto;
	}

	@Override
	protected Prestamo_detalleDomain convertDtoToDomain(Prestamo_detalleDTO dto) {
		final Prestamo_detalleDomain domain = new Prestamo_detalleDomain();
		domain.setId(domain.getId());
		domain.setPrestamo(domain.getPrestamo().getId());
		domain.setLibro(domain.getLibro().getId());
		domain.setEstado(domain.getEstado());
		domain.setFecha_devolucion(domain.getFecha_devolucion());
		
		return domain;
	}

}
