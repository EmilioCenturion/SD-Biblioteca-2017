package com.sd.uni.biblioteca.rest.estado;

import com.sd.uni.biblioteca.dto.estado.EstadoDTO;
import com.sd.uni.biblioteca.dto.estado.EstadoResult;
import com.sd.uni.biblioteca.rest.base.IBaseResource;

public interface IEstadoResource extends IBaseResource<EstadoDTO> {

	public EstadoResult getAll();
}
