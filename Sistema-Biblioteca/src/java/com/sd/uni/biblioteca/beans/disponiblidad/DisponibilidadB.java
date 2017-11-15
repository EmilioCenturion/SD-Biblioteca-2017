package com.sd.uni.biblioteca.beans.disponiblidad;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.sd.uni.biblioteca.beans.base.BaseBean;
import com.sd.uni.biblioteca.beans.categoria.CategoriaB;
import com.sd.uni.biblioteca.beans.libro.LibroB;


public class DisponibilidadB extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer _cantidad;
	private LibroB _libro;
	private CategoriaB _categoria;

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
	
	public CategoriaB getCategoria() {
		return _categoria;
	}

	public void setCategoria(CategoriaB categoria) {
		_categoria = categoria;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		//	setCantidad(params.get("cantidad"));
			
		}
		//setEstado_general(params.get("estado_general"));
	}

}
