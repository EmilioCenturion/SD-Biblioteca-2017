package com.sd.uni.biblioteca.dto.categoria;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "categoriaResult")
public class CategoriaResult extends BaseResult<CategoriaDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<CategoriaDTO> getCategorias() {
		return getList();
	}

	public void setCategorias(List<CategoriaDTO> dtos) {
		super.setList(dtos);
	}
}
