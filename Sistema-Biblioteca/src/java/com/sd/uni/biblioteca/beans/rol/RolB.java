package com.sd.uni.biblioteca.beans.rol;
import java.util.Map;

import org.apache.commons.lang.*;

import com.sd.uni.biblioteca.beans.base.BaseBean;

public class RolB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private String _nombre;

	public RolB(Map<String, String> params) {
		super(params);
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setNombre(params.get("nombre"));
	}

}