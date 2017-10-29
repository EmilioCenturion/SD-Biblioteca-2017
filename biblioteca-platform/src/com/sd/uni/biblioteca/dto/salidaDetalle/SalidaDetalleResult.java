package com.sd.uni.biblioteca.dto.salidaDetalle;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "salidaDetalleResult")
public class SalidaDetalleResult extends BaseResult<SalidaDetalleDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<SalidaDetalleDTO> getSalidaDetalles() {
		return getList();
	}

	public void setSalidaDetalles(List<SalidaDetalleDTO> dtos) {
		super.setList(dtos);
	}
}
