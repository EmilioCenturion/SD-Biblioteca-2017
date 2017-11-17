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
import com.sd.uni.biblioteca.domain.categoria.CategoriaDomain;
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
	private String _anho;
	
	@Column(name = "cantidad", nullable = false, unique = true)
	private Integer _cantidad;
	
	@ManyToOne
	private AutorDomain _autor;
	
	@ManyToOne
	private CategoriaDomain _categoria;
	
	@OneToMany(mappedBy = "_libro")
	private Set<PrestamoDetalleDomain> _prestamoDetalles = new HashSet<>();
	
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
	
	public String getAnho() {
		return _anho;
	}

	public void setAnho(String anho) {
		_anho = anho;
	}
	
	public Integer getCantidad() {
		return _cantidad;
	}

	public void setCantidad(Integer cantidad) {
		_cantidad = cantidad;
	}
	
	public AutorDomain getAutor() {
		return _autor;
	}

	public void setAutor(AutorDomain autor) {
		_autor = autor;
	}
	
	public CategoriaDomain getCategoria() {
		return _categoria;
	}

	public void setCategoria(CategoriaDomain categoria) {
		_categoria = categoria;
	}
	
	public Set<PrestamoDetalleDomain> getPrestamoDetalles() {
		return _prestamoDetalles;
	}

	public void setPrestamoDetalles(Set<PrestamoDetalleDomain> prestamoDetalles) {
		this._prestamoDetalles = prestamoDetalles;
	}
}

