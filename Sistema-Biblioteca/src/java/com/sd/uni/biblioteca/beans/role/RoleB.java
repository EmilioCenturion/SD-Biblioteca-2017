package com.sd.uni.biblioteca.beans.role;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.biblioteca.beans.base.BaseBean;

public class RoleB extends BaseBean{

	private static final long serialVersionUID = 4680476902664047494L;

	private String _authority;

	public RoleB(Map<String, String> params) {
		super(params);
	}

	public String getAuthority() {
		return _authority;
	}

	public void setAuthority(String _authority) {
		this._authority = _authority;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setAuthority(params.get("authority"));
	}

}
