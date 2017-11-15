package com.sd.uni.biblioteca.rest.prestamoDetalle;

import com.sd.uni.biblioteca.dto.prestamo_detalle.PrestamoDetalleDTO;
import com.sd.uni.biblioteca.dto.prestamo_detalle.PrestamoDetalleResult;
import com.sd.uni.biblioteca.rest.base.IBaseResource;

public interface IPrestamoDetalleResource extends IBaseResource<PrestamoDetalleDTO> {

	public PrestamoDetalleResult getAll();
}