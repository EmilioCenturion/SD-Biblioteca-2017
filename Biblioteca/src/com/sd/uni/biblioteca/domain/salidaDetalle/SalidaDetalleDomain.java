package com.sd.uni.biblioteca.domain.salidaDetalle;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;














import com.sd.uni.biblioteca.domain.base.BaseDomain;
import com.sd.uni.biblioteca.domain.libro.LibroDomain;
import com.sd.uni.biblioteca.domain.rol.RolDomain;
import com.sd.uni.biblioteca.domain.salida.SalidaDomain;

@Entity
@Table(name = "salida_detalle")

public class SalidaDetalleDomain extends BaseDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@Column(name = "cantidad", nullable = false)
	private Integer _cantidad;
	
	@ManyToOne
	private SalidaDomain _salida;
	
	@ManyToOne
	private LibroDomain _libro;
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}
	
	public SalidaDomain getSalida(){
		return _salida;
	}
	
	public void setSalida(SalidaDomain salida) {
		_salida = salida;
	}
	
	public LibroDomain getLibro(){
		return _libro;
	}
	
	public void setLibro(LibroDomain libro) {
		_libro = libro;
	}
	
	public Integer getCantidad() {
		return _cantidad;
	}

	public void setCantidad(Integer cantidad) {
		_cantidad = cantidad;
	}
}
