package com.sd.uni.biblioteca.domain.estado_general;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sd.uni.biblioteca.domain.prestamo.PrestamoDomain;

@Entity
@Table(name = "estado_general")
public class Estado_generalDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@Column(name = "descripcion", nullable = false, unique = true)
	private String _descripcion;

	@OneToMany(mappedBy = "_estado_general")
	private Set<PrestamoDomain> _prestamo = new HashSet<>();
	
	
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
