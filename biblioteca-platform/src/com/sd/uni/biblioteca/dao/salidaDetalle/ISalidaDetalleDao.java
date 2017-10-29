package com.sd.uni.biblioteca.dao.salidaDetalle;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.salidaDetalle.SalidaDetalleDomain;

public interface ISalidaDetalleDao extends IBaseDao<SalidaDetalleDomain> {
	
	public List<SalidaDetalleDomain>find(String textToFind);

}
