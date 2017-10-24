package com.sd.uni.biblioteca.dto.rol;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "rolResult")
public class RolResult extends BaseResult<RolDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<RolDTO> getRols() {
		return getList();
	}

	public void setRols(List<RolDTO> dtos) {
		super.setList(dtos);
	}
}
