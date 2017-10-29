package com.sd.uni.biblioteca.service.estado_general;

import com.sd.uni.biblioteca.dao.estado_general.Estado_generalDaoImpl;
import com.sd.uni.biblioteca.domain.estado_general.Estado_generalDomain;
import com.sd.uni.biblioteca.dto.estado_general.Estado_generalDTO;
import com.sd.uni.biblioteca.dto.estado_general.Estado_generalResult;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IEstado_generalService extends IBaseService<Estado_generalDTO, Estado_generalDomain, Estado_generalDaoImpl, Estado_generalResult> {

	public Estado_generalResult find(String textToFind);
}

