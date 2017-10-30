package com.sd.uni.biblioteca.dao.reserva;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.reserva.ReservaDomain;

public interface IReservaDao extends IBaseDao<ReservaDomain> {

	public List<ReservaDomain>find(String textToFind);
}
