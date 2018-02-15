package com.sd.uni.biblioteca.dto.prestamo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "prestamoResult")
public class PrestamoResult extends BaseResult<PrestamoDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<PrestamoDTO> getPrestamos() {
		return getList();
	}

	public void setPrestamos(List<PrestamoDTO> dtos) {
		super.setList(dtos);
	}
}