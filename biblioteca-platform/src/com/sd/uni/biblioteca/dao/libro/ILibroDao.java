package com.sd.uni.biblioteca.dao.libro;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.libro.LibroDomain;

public interface ILibroDao extends IBaseDao<LibroDomain> {
	
	public List<LibroDomain>find(String textToFind);

}
