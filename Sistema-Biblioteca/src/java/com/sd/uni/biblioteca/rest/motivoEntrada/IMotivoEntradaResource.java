package com.sd.uni.biblioteca.rest.motivoEntrada;


import com.sd.uni.biblioteca.dto.motivoEntrada.MotivoEntradaDTO;
import com.sd.uni.biblioteca.dto.motivoEntrada.MotivoEntradaResult;
import com.sd.uni.biblioteca.rest.base.IBaseResource;

public interface IMotivoEntradaResource extends IBaseResource<MotivoEntradaDTO> {
	public MotivoEntradaResult getAll();
}
