package com.sd.uni.biblioteca.dto.prestamo;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "prestamo")
public class PrestamoDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String _estado_generalId;
	private Date _fecha_prestamo;
	private Date _fecha_limite;
	private String _usuarioId;

	@XmlElement
	public String getEstado_generalId() {
		return _estado_generalId;
	}
	
	@XmlElement
	public Date getFecha_prestamo() {
		return _fecha_prestamo;
	}
	
	@XmlElement
	public Date getFecha_limite() {
		return _fecha_limite;
	}
	
	@XmlElement
	public String getUsuarioId() {
		return _usuarioId;
	}
	

	public void setEstado_generalId(String estado_generalId) {
		_estado_generalId = estado_generalId;
	}
	
	public void setFecha_prestamo(Date fecha_prestamo) {
		_fecha_prestamo = fecha_prestamo;
	}

	public void setUsuarioId(String usuarioId) {
		_usuarioId = usuarioId;
	}

	public Date setFecha_limite(Date fecha_limite) {
		return _fecha_limite;
		
	}

	
}


