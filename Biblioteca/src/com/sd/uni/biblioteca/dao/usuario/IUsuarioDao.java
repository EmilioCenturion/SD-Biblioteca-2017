package com.sd.uni.biblioteca.dao.usuario;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.usuario.UsuarioDomain;
import com.sd.uni.biblioteca.exception.BibliotecaException;

public interface IUsuarioDao extends IBaseDao<UsuarioDomain> {

	public List<UsuarioDomain>find(String textToFind);

	public List<UsuarioDomain> find(String textToFind, int page, int maxItems) throws BibliotecaException;
}
