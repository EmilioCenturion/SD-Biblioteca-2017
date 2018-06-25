package com.sd.uni.biblioteca.beans.salidaDetalle;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.biblioteca.beans.base.BaseBean;
import com.sd.uni.biblioteca.beans.salida.SalidaB;
import com.sd.uni.biblioteca.beans.libro.LibroB;

public class SalidaDetalleB extends BaseBean{
	private static final long serialVersionUID = 1L;
	private LibroB _libro;
	private SalidaB _salida;
	private Integer _cantidad;
	
	
	public SalidaDetalleB(Map<String, String> params) {
		super(params);
	}

	public LibroB getLibro() {
		return _libro;
	}


	public void setLibro(LibroB _libro) {
		this._libro = _libro;
	}


	public SalidaB getSalida() {
		return _salida;
	}


	public void setSalida(SalidaB _salida) {
		this._salida = _salida;
	}
	
	public Integer getCantidad() {
		return _cantidad;
	}

	public void setCantidad(Integer _cantidad) {
		this._cantidad = _cantidad;
	}
	
	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
			setCantidad(Integer.valueOf(params.get("cantidad")));
		}
		
	}

}
