package com.sd.uni.biblioteca.rest.entrada;

import com.sd.uni.biblioteca.dto.entrada.EntradaDTO;
import com.sd.uni.biblioteca.dto.entrada.EntradaResult;
import com.sd.uni.biblioteca.rest.base.IBaseResource;

public interface IEntradaResource extends IBaseResource<EntradaDTO> {

	public EntradaResult getAll();
}
