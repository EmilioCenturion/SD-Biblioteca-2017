package com.sd.uni.biblioteca.rest.salidaDetalle;

import com.sd.uni.biblioteca.dto.salidaDetalle.SalidaDetalleDTO;
import com.sd.uni.biblioteca.dto.salidaDetalle.SalidaDetalleResult;
import com.sd.uni.biblioteca.rest.base.IBaseResource;

public interface ISalidaDetalleResource extends IBaseResource<SalidaDetalleDTO> {

	public SalidaDetalleResult getAll();
}
