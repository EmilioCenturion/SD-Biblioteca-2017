package com.sd.uni.biblioteca.beans.prestamo;

import java.sql.Date;
import java.util.Map;

import com.sd.uni.biblioteca.beans.base.BaseBean;
import com.sd.uni.biblioteca.beans.estadoGeneral.EstadoGeneralB;
import com.sd.uni.biblioteca.beans.usuario.UsuarioB;

import org.apache.commons.lang3.StringUtils;

public class PrestamoB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private Date _fecha_prestamo;
	private Date _fecha_limite;
	private UsuarioB _usuario;
	private EstadoGeneralB _estadoGeneral;

	public PrestamoB(Map<String, String> params) {
		super(params);
	}

	public Date getFecha_prestamo() {
		return _fecha_prestamo;
	}

	public void setFecha_prestamo(Date fecha_prestamo) {
		_fecha_prestamo = fecha_prestamo;
	}
	
	public Date getFecha_limite() {
		return _fecha_limite;
	}

	public void setFecha_limite(Date fecha_limite) {
		_fecha_prestamo = fecha_limite;
	}
	
	public UsuarioB getUsuario() {
		return _usuario;
	}

	public void setUsuario(UsuarioB usuario) {
		_usuario = usuario;
	}
	
	public EstadoGeneralB getEstadoGeneral() {
		return _estadoGeneral;
	}

	public void setEstadoGeneral(EstadoGeneralB estado_general) {
		_estadoGeneral = estado_general;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
			
		}
		setFecha_prestamo(params.get("fecha_prestamo"));
		setFecha_limite(params.get("fecha_limite"));
		setEstadoGeneral(params.get("estado_general"));
	}

}
