package com.sd.uni.biblioteca.dto.prestamo_detalle;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "prestamoDetalleResult")
public class PrestamoDetalleResult extends BaseResult<PrestamoDetalleDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<PrestamoDetalleDTO> getPrestamo_detalles() {
		return getList();
	}

	public void setPrestamoDetalles(List<PrestamoDetalleDTO> dtos) {
		super.setList(dtos);
	}
}
