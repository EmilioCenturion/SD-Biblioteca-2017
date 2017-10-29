package com.sd.uni.biblioteca.dto.disponibilidad;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "disponibilidad")
public class DisponibilidadDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Integer _cantidad;
	private Integer _libroId;
	private Integer _categoriaId;

	@XmlElement
	public Integer getCantidad() {
		return _cantidad;
	}
	
	@XmlElement
	public Integer getLibroId() {
		return _libroId;
	}
	
	@XmlElement
	public Integer getCategoriaId() {
		return _categoriaId;
	}
	

	public void setCantidad(Integer cantidad) {
		_cantidad = cantidad;
	}
	
	public void setLibroId(Integer libroId) {
		_libroId = libroId;
	}

	public void setCategoriaId(Integer categoriaId) {
		_categoriaId = _categoriaId;
	}
	
}


