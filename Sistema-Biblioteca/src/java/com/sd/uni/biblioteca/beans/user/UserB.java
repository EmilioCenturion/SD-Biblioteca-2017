package com.sd.uni.biblioteca.beans.user;

import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.biblioteca.beans.base.BaseBean;
import com.sd.uni.biblioteca.beans.role.RoleB;

public class UserB extends BaseBean{

	private static final long serialVersionUID = 4680476902664047494L;

	private String _username;
	private String _password;
	private String _name;
	private String _type;
	private String _accountExpired;
	private String _accountLocked;
	private String _passwordExpired;

	private Set<RoleB> _roles;

	public Set<RoleB> getRoles(){
		return _roles;
	}

	public void setRoles(Set<RoleB> roles){
		_roles = roles;
	}

	public UserB(Map<String, String> params) {
		super(params);
	}

	public String getUsername() {
		return _username;
	}

	public void setUsername(String _username) {
		this._username = _username;
	}

	public String getPassword() {
		return _password;
	}
	public void setPassword(String _password) {
		this._password = _password;
	}

	public String getName() {
		return _name;
	}

	public void setName(String _name) {
		this._name = _name;
	}

	public String getType() {
		return _type;
	}

	public void setType(String _type) {
		this._type = _type;
	}

	public String getAccountLocked() {
		return _accountLocked;
	}
	public void setAccountLocked(String _accountLocked) {
		this._accountLocked = _accountLocked;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setUsername(params.get("username"));
		setPassword(params.get("password"));
		setAccountLocked(params.get("accountLocked"));
		setName(params.get("name"));
		setType(params.get("type"));
	}

}
