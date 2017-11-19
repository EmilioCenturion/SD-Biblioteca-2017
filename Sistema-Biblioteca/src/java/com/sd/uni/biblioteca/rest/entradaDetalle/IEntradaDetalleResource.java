package com.sd.uni.biblioteca.rest.entradaDetalle;

import com.sd.uni.biblioteca.dto.entradaDetalle.EntradaDetalleDTO;
import com.sd.uni.biblioteca.dto.entradaDetalle.EntradaDetalleResult;
import com.sd.uni.biblioteca.rest.base.IBaseResource;

public interface IEntradaDetalleResource extends IBaseResource<EntradaDetalleDTO> {

	public EntradaDetalleResult getAll();
}
