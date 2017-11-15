package com.sd.uni.biblioteca.beans.entrada;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.biblioteca.beans.base.BaseBean;
import com.sd.uni.biblioteca.beans.motivoEntrada.MotivoEntradaB;

public class EntradaB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private Date _fecha;
	private MotivoEntradaB _motivoEntrada;
	private String _descripcion;


	public EntradaB(Map<String, String> params) {
		super(params);
	}


	public Date getFecha() {
		return _fecha;
	}


	public void setFecha(Date _fecha) {
		this._fecha = _fecha;
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
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		setDescripcion(params.get("descripcion"));
		try {
			setFecha(formato.parse(params.get("fecha")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}


	public MotivoEntradaB getMotivoEntrada() {
		return _motivoEntrada;
	}


	public void setMotivoEntrada(MotivoEntradaB _motivoEntrada) {
		this._motivoEntrada = _motivoEntrada;
	}

}

