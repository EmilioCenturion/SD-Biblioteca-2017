package com.sd.uni.biblioteca.service.prestamo;

import com.sd.uni.biblioteca.dao.prestamo.PrestamoDaoImpl;
import com.sd.uni.biblioteca.domain.prestamo.PrestamoDomain;
import com.sd.uni.biblioteca.dto.prestamo.PrestamoDTO;
import com.sd.uni.biblioteca.dto.prestamo.PrestamoResult;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IPrestamoService extends IBaseService<PrestamoDTO, PrestamoDomain, PrestamoDaoImpl, PrestamoResult> {

	public PrestamoResult find(String textToFind);
}
