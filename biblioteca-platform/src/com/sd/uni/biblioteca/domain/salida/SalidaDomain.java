package com.sd.uni.biblioteca.domain.salida;

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
import com.sd.uni.biblioteca.domain.motivo_salida.MotivoSalidaDomain;
import com.sd.uni.biblioteca.domain.rol.RolDomain;
import com.sd.uni.biblioteca.domain.salidaDetalle.SalidaDetalleDomain;
import com.sd.uni.biblioteca.domain.usuario.UsuarioDomain;

@Entity
@Table(name = "salida")

public class SalidaDomain extends BaseDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@Column(name = "fecha", nullable = false, unique = true)
	private Date _fecha;

	@Column(name = "descripcion", nullable = false, unique = false)
	private String _descripcion;
	
	@OneToMany(mappedBy = "_salida")
	private Set<SalidaDetalleDomain> _salida_detalles = new HashSet<>();
	
	@ManyToOne
	private MotivoSalidaDomain _motivo_salida;
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date fecha) {
		_fecha = fecha;
	}
	
	public MotivoSalidaDomain getMotivoSalida() {
		return _motivo_salida;
	}

	public void setMotivoSalida(MotivoSalidaDomain motivo) {
		_motivo_salida = motivo;
	}
	
	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		_descripcion = descripcion;
	}
	
	public Set<SalidaDetalleDomain> getSalidaDetalles() {
		return _salida_detalles;
	}

	public void setSalidaDetalles(Set<SalidaDetalleDomain> salidaDetalles) {
		this._salida_detalles = salidaDetalles;
	}

}
