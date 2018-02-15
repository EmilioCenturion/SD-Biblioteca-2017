package com.sd.uni.biblioteca.dto.role;

import com.sd.uni.biblioteca.dto.base.BaseResult;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import java.util.List;

@XmlRootElement(name = "roleResult")
public class RoleResult extends BaseResult<RoleDTO>{

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<RoleDTO> getRoles(){
		return getList();
	}

	public void setRoles(List<RoleDTO> dtos) {
		super.setList(dtos);
	}
}