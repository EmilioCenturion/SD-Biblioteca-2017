package com.sd.uni.biblioteca.beans.motivoSalida;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.biblioteca.beans.base.BaseBean;

public class MotivoSalidaB extends BaseBean {

	public MotivoSalidaB(Map<String, String> params) {
		super(params);
	}

	private static final long serialVersionUID = 1L;
	private String _descripcion;
	
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
