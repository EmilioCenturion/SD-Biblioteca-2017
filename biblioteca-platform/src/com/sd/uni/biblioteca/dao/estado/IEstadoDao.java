package com.sd.uni.biblioteca.dao.estado;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.estado.EstadoDomain;

public interface IEstadoDao extends IBaseDao<EstadoDomain> {

	public List<EstadoDomain>find(String textToFind);
}