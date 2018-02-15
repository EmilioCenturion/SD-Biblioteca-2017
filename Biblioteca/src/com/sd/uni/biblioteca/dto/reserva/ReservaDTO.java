package com.sd.uni.biblioteca.dto.reserva;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "reservaMotivo")
public class ReservaDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Date _fechaPedido;
	private Date _fechaReserva;
	private Integer _usuarioId;

	
	@XmlElement
	public Date getFechaPedido() {
		return _fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this._fechaPedido = fechaPedido;
	}
	
	@XmlElement
	public Date getFechaReserva() {
		return _fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this._fechaReserva = fechaReserva;
	}
	
	@XmlElement
	public Integer getUsuarioId() {
		return _usuarioId;
	}

	public void setUsuarioId(Integer _usuarioId) {
		this._usuarioId = _usuarioId;
	}

}

