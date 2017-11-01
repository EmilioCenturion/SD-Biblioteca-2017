package com.sd.uni.biblioteca.service.libro;

import com.sd.uni.biblioteca.dao.libro.LibroDaoImpl;
import com.sd.uni.biblioteca.domain.libro.LibroDomain;
import com.sd.uni.biblioteca.dto.libro.LibroDTO;
import com.sd.uni.biblioteca.dto.libro.LibroResult;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface ILibroService extends IBaseService<LibroDTO, LibroDomain, LibroDaoImpl, LibroResult> {

	public LibroResult find(String textToFind);
}