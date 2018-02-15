package com.sd.uni.biblioteca.domain.entrada;



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
import com.sd.uni.biblioteca.domain.entradaDetalle.EntradaDetalleDomain;
import com.sd.uni.biblioteca.domain.motivoEntrada.MotivoEntradaDomain;

@Entity
@Table(name = "entrada")
public class EntradaDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "fecha", nullable = false, unique = false)
	private Date _fecha;
	
	@Column(name = "descripcion", nullable = false, unique = false)
	private String _descripcion;

	@ManyToOne
	private MotivoEntradaDomain _motivoEntrada;
	
	@OneToMany(mappedBy = "_entrada")
	private Set<EntradaDetalleDomain> _entradaDetalles = new HashSet<>();
	
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
	

	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		_descripcion = descripcion;
	}
	
	public MotivoEntradaDomain getMotivoEntrada() {
		return _motivoEntrada;
	}

	public void setMotivoEntrada(MotivoEntradaDomain motivoEntrada) {
		_motivoEntrada = motivoEntrada;
	}
	
	public Set<EntradaDetalleDomain> getEntradaDetalles() {
		return _entradaDetalles;
	}

	public void setEntradaDetalles(Set<EntradaDetalleDomain> entradaDetalles) {
		this._entradaDetalles = entradaDetalles;
	}


}


