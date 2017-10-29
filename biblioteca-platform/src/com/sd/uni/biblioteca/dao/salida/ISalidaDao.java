package com.sd.uni.biblioteca.dao.salida;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.salida.SalidaDomain;

public interface ISalidaDao extends IBaseDao<SalidaDomain> {
	
	public List<SalidaDomain>find(String textToFind);

}
