package com.sd.uni.biblioteca.beans.usuario;


import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.biblioteca.beans.base.BaseBean;
import com.sd.uni.biblioteca.beans.rol.RolB;

public class UsuarioB extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _nombre;
	private String _contrasenha;
	private RolB _rol;

	public UsuarioB(Map<String, String> params) {
		super(params);
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}
	
	
	public String getContrasenha() {
		return _contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		_contrasenha = contrasenha;
	}

	public RolB getRol() {
		return _rol;
	}

	public void setRol(RolB rol) {
		_rol = rol;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setNombre(params.get("nombre"));
		setContrasenha(params.get("contrasenha"));
	}

}
