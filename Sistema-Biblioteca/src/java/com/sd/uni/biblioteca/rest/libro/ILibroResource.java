package com.sd.uni.biblioteca.rest.libro;


import com.sd.uni.biblioteca.dto.libro.LibroDTO;
import com.sd.uni.biblioteca.dto.libro.LibroResult;
import com.sd.uni.biblioteca.rest.base.IBaseResource;

public interface ILibroResource extends IBaseResource<LibroDTO> {
	public LibroResult getAll();

	LibroResult find(int page, int maxItems);

	LibroResult find(String textToFind, int maxItems, int page);
}
