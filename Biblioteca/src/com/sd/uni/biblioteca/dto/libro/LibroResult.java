package com.sd.uni.biblioteca.dto.libro;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "libroResult")
public class LibroResult extends BaseResult<LibroDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<LibroDTO> getLibros() {
		return getList();
	}

	public void setLibros(List<LibroDTO> dtos) {
		super.setList(dtos);
	}
}

