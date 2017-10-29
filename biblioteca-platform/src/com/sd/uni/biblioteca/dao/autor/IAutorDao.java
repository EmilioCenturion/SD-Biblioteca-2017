package com.sd.uni.biblioteca.dao.autor;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.autor.AutorDomain;

public interface IAutorDao extends IBaseDao<AutorDomain> {

	public List<AutorDomain>find(String textToFind);
}
