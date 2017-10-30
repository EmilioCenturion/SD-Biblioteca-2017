package com.sd.uni.biblioteca.dao.reservaDetalle;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.reservaDetalle.ReservaDetalleDomain;

public interface IReservaDetalleDao extends IBaseDao<ReservaDetalleDomain> {

	public List<ReservaDetalleDomain>find(String textToFind);
}
