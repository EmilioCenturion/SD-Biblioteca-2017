package com.sd.uni.biblioteca.dao.autor;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.autor.AutorDomain;

import java.util.List;


public interface IAutorDao extends IBaseDao<AutorDomain>{
	public List<AutorDomain>find(String textToFind);

	public List<AutorDomain> find(String textToFind, int page, int maxItems);
}
