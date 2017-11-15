package com.sd.uni.biblioteca.rest.disponibilidad;

import com.sd.uni.biblioteca.dto.disponibilidad.DisponibilidadDTO;
import com.sd.uni.biblioteca.dto.disponibilidad.DisponibilidadResult;
import com.sd.uni.biblioteca.rest.base.IBaseResource;

public interface IDisponibilidadResource extends IBaseResource<DisponibilidadDTO> {

	public DisponibilidadResult getAll();
}
