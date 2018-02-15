package com.sd.uni.biblioteca.dto.disponibilidad;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "disponibilidadResult")
public class DisponibilidadResult extends BaseResult<DisponibilidadDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<DisponibilidadDTO> getDisponibilidades() {
		return getList();
	}

	public void setDisponibilidades(List<DisponibilidadDTO> dtos) {
		super.setList(dtos);
	}
}
