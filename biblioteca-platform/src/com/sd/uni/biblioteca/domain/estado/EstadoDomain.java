package com.sd.uni.biblioteca.domain.estado;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sd.uni.biblioteca.domain.libro.LibroDomain;
import com.sd.uni.biblioteca.domain.prestamo_detalle.Prestamo_detalleDomain;

@Entity
@Table(name = "estado")
public class EstadoDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@Column(name = "descripcion", nullable = false, unique = true)
	private String _descripcion;

	@OneToMany(mappedBy = "_estado")
	private Set<Prestamo_detalleDomain> _prestamo_detalle = new HashSet<>();
	
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		_descripcion = descripcion;
	}
	
}
