package com.sd.uni.biblioteca.dto.estado;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "estadoResult")
public class EstadoResult extends BaseResult<EstadoDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<EstadoDTO> getEstados() {
		return getList();
	}

	public void setEstados(List<EstadoDTO> dtos) {
		super.setList(dtos);
	}
}
