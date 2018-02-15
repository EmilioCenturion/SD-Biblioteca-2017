package com.sd.uni.biblioteca.service.reservaDetalle;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




import com.sd.uni.biblioteca.dao.reserva.IReservaDao;
import com.sd.uni.biblioteca.dao.reservaDetalle.IReservaDetalleDao;
import com.sd.uni.biblioteca.dao.reservaDetalle.ReservaDetalleDaoImpl;
import com.sd.uni.biblioteca.domain.reservaDetalle.ReservaDetalleDomain;
import com.sd.uni.biblioteca.dto.reservaDetalle.ReservaDetalleDTO;
import com.sd.uni.biblioteca.dto.reservaDetalle.ReservaDetalleResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class ReservaDetalleServiceImpl extends BaseServiceImpl<ReservaDetalleDTO, ReservaDetalleDomain, ReservaDetalleDaoImpl, ReservaDetalleResult>
		implements IReservaDetalleService {
	@Autowired
	private IReservaDetalleDao reservaDetalleDao;
	
	@Autowired
	private IReservaDao reservaDao;
	
	//@Autowired
	//private ILibroDao libroDao;

	@Override
	@Transactional
	public ReservaDetalleDTO save(ReservaDetalleDTO dto) {
		final ReservaDetalleDomain domain = convertDtoToDomain(dto);
		final ReservaDetalleDomain reservaDetalleDomain = reservaDetalleDao.save(domain);
		return convertDomainToDto(reservaDetalleDomain);
	}

	@Override
	@Transactional
	public ReservaDetalleDTO getById(Integer id) throws BibliotecaException {
		final ReservaDetalleDomain domain = reservaDetalleDao.getById(id);
		final ReservaDetalleDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public ReservaDetalleResult getAll() {
		final List<ReservaDetalleDTO> reservaDetalle = new ArrayList<>();
		for (ReservaDetalleDomain domain : reservaDetalleDao.findAll()) {
			final ReservaDetalleDTO dto = convertDomainToDto(domain);
			reservaDetalle.add(dto);
		}
		final ReservaDetalleResult reservaDetalleResult = new ReservaDetalleResult();
		reservaDetalleResult.setReservaDetalles(reservaDetalle);
		return reservaDetalleResult;
	}

	@Override
	@Transactional
	public ReservaDetalleResult find(String textToFind) {
		final List<ReservaDetalleDTO> reservaDetalles = new ArrayList<>();
		for (ReservaDetalleDomain domain : reservaDetalleDao.find(textToFind)) {
			final ReservaDetalleDTO dto = convertDomainToDto(domain);
			reservaDetalles.add(dto);
		}
		final ReservaDetalleResult reservaDetalleResult = new ReservaDetalleResult();
		reservaDetalleResult.setReservaDetalles(reservaDetalles);
		return reservaDetalleResult;
	}

	@Override
	protected ReservaDetalleDTO convertDomainToDto(ReservaDetalleDomain domain) {
		final ReservaDetalleDTO dto = new ReservaDetalleDTO();
		dto.setId(domain.getId());
		dto.setReservaId(domain.getReserva().getId());
		dto.setLibroId(domain.getLibro().getId());
		return dto;
	}

	@Override
	protected ReservaDetalleDomain convertDtoToDomain(ReservaDetalleDTO dto) {
		final ReservaDetalleDomain domain = new ReservaDetalleDomain();
		domain.setId(dto.getId());
		domain.setReserva(reservaDao.getById(dto.getReservaId()));
		//domain.setLibro(libroDao.getById(dto.getLibroId()));
		
		return domain;
	}

}



