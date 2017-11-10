package com.sd.uni.biblioteca.dao.salida;

import java.text.ParseException;
import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.salida.SalidaDomain;
import com.sd.uni.biblioteca.exception.BibliotecaException;

public interface ISalidaDao extends IBaseDao<SalidaDomain> {
	
	public List<SalidaDomain>find(String textToFind);

	public List<SalidaDomain> find(String textToFind, int page, int maxItems) throws BibliotecaException, ParseException;

}
