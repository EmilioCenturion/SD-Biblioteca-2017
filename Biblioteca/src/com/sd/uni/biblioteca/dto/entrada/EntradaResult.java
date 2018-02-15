package com.sd.uni.biblioteca.dto.entrada;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "entradaResult")
public class EntradaResult extends BaseResult<EntradaDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<EntradaDTO> getEntradas() {
		return getList();
	}

	public void setEntradas(List<EntradaDTO> dtos) {
		super.setList(dtos);
	}
}

