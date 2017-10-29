package com.sd.uni.biblioteca.dao.estado_general;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.estado_general.Estado_generalDomain;

public interface IEstado_generalDao extends IBaseDao<Estado_generalDomain> {

	public List<Estado_generalDomain>find(String textToFind);
}
