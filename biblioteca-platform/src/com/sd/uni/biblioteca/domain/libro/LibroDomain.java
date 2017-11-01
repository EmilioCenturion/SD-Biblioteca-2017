package com.sd.uni.biblioteca.domain.libro;

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

import com.sd.uni.biblioteca.domain.autor.AutorDomain;
import com.sd.uni.biblioteca.domain.base.BaseDomain;
import com.sd.uni.biblioteca.domain.motivo_salida.MotivoSalidaDomain;
import com.sd.uni.biblioteca.domain.prestamo_detalle.PrestamoDetalleDomain;


@Entity
@Table(name = "libro")
public class LibroDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@Column(name = "nombre", nullable = false, unique = true)
	private String _nombre;
	
	@Column(name = "anho", nullable = false, unique = true)
	private Integer _anho;
	
	@ManyToOne
	private AutorDomain _autor;
	
	@OneToMany(mappedBy = "_libro")
	private Set<PrestamoDetalleDomain> _prestamo_detalle = new HashSet<>();
	
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
	
	public Integer getAnho() {
		return _anho;
	}

	public void setAnho(Integer anho) {
		_anho = anho;
	}
	
	public AutorDomain getAutor() {
		return _autor;
	}

	public void setAutor(AutorDomain autor) {
		_autor = autor;
	}
}

