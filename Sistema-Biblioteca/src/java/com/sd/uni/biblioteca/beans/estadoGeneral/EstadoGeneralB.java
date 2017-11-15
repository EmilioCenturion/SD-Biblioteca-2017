package com.sd.uni.biblioteca.beans.estadoGeneral;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.sd.uni.biblioteca.beans.base.BaseBean;

public class EstadoGeneralB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private String _descripcion;

	public EstadoGeneralB(Map<String, String> params) {
		super(params);
	}

	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		_descripcion = descripcion;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setDescripcion(params.get("descripcion"));
	}

	
}
