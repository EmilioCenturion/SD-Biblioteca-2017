package com.sd.uni.biblioteca.beans.prestamoDetalle;

import java.sql.Date;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import com.sd.uni.biblioteca.beans.base.BaseBean;
import com.sd.uni.biblioteca.beans.estado.EstadoB;
import com.sd.uni.biblioteca.beans.libro.LibroB;
import com.sd.uni.biblioteca.beans.prestamo.PrestamoB;


public class PrestamoDetalleB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private Date _fecha_devolucion;
	private PrestamoB _prestamo;
	private LibroB _libro;
	private EstadoB _estado;
	

	public PrestamoDetalleB(Map<String, String> params) {
		super(params);
	}

	public Date getFecha_devolucion() {
		return _fecha_devolucion;
	}

	public void setFecha_devolucion(Date fecha_devolucion) {
		_fecha_devolucion = fecha_devolucion;
	}
	

	public PrestamoB getPrestamo() {
		return _prestamo;
	}

	public void setPrestamo(PrestamoB prestamo) {
		_prestamo = prestamo;
	}
	
	public EstadoB getEstado() {
		return _estado;
	}

	public void setEstadoGeneral(EstadoB estado) {
		_estado = estado;
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
			setFecha_prestamo(params.get("fecha_prestamo"));
			setFecha_limite(params.get("fecha_limite"));
		}
		setEstadoGeneral(params.get("estado_general"));
	}

}
