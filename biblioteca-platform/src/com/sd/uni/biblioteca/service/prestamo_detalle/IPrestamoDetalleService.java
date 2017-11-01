package com.sd.uni.biblioteca.service.prestamo_detalle;

import com.sd.uni.biblioteca.dao.prestamo_detalle.PrestamoDetalleDaoImpl;
import com.sd.uni.biblioteca.domain.prestamo_detalle.PrestamoDetalleDomain;
import com.sd.uni.biblioteca.dto.prestamo_detalle.PrestamoDetalleDTO;
import com.sd.uni.biblioteca.dto.prestamo_detalle.PrestamoDetalleResult;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IPrestamoDetalleService extends IBaseService<PrestamoDetalleDTO, PrestamoDetalleDomain, PrestamoDetalleDaoImpl, PrestamoDetalleResult> {

	public PrestamoDetalleResult find(String textToFind);
}

