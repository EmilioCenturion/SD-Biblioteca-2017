package com.sd.uni.biblioteca.service.motivoEntrada;

import com.sd.uni.biblioteca.dao.motivoEntrada.MotivoEntradaDaoImpl;
import com.sd.uni.biblioteca.domain.motivoEntrada.MotivoEntradaDomain;
import com.sd.uni.biblioteca.dto.motivoEntrada.MotivoEntradaDTO;
import com.sd.uni.biblioteca.dto.motivoEntrada.MotivoEntradaResult;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IMotivoEntradaService extends IBaseService<MotivoEntradaDTO, MotivoEntradaDomain, MotivoEntradaDaoImpl, MotivoEntradaResult> {

	public MotivoEntradaResult find(String textToFind);
}