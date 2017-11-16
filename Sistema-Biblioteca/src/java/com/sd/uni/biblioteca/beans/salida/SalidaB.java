package com.sd.uni.biblioteca.beans.salida;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.biblioteca.beans.base.BaseBean;
import com.sd.uni.biblioteca.beans.motivoSalida.MotivoSalidaB;
public class SalidaB extends BaseBean {
	
	public SalidaB(Map<String, String> params) {
		super(params);
	}

	private static final long serialVersionUID = 1L;
	private Date _fecha;
	private String _descripcion;
	private MotivoSalidaB _motivoSalida;

	
	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		_descripcion = descripcion;
	}
	
	
	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date fecha) {
		_fecha = fecha;
	}

	public MotivoSalidaB getMotivoSalida() {
		return _motivoSalida;
	}

	public void setMotivoSalida(MotivoSalidaB motivo) {
		_motivoSalida = motivo;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		//para que no lance error
		try {
			setFecha(formato.parse(params.get("fecha")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
			
		setDescripcion(params.get("descripcion"));

	}

}
