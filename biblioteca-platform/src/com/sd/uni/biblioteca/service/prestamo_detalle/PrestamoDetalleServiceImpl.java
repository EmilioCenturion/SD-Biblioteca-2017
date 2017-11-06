package com.sd.uni.biblioteca.service.prestamo_detalle;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.dao.rol.IRolDao;
import com.sd.uni.biblioteca.dao.prestamo_detalle.IPrestamoDetalleDao;
import com.sd.uni.biblioteca.dao.prestamo_detalle.PrestamoDetalleDaoImpl;
import com.sd.uni.biblioteca.domain.prestamo_detalle.PrestamoDetalleDomain;
import com.sd.uni.biblioteca.dto.prestamo_detalle.PrestamoDetalleDTO;
import com.sd.uni.biblioteca.dto.prestamo_detalle.PrestamoDetalleResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class PrestamoDetalleServiceImpl extends BaseServiceImpl<PrestamoDetalleDTO, PrestamoDetalleDomain, PrestamoDetalleDaoImpl, PrestamoDetalleResult>
		implements IPrestamoDetalleService {
	
	@Autowired
	private IPrestamoDetalleDao prestamoDetalleDao;
	
	@Override
	@Transactional
	public PrestamoDetalleDTO save(PrestamoDetalleDTO dto) {
		final PrestamoDetalleDomain domain = convertDtoToDomain(dto);
		final PrestamoDetalleDomain prestamo_detalleDomain = prestamoDetalleDao.save(domain);
		return convertDomainToDto(prestamo_detalleDomain);
	}

	@Override
	@Transactional
	public PrestamoDetalleDTO getById(Integer id) throws BibliotecaException {
		final PrestamoDetalleDomain domain = prestamoDetalleDao.getById(id);
		final PrestamoDetalleDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public PrestamoDetalleResult getAll() {
		final List<PrestamoDetalleDTO> prestamo_detalle = new ArrayList<>();
		for (PrestamoDetalleDomain domain : prestamoDetalleDao.findAll()) {
			final PrestamoDetalleDTO dto = convertDomainToDto(domain);
			prestamo_detalle.add(dto);
		}
		final PrestamoDetalleResult prestamoDetalleResult = new PrestamoDetalleResult();
		prestamoDetalleResult.setPrestamoDetalles(prestamo_detalle);
		return prestamoDetalleResult;
	}


	@Override
	protected PrestamoDetalleDTO convertDomainToDto(PrestamoDetalleDomain domain) {
		final PrestamoDetalleDTO dto = new PrestamoDetalleDTO();
		dto.setId(domain.getId());
		dto.setPrestamoId(domain.getPrestamo().getId());
		dto.setLibroId(domain.getLibro().getId());
		dto.setEstadoId(domain.getEstado().getId());
		dto.setFecha_devolucion(domain.getFecha_devolucion());
		return dto;
	}

	@Override
	protected PrestamoDetalleDomain convertDtoToDomain(PrestamoDetalleDTO dto) {
		final PrestamoDetalleDomain domain = new PrestamoDetalleDomain();
		domain.setId(domain.getId());
		domain.setPrestamo(domain.getPrestamo());
		domain.setLibro(domain.getLibro());
		domain.setEstado(domain.getEstado());
		domain.setFecha_devolucion(domain.getFecha_devolucion());
		
		return domain;
	}

	@Override
	public PrestamoDetalleResult find(String textToFind) {
		// TODO Auto-generated method stub
		return null;
	}

}
