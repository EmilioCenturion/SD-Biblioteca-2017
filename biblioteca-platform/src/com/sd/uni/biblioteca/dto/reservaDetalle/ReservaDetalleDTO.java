package com.sd.uni.biblioteca.dto.reservaDetalle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "reservaDetalle")
public class ReservaDetalleDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Integer _libroId;
	private Integer _reservaId;

	@XmlElement
	public Integer getLibroId() {
		return _libroId;
	}
	
	
	@XmlElement
	public Integer getReservaId() {
		return _reservaId;
	}
	

	public void setLibroId(Integer libroId) {
		_libroId = libroId;
	}
	


	public void setReservaId(Integer reservaId) {
		_reservaId = reservaId;
	}
	
}
