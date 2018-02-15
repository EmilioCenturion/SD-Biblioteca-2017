package com.sd.uni.biblioteca.dto.prestamo_detalle;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "prestamo_detalle")
public class PrestamoDetalleDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Integer _prestamoId;
	private Integer _libroId;
	private Integer _estadoId;
	private Date _fecha_devolucion;

	@XmlElement
	public Integer getPrestamoId() {
		return _prestamoId;
	}
	
	@XmlElement
	public Integer getLibroId() {
		return _libroId;
	}
	
	@XmlElement
	public Integer getEstadoId() {
		return _estadoId;
	}
	
	@XmlElement
	public Date getFecha_devolucion() {
		return _fecha_devolucion;
	}
	

	public void setPrestamoId(Integer prestamoId) {
		_prestamoId = prestamoId;
	}
	
	public void setLibroId(Integer libroId) {
		_libroId = libroId;
	}

	public void setEstadoId(Integer estadoId) {
		_estadoId = estadoId;
	}
	
	public void setFecha_devolucion(Date fecha_devolucion) {
		_fecha_devolucion = fecha_devolucion;
	}
	
}
