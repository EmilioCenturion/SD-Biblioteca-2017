package com.sd.uni.biblioteca.dao.disponibilidad;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.disponibilidad.DisponibilidadDomain;

public interface IDisponibilidadDao extends IBaseDao<DisponibilidadDomain> {

	public List<DisponibilidadDomain>find(String textToFind);
}
