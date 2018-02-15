package com.sd.uni.biblioteca.service.categoria;


import java.util.List;

import com.sd.uni.biblioteca.beans.categoria.CategoriaB;
import com.sd.uni.biblioteca.dto.categoria.CategoriaDTO;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface ICategoriaService extends IBaseService<CategoriaB, CategoriaDTO> {

	List<CategoriaB> find(int page, int maxItems);

	List<CategoriaB> find(String textToFind, int page, int maxItems);

}
