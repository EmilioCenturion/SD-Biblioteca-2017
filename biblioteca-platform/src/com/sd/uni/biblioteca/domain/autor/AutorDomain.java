package com.sd.uni.biblioteca.domain.autor;

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

import com.sd.uni.biblioteca.domain.base.BaseDomain;
import com.sd.uni.biblioteca.domain.libro.LibroDomain;
import com.sd.uni.biblioteca.domain.prestamo_detalle.PrestamoDetalleDomain;
import com.sd.uni.biblioteca.domain.usuario.UsuarioDomain;
@Entity
@Table(name = "autor")
public class AutorDomain extends BaseDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@Column(name = "nombre", nullable = false, unique = true)
	private String _nombre;
	
	@OneToMany(mappedBy = "_autor")
	private Set<LibroDomain> _libros = new HashSet<>();
	
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}
	
	public Set<LibroDomain> getLibros() {
		return _libros;
	}

	public void setLibros(Set<LibroDomain> libros) {
		this._libros = libros;
	}
	
}
