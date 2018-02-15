package com.sd.uni.biblioteca.dto.autor;


import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "autor")
public class AutorDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String _nombre;
	
	@XmlElement
	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	
}
