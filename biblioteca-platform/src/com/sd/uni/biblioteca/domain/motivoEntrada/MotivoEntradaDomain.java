package com.sd.uni.biblioteca.domain.motivoEntrada;


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
import com.sd.uni.biblioteca.domain.entrada.EntradaDomain;

@Entity
@Table(name = "motivoEntrada")
public class MotivoEntradaDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "descripcion", nullable = false, unique = true)
	private String _descripcion;
	
	@OneToMany(mappedBy = "_motivoEntrada")
	private Set<EntradaDomain> _entradas = new HashSet<>();
	
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
	
	public Set<EntradaDomain> getEntradas() {
		return _entradas;
	}

	public void setEntradas(Set<EntradaDomain> entradas) {
		this._entradas = entradas;
	}

}


