package com.sd.uni.biblioteca.dao.entrada;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.entrada.EntradaDomain;
import com.sd.uni.biblioteca.domain.salida.SalidaDomain;
import com.sd.uni.biblioteca.exception.BibliotecaException;

public interface IEntradaDao extends IBaseDao<EntradaDomain> {

	public List<EntradaDomain>find(String textToFind);

	public List<EntradaDomain> find(String textToFind, int page, int maxItems)
			throws BibliotecaException;
}
