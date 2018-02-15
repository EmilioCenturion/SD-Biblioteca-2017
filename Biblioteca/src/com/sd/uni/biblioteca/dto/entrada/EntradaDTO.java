package com.sd.uni.biblioteca.dto.entrada;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "entradaMotivo")
public class EntradaDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Date _fecha;
	private Integer _motivoEntradaId;
	private String _descripcion;

	@XmlElement
	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		_descripcion = descripcion;
	}
	
	@XmlElement
	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date _fecha) {
		this._fecha = _fecha;
	}
	
	@XmlElement
	public Integer getMotivoEntradaId() {
		return _motivoEntradaId;
	}

	public void setMotivoEntradaId(Integer _motivoEntradaId) {
		this._motivoEntradaId = _motivoEntradaId;
	}

}
