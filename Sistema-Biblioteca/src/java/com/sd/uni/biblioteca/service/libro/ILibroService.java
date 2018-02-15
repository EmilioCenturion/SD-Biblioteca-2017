package com.sd.uni.biblioteca.service.libro;


import java.util.List;

import com.sd.uni.biblioteca.beans.libro.LibroB;
import com.sd.uni.biblioteca.dto.libro.LibroDTO;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface ILibroService extends IBaseService<LibroB, LibroDTO> {

	List<LibroB> find(int page, int maxItems);

	List<LibroB> find(String textToFind, int page, int maxItems);

}
