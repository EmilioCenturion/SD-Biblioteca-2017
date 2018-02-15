package com.sd.uni.biblioteca.service.estado;

import com.sd.uni.biblioteca.dao.estado.EstadoDaoImpl;
import com.sd.uni.biblioteca.domain.estado.EstadoDomain;
import com.sd.uni.biblioteca.dto.estado.EstadoDTO;
import com.sd.uni.biblioteca.dto.estado.EstadoResult;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IEstadoService extends IBaseService<EstadoDTO, EstadoDomain, EstadoDaoImpl, EstadoResult> {

	public EstadoResult find(String textToFind);
}
