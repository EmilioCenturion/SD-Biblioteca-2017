package com.sd.uni.biblioteca.dto.prestamo;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "prestamo")
public class PrestamoDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Integer _estadoGeneralId;
	private Date _fechaPrestamo;
	private Date _fechaLimite;
	private Integer _usuarioId;

	@XmlElement
	public Integer getEstadoGeneralId() {
		return _estadoGeneralId;
	}
	
	@XmlElement
	public Date getFechaPrestamo() {
		return _fechaPrestamo;
	}
	
	@XmlElement
	public Date getFechaLimite() {
		return _fechaLimite;
	}
	
	@XmlElement
	public Integer getUsuarioId() {
		return _usuarioId;
	}
	

	public void setEstadoGeneralId(Integer estadoGeneralId) {
		_estadoGeneralId = estadoGeneralId;
	}
	
	public void setFechaPrestamo(Date fechaPrestamo) {
		_fechaPrestamo = fechaPrestamo;
	}

	public void setUsuarioId(Integer usuarioId) {
		_usuarioId = usuarioId;
	}

	public Date setFechaLimite(Date fechaLimite) {
		return _fechaLimite;
		
	}

	
}


