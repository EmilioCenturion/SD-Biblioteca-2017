package com.sd.uni.biblioteca.dao.usuario;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.usuario.UsuarioDomain;

public interface IUsuarioDao extends IBaseDao<UsuarioDomain> {

	public List<UsuarioDomain>find(String textToFind);
}
