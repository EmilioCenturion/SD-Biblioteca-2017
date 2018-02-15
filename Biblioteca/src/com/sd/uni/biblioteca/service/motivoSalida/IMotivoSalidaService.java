package com.sd.uni.biblioteca.service.motivoSalida;

import com.sd.uni.biblioteca.dao.motivoSalida.MotivoSalidaDaoImpl;
import com.sd.uni.biblioteca.domain.motivo_salida.MotivoSalidaDomain;
import com.sd.uni.biblioteca.dto.motivoSalida.MotivoSalidaDTO;
import com.sd.uni.biblioteca.dto.motivoSalida.MotivoSalidaResult;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IMotivoSalidaService extends IBaseService<MotivoSalidaDTO, MotivoSalidaDomain, MotivoSalidaDaoImpl, MotivoSalidaResult> {

	public MotivoSalidaResult find(String textToFind);
}
