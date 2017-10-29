package com.sd.uni.biblioteca.dto.entradaDetalle;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "entradaDetalleResult")
public class EntradaDetalleResult extends BaseResult<EntradaDetalleDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<EntradaDetalleDTO> getEntradaDetalles() {
		return getList();
	}

	public void setEntradaDetalles(List<EntradaDetalleDTO> dtos) {
		super.setList(dtos);
	}
}


