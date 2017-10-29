package com.sd.uni.biblioteca.dto.estado_general;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "estado_generalResult")
public class Estado_generalResult extends BaseResult<Estado_generalDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<Estado_generalDTO> getEstado_generals() {
		return getList();
	}

	public void setEstados_generals(List<Estado_generalDTO> dtos) {
		super.setList(dtos);
	}
}
