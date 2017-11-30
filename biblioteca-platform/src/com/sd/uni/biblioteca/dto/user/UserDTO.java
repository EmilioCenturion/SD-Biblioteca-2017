package com.sd.uni.biblioteca.dto.user;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "user")
public class UserDTO extends BaseDTO{

	private static final long serialVersionUID = -9097944624604913579L;
	private String _username;
	private String _password;
	private String _name;
	private String _type;
	private String _accountExpired;
	private String _accountLocked;
	private String _passwordExpired;
	
	private List<Integer> _rolesIds;
	
	@XmlElement
	public List<Integer> getRolesIds() {
		return _rolesIds;
	}

	public void setRolesIds(List<Integer> _rolesIds) {
		this._rolesIds = _rolesIds;
	}
	
	@XmlElement
	public String getUsername() {
		return _username;
	}

	public void setUsername(String _username) {
		this._username = _username;
	}

	@XmlElement
	public String getPassword() {
		return _password;
	}

	public void setPassword(String _password) {
		this._password = _password;
	}
	
	@XmlElement
	public String getName() {
		return _name;
	}

	public void setName(String _name) {
		this._name = _name;
	}
	
	@XmlElement
	public String getType() {
		return _type;
	}

	public void setType(String _type) {
		this._type = _type;
	}

	@XmlElement
	public String getAccountExpired() {
		return _accountExpired;
	}

	public void setAccountExpired(String _accountExpired) {
		this._accountExpired = _accountExpired;
	}

	@XmlElement
	public String getAccountLocked() {
		return _accountLocked;
	}

	public void setAccountLocked(String _accountLocked) {
		this._accountLocked = _accountLocked;
	}
	
	@XmlElement
	public String getPasswordExpired() {
		return _passwordExpired;
	}

	public void setPasswordExpired(String _passwordExpired) {
		this._passwordExpired = _passwordExpired;
	}
}
