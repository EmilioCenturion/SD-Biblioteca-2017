package com.sd.uni.biblioteca.dao.entradaDetalle;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.entradaDetalle.EntradaDetalleDomain;

public interface IEntradaDetalleDao extends IBaseDao<EntradaDetalleDomain> {

	public List<EntradaDetalleDomain>find(String textToFind);
}
