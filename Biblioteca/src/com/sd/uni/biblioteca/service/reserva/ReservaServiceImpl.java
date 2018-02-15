package com.sd.uni.biblioteca.service.reserva;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;











import com.sd.uni.biblioteca.dao.reserva.IReservaDao;
import com.sd.uni.biblioteca.dao.reserva.ReservaDaoImpl;
import com.sd.uni.biblioteca.dao.usuario.IUsuarioDao;
import com.sd.uni.biblioteca.domain.reserva.ReservaDomain;
import com.sd.uni.biblioteca.dto.reserva.ReservaDTO;
import com.sd.uni.biblioteca.dto.reserva.ReservaResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class ReservaServiceImpl extends BaseServiceImpl<ReservaDTO, ReservaDomain, ReservaDaoImpl, ReservaResult>
		implements IReservaService {
	@Autowired
	private IReservaDao reservaDao;
	
	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional
	public ReservaDTO save(ReservaDTO dto) {
		final ReservaDomain domain = convertDtoToDomain(dto);
		final ReservaDomain reservaDomain = reservaDao.save(domain);
		return convertDomainToDto(reservaDomain);
	}

	@Override
	@Transactional
	public ReservaDTO getById(Integer id) throws BibliotecaException {
		final ReservaDomain domain = reservaDao.getById(id);
		final ReservaDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public ReservaResult getAll() {
		final List<ReservaDTO> reserva = new ArrayList<>();
		for (ReservaDomain domain : reservaDao.findAll()) {
			final ReservaDTO dto = convertDomainToDto(domain);
			reserva.add(dto);
		}
		final ReservaResult reservaResult = new ReservaResult();
		reservaResult.setReservas(reserva);
		return reservaResult;
	}

	@Override
	@Transactional
	public ReservaResult find(String textToFind) {
		final List<ReservaDTO> reservas = new ArrayList<>();
		for (ReservaDomain domain : reservaDao.find(textToFind)) {
			final ReservaDTO dto = convertDomainToDto(domain);
			reservas.add(dto);
		}
		final ReservaResult reservaResult = new ReservaResult();
		reservaResult.setReservas(reservas);
		return reservaResult;
	}

	@Override
	protected ReservaDTO convertDomainToDto(ReservaDomain domain) {
		final ReservaDTO dto = new ReservaDTO();
		dto.setId(domain.getId());
		dto.setFechaPedido(domain.getFechaPedido());
		dto.setFechaReserva(domain.getFechaReserva());
		dto.setUsuarioId(domain.getUsuario().getId());
		return dto;
	}

	@Override
	protected ReservaDomain convertDtoToDomain(ReservaDTO dto) {
		final ReservaDomain domain = new ReservaDomain();
		domain.setId(dto.getId());
		domain.setFechaPedido(dto.getFechaPedido());
		domain.setFechaReserva(dto.getFechaReserva());
		domain.setUsuario(usuarioDao.getById(dto.getUsuarioId()));
		
		return domain;
	}

}

