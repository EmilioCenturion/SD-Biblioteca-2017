package com.sd.uni.biblioteca.service.usuario;

import com.sd.uni.biblioteca.dao.usuario.UsuarioDaoImpl;
import com.sd.uni.biblioteca.domain.usuario.UsuarioDomain;
import com.sd.uni.biblioteca.dto.usuario.UsuarioDTO;
import com.sd.uni.biblioteca.dto.usuario.UsuarioResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IUsuarioService extends IBaseService<UsuarioDTO, UsuarioDomain, UsuarioDaoImpl, UsuarioResult> {

	public UsuarioResult find(String textToFind);

	public UsuarioResult find(String textToFind, int page, int maxItems)
			throws BibliotecaException;
}
