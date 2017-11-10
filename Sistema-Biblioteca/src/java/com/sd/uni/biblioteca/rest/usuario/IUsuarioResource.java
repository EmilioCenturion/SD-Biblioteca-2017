package com.sd.uni.biblioteca.rest.usuario;

import com.sd.uni.biblioteca.dto.usuario.UsuarioDTO;
import com.sd.uni.biblioteca.dto.usuario.UsuarioResult;
import com.sd.uni.biblioteca.rest.base.IBaseResource;

public interface IUsuarioResource extends IBaseResource<UsuarioDTO> {

	public UsuarioResult getAll();
}