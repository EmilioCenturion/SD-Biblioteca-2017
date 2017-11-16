package com.sd.uni.biblioteca.rest.salida;

import com.sd.uni.biblioteca.dto.salida.SalidaDTO;
import com.sd.uni.biblioteca.dto.salida.SalidaResult;
import com.sd.uni.biblioteca.rest.base.IBaseResource;

public interface ISalidaResource extends IBaseResource<SalidaDTO> {
	public SalidaResult getAll();

}
