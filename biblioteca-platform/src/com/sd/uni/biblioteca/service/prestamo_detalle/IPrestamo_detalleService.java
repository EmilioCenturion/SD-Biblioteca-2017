package com.sd.uni.biblioteca.service.prestamo_detalle;

import com.sd.uni.biblioteca.dao.prestamo_detalle.Prestamo_detalleDaoImpl;
import com.sd.uni.biblioteca.domain.prestamo_detalle.Prestamo_detalleDomain;
import com.sd.uni.biblioteca.dto.prestamo_detalle.Prestamo_detalleDTO;
import com.sd.uni.biblioteca.dto.prestamo_detalle.Prestamo_detalleResult;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IPrestamo_detalleService extends IBaseService<Prestamo_detalleDTO, Prestamo_detalleDomain, Prestamo_detalleDaoImpl, Prestamo_detalleResult> {

	public Prestamo_detalleResult find(String textToFind);
}

