package com.sd.uni.biblioteca.rest.prestamo;

import com.sd.uni.biblioteca.dto.prestamo.PrestamoDTO;
import com.sd.uni.biblioteca.dto.prestamo.PrestamoResult;
import com.sd.uni.biblioteca.rest.base.IBaseResource;

public interface IPrestamoResource extends IBaseResource<PrestamoDTO> {

	public PrestamoResult getAll();
}
