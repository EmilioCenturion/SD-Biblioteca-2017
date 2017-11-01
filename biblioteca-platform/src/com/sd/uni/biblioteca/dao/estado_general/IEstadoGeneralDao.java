package com.sd.uni.biblioteca.dao.estado_general;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.estado_general.EstadoGeneralDomain;

public interface IEstadoGeneralDao extends IBaseDao<EstadoGeneralDomain> {

	public List<EstadoGeneralDomain>find(String textToFind);
}
