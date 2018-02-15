package com.sd.uni.biblioteca.domain.prestamo;

import java.util.Date;
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
import com.sd.uni.biblioteca.domain.estado_general.EstadoGeneralDomain;
import com.sd.uni.biblioteca.domain.motivo_salida.MotivoSalidaDomain;
import com.sd.uni.biblioteca.domain.prestamo_detalle.PrestamoDetalleDomain;
import com.sd.uni.biblioteca.domain.usuario.UsuarioDomain;

@Entity
@Table(name = "prestamo")
public class PrestamoDomain extends BaseDomain{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "fecha_prestamo", nullable = false, unique = true)
	private Date _fecha_prestamo;
	
	@Column(name = "fecha_limite", nullable = false, unique = true)
	private Date _fecha_limite;
	
	@ManyToOne
	private EstadoGeneralDomain _estado_general;
	
	@ManyToOne
	private UsuarioDomain _usuario;
	
	@OneToMany(mappedBy = "_prestamo")
	private Set<PrestamoDetalleDomain> _prestamo_detalle = new HashSet<>();
	
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public Date getFecha_prestamo() {
		return _fecha_prestamo;
	}

	public void setFecha_prestamo( Date fecha_prestamo) {
		_fecha_prestamo = fecha_prestamo;
	}
	
	public Date getFecha_limite() {
		return _fecha_limite;
	}

	public void setFecha_limite(Date fecha_limite) {
		_fecha_limite = fecha_limite;
	}
	
	public void setEstadoGeneral(EstadoGeneralDomain estadoGeneral) {
		_estado_general = estadoGeneral;
	}
	
	public EstadoGeneralDomain getEstadoGeneral() {
		return _estado_general;
	}
	
	public void setUsuario(UsuarioDomain usuario) {
		_usuario = usuario;
	}
	
	public UsuarioDomain getUsuario() {
		return _usuario;
	}
}
