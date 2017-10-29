package com.sd.uni.biblioteca.dto.salida;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "salidaResult")
public class SalidaResult extends BaseResult<SalidaDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<SalidaDTO> getSalidas() {
		return getList();
	}

	public void setSalidas(List<SalidaDTO> dtos) {
		super.setList(dtos);
	}
}
