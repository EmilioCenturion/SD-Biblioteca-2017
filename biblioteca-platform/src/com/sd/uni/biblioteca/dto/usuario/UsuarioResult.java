package com.sd.uni.biblioteca.dto.usuario;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "usuarioResult")
public class UsuarioResult extends BaseResult<UsuarioDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<UsuarioDTO> getUsuarios() {
		return getList();
	}

	public void setUsuarios(List<UsuarioDTO> dtos) {
		super.setList(dtos);
	}
}
