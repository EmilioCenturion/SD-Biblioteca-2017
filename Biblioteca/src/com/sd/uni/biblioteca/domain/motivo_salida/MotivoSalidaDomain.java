package com.sd.uni.biblioteca.domain.motivo_salida;

import java.util.Date;
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
import com.sd.uni.biblioteca.domain.salida.SalidaDomain;
import com.sd.uni.biblioteca.domain.salidaDetalle.SalidaDetalleDomain;
import com.sd.uni.biblioteca.domain.usuario.UsuarioDomain;

@Entity
@Table(name = "motivo_salida")

public class MotivoSalidaDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@Column(name = "descripcion", nullable = false, unique = true)
	private String _descripcion;
	
	@OneToMany(mappedBy = "_motivo_salida")
	private Set<SalidaDomain> _salidas = new HashSet<>();
	
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
	
	public Set<SalidaDomain> getSalidas() {
		return _salidas;
	}

	public void setSalidas(Set<SalidaDomain> salidas) {
		this._salidas = salidas;
	}


	
}