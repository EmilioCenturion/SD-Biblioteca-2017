package com.sd.uni.biblioteca.service.reservaDetalle;

import com.sd.uni.biblioteca.dao.reservaDetalle.ReservaDetalleDaoImpl;
import com.sd.uni.biblioteca.domain.reservaDetalle.ReservaDetalleDomain;
import com.sd.uni.biblioteca.dto.reservaDetalle.ReservaDetalleDTO;
import com.sd.uni.biblioteca.dto.reservaDetalle.ReservaDetalleResult;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IReservaDetalleService extends IBaseService<ReservaDetalleDTO, ReservaDetalleDomain, ReservaDetalleDaoImpl, ReservaDetalleResult> {

	public ReservaDetalleResult find(String textToFind);
}
