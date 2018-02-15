package com.sd.uni.biblioteca.domain.categoria;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sd.uni.biblioteca.domain.base.BaseDomain;
import com.sd.uni.biblioteca.domain.libro.LibroDomain;

@Entity
@Table(name = "categoria")
public class CategoriaDomain extends BaseDomain{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@Column(name = "descripcion", nullable = false, unique = true)
	private String _descripcion;
	
	@OneToMany(mappedBy = "_categoria")
	private Set<LibroDomain> _libros = new HashSet<>();
	
	
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
	
	public Set<LibroDomain> getLibros() {
		return _libros;
	}

	public void setLibros(Set<LibroDomain> libros) {
		this._libros = libros;
	}
	
	
	
}
