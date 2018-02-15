package com.sd.uni.biblioteca.service.categoria;

import com.sd.uni.biblioteca.dao.categoria.CategoriaDaoImpl;
import com.sd.uni.biblioteca.domain.categoria.CategoriaDomain;
import com.sd.uni.biblioteca.dto.categoria.CategoriaDTO;
import com.sd.uni.biblioteca.dto.categoria.CategoriaResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface ICategoriaService extends IBaseService<CategoriaDTO, CategoriaDomain, CategoriaDaoImpl, CategoriaResult> {

	public CategoriaResult find(String textToFind);

	public CategoriaResult find(String textToFind, int page, int maxItems)
			throws BibliotecaException;
}
