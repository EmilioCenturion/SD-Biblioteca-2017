package com.sd.uni.biblioteca.service.salidaDetalle;

import com.sd.uni.biblioteca.dao.salidaDetalle.SalidaDetalleDaoImpl;
import com.sd.uni.biblioteca.domain.salidaDetalle.SalidaDetalleDomain;
import com.sd.uni.biblioteca.dto.salidaDetalle.SalidaDetalleDTO;
import com.sd.uni.biblioteca.dto.salidaDetalle.SalidaDetalleResult;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface ISalidaDetalleService extends IBaseService<SalidaDetalleDTO, SalidaDetalleDomain, SalidaDetalleDaoImpl, SalidaDetalleResult> {

	public SalidaDetalleResult find(String textToFind);
}

