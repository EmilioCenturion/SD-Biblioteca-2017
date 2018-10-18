package com.sd.uni.biblioteca.dto.salida;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "salida")
public class SalidaDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Date _fecha;
	private String _descripcion;
	private Integer _motivoId;
	
	@XmlElement
	public Date getFecha() {
		return _fecha;
	}
	
	@XmlElement
	public String getDescripcion() {
		return _descripcion;
	}
	
	@XmlElement
	public Integer getMotivoSalidaId() {
		return _motivoId;
	}
	

	public void setFecha(Date fecha) {
		_fecha = fecha;
	}
	
	public void setDescripcion(String descripcion) {
		_descripcion = descripcion;
	}

	public void setMotivoSalidaId(Integer motivoId) {
		_motivoId = motivoId;
	}
	
}


