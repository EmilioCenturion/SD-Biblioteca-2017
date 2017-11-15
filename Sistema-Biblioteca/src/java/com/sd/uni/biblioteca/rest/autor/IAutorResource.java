package com.sd.uni.biblioteca.rest.autor;


import com.sd.uni.biblioteca.dto.autor.AutorDTO;
import com.sd.uni.biblioteca.dto.autor.AutorResult;
import com.sd.uni.biblioteca.rest.base.IBaseResource;

public interface IAutorResource extends IBaseResource<AutorDTO> {
	public AutorResult getAll();
}
