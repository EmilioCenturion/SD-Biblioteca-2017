package com.sd.uni.biblioteca.rest.categoria;


import com.sd.uni.biblioteca.dto.categoria.CategoriaDTO;
import com.sd.uni.biblioteca.dto.categoria.CategoriaResult;
import com.sd.uni.biblioteca.rest.base.IBaseResource;

public interface ICategoriaResource extends IBaseResource<CategoriaDTO> {
	public CategoriaResult getAll();
}
