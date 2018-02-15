package com.sd.uni.biblioteca.dto.entradaDetalle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "entradaDetalle")
public class EntradaDetalleDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Integer _libroId;
	private Integer _entradaId;
	private Integer _cantidad;

	@XmlElement
	public Integer getLibroId() {
		return _libroId;
	}
	
	
	@XmlElement
	public Integer getEntradaId() {
		return _entradaId;
	}
	

	public void setLibroId(Integer libroId) {
		_libroId = libroId;
	}
	


	public void setEntradaId(Integer entradaId) {
		_entradaId = entradaId;
	}

	@XmlElement
	public Integer getCantidad() {
		return _cantidad;
	}


	public void setCantidad(Integer _cantidad) {
		this._cantidad = _cantidad;
	}
	
}
