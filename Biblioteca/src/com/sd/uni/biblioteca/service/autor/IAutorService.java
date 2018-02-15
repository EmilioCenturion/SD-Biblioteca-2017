package com.sd.uni.biblioteca.service.autor;

import com.sd.uni.biblioteca.dao.autor.AutorDaoImpl;
import com.sd.uni.biblioteca.domain.autor.AutorDomain;
import com.sd.uni.biblioteca.dto.autor.AutorDTO;
import com.sd.uni.biblioteca.dto.autor.AutorResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IAutorService extends IBaseService<AutorDTO, AutorDomain, AutorDaoImpl, AutorResult> {

	public AutorResult find(String textToFind);

	public AutorResult find(String textToFind, int page, int maxItems)
			throws BibliotecaException;
}
