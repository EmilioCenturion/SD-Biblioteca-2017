package com.sd.uni.biblioteca.dto.motivoEntrada;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "motivoEntradaResult")
public class MotivoEntradaResult extends BaseResult<MotivoEntradaDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<MotivoEntradaDTO> getMotivoEntradas() {
		return getList();
	}

	public void setMotivoEntradas(List<MotivoEntradaDTO> dtos) {
		super.setList(dtos);
	}
}
