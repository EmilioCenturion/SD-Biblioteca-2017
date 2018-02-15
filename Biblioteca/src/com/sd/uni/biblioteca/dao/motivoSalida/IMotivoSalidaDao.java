package com.sd.uni.biblioteca.dao.motivoSalida;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.motivo_salida.MotivoSalidaDomain;

public interface IMotivoSalidaDao extends IBaseDao<MotivoSalidaDomain> {

	public List<MotivoSalidaDomain>find(String textToFind);
}
