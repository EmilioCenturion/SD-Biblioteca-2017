package com.sd.uni.biblioteca.domain.usuario;



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
import com.sd.uni.biblioteca.domain.reserva.ReservaDomain;
import com.sd.uni.biblioteca.domain.rol.RolDomain;

@Entity
@Table(name = "usuario")
public class UsuarioDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "nombre", nullable = false, unique = true)
	private String _nombre;
	
	@Column(name = "contrasenha", nullable = false, unique = false)
	private String _contrasenha;

	@ManyToOne
	private RolDomain _rol;
	
	@OneToMany(mappedBy = "_usuario")
	private Set<ReservaDomain> _reservas = new HashSet<>();
	
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
	

	public String getContrasenha() {
		return _contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		_contrasenha = contrasenha;
	}
	
	public RolDomain getRol() {
		return _rol;
	}

	public void setRol(RolDomain rol) {
		_rol = rol;
	}
	
	public Set<ReservaDomain> getReservas() {
		return _reservas;
	}

	public void setReservas(Set<ReservaDomain> reservas) {
		this._reservas = reservas;
	}

}

