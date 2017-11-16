package com.sd.uni.biblioteca.rest.motivoSalida;

import com.sd.uni.biblioteca.dto.motivoSalida.MotivoSalidaDTO;
import com.sd.uni.biblioteca.dto.motivoSalida.MotivoSalidaResult;
import com.sd.uni.biblioteca.rest.base.IBaseResource;

public interface IMotivoSalidaResource extends IBaseResource<MotivoSalidaDTO> {
	public MotivoSalidaResult getAll();
}
