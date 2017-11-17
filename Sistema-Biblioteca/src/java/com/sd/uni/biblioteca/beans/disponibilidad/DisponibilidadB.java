package com.sd.uni.biblioteca.beans.disponibilidad;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.biblioteca.beans.base.BaseBean;
import com.sd.uni.biblioteca.beans.libro.LibroB;
import com.sd.uni.biblioteca.beans.rol.RolB;

public class DisponibilidadB extends BaseBean{
	private static final long serialVersionUID = 1L;
	private Integer _cantidad;
	private LibroB _libro;
	
	public DisponibilidadB(Map<String, String> params) {
		super(params);
	}

	
	public Integer getCantidad() {
		return _cantidad;
	}

	public void setCantidad(Integer cantidad) {
		_cantidad = cantidad;
	}
	
	public LibroB getLibro() {
		return _libro;
	}

	public void setLibro(LibroB libro) {
		_libro = libro;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		
		setCantidad(Integer.valueOf(params.get("cantidad")));
		
	}
}


