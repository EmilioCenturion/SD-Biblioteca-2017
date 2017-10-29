package com.sd.uni.biblioteca.service.entradaDetalle;

import com.sd.uni.biblioteca.dao.entradaDetalle.EntradaDetalleDaoImpl;
import com.sd.uni.biblioteca.domain.entradaDetalle.EntradaDetalleDomain;
import com.sd.uni.biblioteca.dto.entradaDetalle.EntradaDetalleDTO;
import com.sd.uni.biblioteca.dto.entradaDetalle.EntradaDetalleResult;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IEntradaDetalleService extends IBaseService<EntradaDetalleDTO, EntradaDetalleDomain, EntradaDetalleDaoImpl, EntradaDetalleResult> {

	public EntradaDetalleResult find(String textToFind);
}

