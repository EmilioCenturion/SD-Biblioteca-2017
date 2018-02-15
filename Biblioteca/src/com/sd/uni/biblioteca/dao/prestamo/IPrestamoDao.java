package com.sd.uni.biblioteca.dao.prestamo;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.prestamo.PrestamoDomain;

public interface IPrestamoDao extends IBaseDao<PrestamoDomain> {

	public List<PrestamoDomain>find(String textToFind);
}

