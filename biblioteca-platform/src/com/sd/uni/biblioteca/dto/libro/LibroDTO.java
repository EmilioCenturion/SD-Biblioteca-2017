package com.sd.uni.biblioteca.dto.libro;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "libro")
public class LibroDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String _nombre;
	private String _autor;
	private Integer _anho;
	

	@XmlElement
	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}
	
	@XmlElement
	public String getAutor() {
		return _autor;
	}

	public void setAutor(String autor) {
		_autor = autor;
	}
	
	@XmlElement
	public Integer getAnho() {
		return _anho;
	}

	public void setAnho(Integer anho) {
		_anho = anho;
	}

}
