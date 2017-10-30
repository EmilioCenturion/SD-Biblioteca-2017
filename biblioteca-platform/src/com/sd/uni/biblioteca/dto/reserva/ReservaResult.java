package com.sd.uni.biblioteca.dto.reserva;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "reservaResult")
public class ReservaResult extends BaseResult<ReservaDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<ReservaDTO> getReservas() {
		return getList();
	}

	public void setReservas(List<ReservaDTO> dtos) {
		super.setList(dtos);
	}
}


