package com.sd.uni.biblioteca.service.disponibilidad;

import com.sd.uni.biblioteca.dao.disponibilidad.DisponibilidadDaoImpl;
import com.sd.uni.biblioteca.domain.disponibilidad.DisponibilidadDomain;
import com.sd.uni.biblioteca.dto.disponibilidad.DisponibilidadDTO;
import com.sd.uni.biblioteca.dto.disponibilidad.DisponibilidadResult;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IDisponibilidadService extends IBaseService<DisponibilidadDTO, DisponibilidadDomain, DisponibilidadDaoImpl, DisponibilidadResult> {

	public DisponibilidadResult find(String textToFind);
}
