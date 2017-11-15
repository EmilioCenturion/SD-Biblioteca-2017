package com.sd.uni.biblioteca.beans.entradaDetalle;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.biblioteca.beans.base.BaseBean;
import com.sd.uni.biblioteca.beans.entrada.EntradaB;
import com.sd.uni.biblioteca.beans.libro.LibroB;

public class EntradaDetalleB extends BaseBean{
	private static final long serialVersionUID = 1L;
	private LibroB _libro;
	private EntradaB _entrada;
	
	
	public EntradaDetalleB(Map<String, String> params) {
		super(params);
	}

	public LibroB getLibro() {
		return _libro;
	}


	public void setLibro(LibroB _libro) {
		this._libro = _libro;
	}


	public EntradaB getEntrada() {
		return _entrada;
	}


	public void setEntrada(EntradaB _entrada) {
		this._entrada = _entrada;
	}
	
	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		
	}
	
}
