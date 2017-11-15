package com.sd.uni.biblioteca.rest.estadoGeneral;

import com.sd.uni.biblioteca.dto.estado_general.EstadoGeneralDTO;
import com.sd.uni.biblioteca.dto.estado_general.EstadoGeneralResult;
import com.sd.uni.biblioteca.rest.base.IBaseResource;

public interface IEstadoGeneralResource extends IBaseResource<EstadoGeneralDTO> {

	public EstadoGeneralResult getAll();
}