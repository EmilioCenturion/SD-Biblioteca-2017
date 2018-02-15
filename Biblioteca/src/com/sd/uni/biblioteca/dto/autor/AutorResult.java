package com.sd.uni.biblioteca.dto.autor;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "autorResult")
public class AutorResult extends BaseResult<AutorDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<AutorDTO> getAutors() {
		return getList();
	}

	public void setAutors(List<AutorDTO> dtos) {
		super.setList(dtos);
	}
}

