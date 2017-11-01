package com.sd.uni.biblioteca.dao.prestamo_detalle;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.prestamo_detalle.PrestamoDetalleDomain;

public interface IPrestamoDetalleDao extends IBaseDao<PrestamoDetalleDomain> {
	
	public List<PrestamoDetalleDomain>find(String textToFind);

}
