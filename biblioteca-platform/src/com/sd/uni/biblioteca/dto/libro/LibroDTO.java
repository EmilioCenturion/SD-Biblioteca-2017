package com.sd.uni.biblioteca.dto.libro;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "libro")
public class LibroDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String _nombre;
	private Integer _autorId;
	private Integer _categoriaId;
	private String _anho;
	private Integer _cantidad;
	

	@XmlElement
	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}
	
	@XmlElement
	public Integer getAutorId() {
		return _autorId;
	}

	public void setAutorId(Integer autorId) {
		_autorId = autorId;
	}
	
	@XmlElement
	public String getAnho() {
		return _anho;
	}

	public void setAnho(String anho) {
		_anho = anho;
	}
	
	@XmlElement
	public Integer getCantidad() {
		return _cantidad;
	}

	public void setCantidad(Integer cantidad) {
		_cantidad = cantidad;
	}
	
	@XmlElement
	public Integer getCategoriaId() {
		return _categoriaId;
	}

	public void setCategoriaId(Integer _categoriaId) {
		this._categoriaId = _categoriaId;
	}

}
