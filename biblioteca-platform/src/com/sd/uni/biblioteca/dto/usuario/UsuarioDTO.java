package com.sd.uni.biblioteca.dto.usuario;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "usuario")
public class UsuarioDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String _nombre;
	private String _contrasenha;
	private Integer _rolId;

	@XmlElement
	public String getNombre() {
		return _nombre;
	}
	
	@XmlElement
	public String getContrasenha() {
		return _contrasenha;
	}
	
	@XmlElement
	public Integer getRolId() {
		return _rolId;
	}
	

	public void setNombre(String nombre) {
		_nombre = nombre;
	}
	
	public void setContrasenha(String contrasenha) {
		_contrasenha = contrasenha;
	}

	public void setRolId(Integer rolId) {
		_rolId = rolId;
	}
	
}


