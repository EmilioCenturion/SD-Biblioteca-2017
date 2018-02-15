package com.sd.uni.biblioteca.service.libro;

import com.sd.uni.biblioteca.dao.libro.LibroDaoImpl;
import com.sd.uni.biblioteca.domain.libro.LibroDomain;
import com.sd.uni.biblioteca.dto.libro.LibroDTO;
import com.sd.uni.biblioteca.dto.libro.LibroResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.exception.StockException;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface ILibroService extends IBaseService<LibroDTO, LibroDomain, LibroDaoImpl, LibroResult> {

	public LibroResult find(String textToFind);

	public LibroResult find(String textToFind, int page, int maxItems)
			throws BibliotecaException;

	LibroDTO entrada(Integer id, Integer cantidad) throws BibliotecaException;

	LibroDTO salida(Integer id, Integer cantidad) throws BibliotecaException,
			StockException;
}