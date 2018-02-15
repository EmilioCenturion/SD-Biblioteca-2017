package com.sd.uni.biblioteca.domain.disponibilidad;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sd.uni.biblioteca.domain.base.BaseDomain;
import com.sd.uni.biblioteca.domain.libro.LibroDomain;

@Entity
@Table(name = "disponibilidad")

public class DisponibilidadDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@Column(name = "cantidad", nullable = false)
	private Integer _cantidad;
	
	@OneToOne
	private LibroDomain _libro;
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public LibroDomain getLibro() {
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
