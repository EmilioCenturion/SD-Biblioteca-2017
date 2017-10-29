package com.sd.uni.biblioteca.dto.autor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "autor")
public class AutorDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String _descripcion;

	@XmlElement
	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		_descripcion = descripcion;
	}

}
