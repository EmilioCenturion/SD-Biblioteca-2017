package com.sd.uni.biblioteca.dto.estado_general;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "estado_generalResult")
public class EstadoGeneralResult extends BaseResult<EstadoGeneralDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<EstadoGeneralDTO> getEstadoGenerales() {
		return getList();
	}

	public void setEstadoGenerales(List<EstadoGeneralDTO> dtos) {
		super.setList(dtos);
	}

	

	
}
