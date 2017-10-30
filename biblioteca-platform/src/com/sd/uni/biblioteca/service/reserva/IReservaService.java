package com.sd.uni.biblioteca.service.reserva;

import com.sd.uni.biblioteca.dao.reserva.ReservaDaoImpl;
import com.sd.uni.biblioteca.domain.reserva.ReservaDomain;
import com.sd.uni.biblioteca.dto.reserva.ReservaDTO;
import com.sd.uni.biblioteca.dto.reserva.ReservaResult;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IReservaService extends IBaseService<ReservaDTO, ReservaDomain, ReservaDaoImpl, ReservaResult> {

	public ReservaResult find(String textToFind);
}

