package com.sd.uni.biblioteca.dto.reservaDetalle;



import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "reservaDetalleResult")
public class ReservaDetalleResult extends BaseResult<ReservaDetalleDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<ReservaDetalleDTO> getReservaDetalles() {
		return getList();
	}

	public void setReservaDetalles(List<ReservaDetalleDTO> dtos) {
		super.setList(dtos);
	}
}


