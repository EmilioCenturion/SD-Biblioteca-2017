package com.sd.uni.biblioteca.service.estado_general;

import com.sd.uni.biblioteca.dao.estado_general.EstadoGeneralDaoImpl;
import com.sd.uni.biblioteca.domain.estado_general.EstadoGeneralDomain;
import com.sd.uni.biblioteca.dto.estado_general.EstadoGeneralDTO;
import com.sd.uni.biblioteca.dto.estado_general.EstadoGeneralResult;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IEstadoGeneralService extends IBaseService<EstadoGeneralDTO, EstadoGeneralDomain, EstadoGeneralDaoImpl, EstadoGeneralResult> {

	public EstadoGeneralResult find(String textToFind);
}

