package com.sd.uni.biblioteca.dao.entrada;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.entrada.EntradaDomain;

public interface IEntradaDao extends IBaseDao<EntradaDomain> {

	public List<EntradaDomain>find(String textToFind);
}
