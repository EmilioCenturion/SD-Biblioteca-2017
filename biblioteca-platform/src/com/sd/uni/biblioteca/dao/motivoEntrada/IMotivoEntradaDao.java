package com.sd.uni.biblioteca.dao.motivoEntrada;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.motivoEntrada.MotivoEntradaDomain;

public interface IMotivoEntradaDao extends IBaseDao<MotivoEntradaDomain> {

	public List<MotivoEntradaDomain>find(String textToFind);
}

