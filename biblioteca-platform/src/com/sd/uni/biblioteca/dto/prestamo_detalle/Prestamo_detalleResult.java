package com.sd.uni.biblioteca.dto.prestamo_detalle;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "prestamo_detalleResult")
public class Prestamo_detalleResult extends BaseResult<Prestamo_detalleDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<Prestamo_detalleDTO> getPrestamo_detalles() {
		return getList();
	}

	public void setPrestamo_detalles(List<Prestamo_detalleDTO> dtos) {
		super.setList(dtos);
	}
}
