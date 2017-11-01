package com.sd.uni.biblioteca.dto.prestamo_detalle;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "prestamo_detalle")
public class PrestamoDetalleDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String _prestamoId;
	private String _libroId;
	private String _estadoId;
	private Date _fecha_devolucion;

	@XmlElement
	public String getPrestamoId() {
		return _prestamoId;
	}
	
	@XmlElement
	public String getLibroId() {
		return _libroId;
	}
	
	@XmlElement
	public String getEstadoId() {
		return _estadoId;
	}
	
	@XmlElement
	public Date getFecha_devolucion() {
		return _fecha_devolucion;
	}
	

	public void setPrestamoId(String prestamoId) {
		_prestamoId = prestamoId;
	}
	
	public void setLibroId(String libroId) {
		_libroId = libroId;
	}

	public void setEstadoId(String estadoId) {
		_estadoId = estadoId;
	}
	
	public void setFecha_devolucion(Date fecha_devolucion) {
		_fecha_devolucion = fecha_devolucion;
	}
	
}
