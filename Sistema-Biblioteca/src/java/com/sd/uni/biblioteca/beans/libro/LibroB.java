package com.sd.uni.biblioteca.beans.libro;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.biblioteca.beans.autor.AutorB;
import com.sd.uni.biblioteca.beans.base.BaseBean;
import com.sd.uni.biblioteca.beans.categoria.CategoriaB;

public class LibroB extends BaseBean{
	
	private static final long serialVersionUID = 1L;
	
	private String _nombre;
	private LibroB _libro;
	private Integer _anho;
	private CategoriaB _categoria;
	private AutorB _autor;
	
	public LibroB(Map<String, String> params) {
		super(params);
	}
	

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}


	public LibroB getLibro() {
		return _libro;
	}


	public void setLibro(LibroB _libro) {
		this._libro = _libro;
	}


	public Integer getAnho() {
		return _anho;
	}


	public void setAnho(Integer _anho) {
		this._anho = _anho;
	}
	
	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setNombre(params.get("nombre"));
		setAnho(Integer.parseInt(params.get("anho")));
		
	}


	public CategoriaB getCategoria() {
		return _categoria;
	}


	public void setCategoria(CategoriaB _categoria) {
		this._categoria = _categoria;
	}


	public AutorB getAutor() {
		return _autor;
	}


	public void setAutor(AutorB _autor) {
		this._autor = _autor;
	}


	
}
