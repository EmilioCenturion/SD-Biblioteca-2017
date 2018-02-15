package com.sd.uni.biblioteca.service.salida;

import java.text.ParseException;

import com.sd.uni.biblioteca.dao.salida.SalidaDaoImpl;
import com.sd.uni.biblioteca.domain.salida.SalidaDomain;
import com.sd.uni.biblioteca.dto.salida.SalidaDTO;
import com.sd.uni.biblioteca.dto.salida.SalidaResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface ISalidaService extends IBaseService<SalidaDTO, SalidaDomain, SalidaDaoImpl, SalidaResult> {

	public SalidaResult find(String textToFind);

	public SalidaResult find(String textToFind, int page, int maxItems)
			throws BibliotecaException, ParseException;
}
