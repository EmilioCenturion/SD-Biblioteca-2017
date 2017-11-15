package com.sd.uni.biblioteca.beans.categoria;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import com.sd.uni.biblioteca.beans.base.BaseBean;

public class CategoriaB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private String _descripcion;


	public CategoriaB(Map<String, String> params) {
		super(params);
	}
	
	public String getDescripcion() {
		return _descripcion;
	}


	public void setDescripcion(String _descripcion) {
		this._descripcion = _descripcion;
	}
	
	
	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setDescripcion(params.get("descripcion"));
	}

}

