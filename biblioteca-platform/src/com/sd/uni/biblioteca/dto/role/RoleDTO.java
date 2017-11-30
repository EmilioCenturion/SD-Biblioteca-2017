package com.sd.uni.biblioteca.dto.role;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "user")
public class RoleDTO extends BaseDTO{

	private static final long serialVersionUID = -9097944624604913579L;
	private String _authority;
	
	@XmlElement
	public String getAuthority() {
		return _authority;
	}

	public void setAuthority(String _authority) {
		this._authority = _authority;
	}	
}
