package com.sd.uni.biblioteca.service.entrada;

import com.sd.uni.biblioteca.dao.entrada.EntradaDaoImpl;
import com.sd.uni.biblioteca.domain.entrada.EntradaDomain;
import com.sd.uni.biblioteca.dto.entrada.EntradaDTO;
import com.sd.uni.biblioteca.dto.entrada.EntradaResult;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IEntradaService extends IBaseService<EntradaDTO, EntradaDomain, EntradaDaoImpl, EntradaResult> {

	public EntradaResult find(String textToFind);
}
