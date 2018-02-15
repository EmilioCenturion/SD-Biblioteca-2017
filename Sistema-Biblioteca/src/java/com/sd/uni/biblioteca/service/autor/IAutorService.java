package com.sd.uni.biblioteca.service.autor;


import java.util.List;

import com.sd.uni.biblioteca.beans.autor.AutorB;
import com.sd.uni.biblioteca.dto.autor.AutorDTO;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IAutorService extends IBaseService<AutorB, AutorDTO> {

	List<AutorB> find(String textToFind, int page, int maxItems);

	List<AutorB> find(int page, int maxItems);

}
