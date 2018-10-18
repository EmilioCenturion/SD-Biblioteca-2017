package com.sd.uni.biblioteca.dto.salidaDetalle;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "salida_detalle")
public class SalidaDetalleDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Integer _salidaID;
	private Integer _libroId;
	private Integer cantidad;
	
	@XmlElement
	public Integer getSalidaId() {
		return _salidaID;
	}
	
	@XmlElement
	public Integer getLibroId() {
		return _libroId;
	}
	
	@XmlElement
	public Integer getCantidad() {
		return cantidad;
	}
	
	public void setSalidaId(Integer salidaId) {
		_salidaID = salidaId;
	}
	
	public void setLibroId(Integer libroId) {
		_libroId = libroId;
	}
	

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}


