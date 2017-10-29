package com.sd.uni.biblioteca.domain.reserva;



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
import com.sd.uni.biblioteca.domain.reservaDetalle.ReservaDetalleDomain;
import com.sd.uni.biblioteca.domain.usuario.UsuarioDomain;

@Entity
@Table(name = "reserva")
public class ReservaDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "fechaPedido", nullable = false, unique = true)
	private Date _fechaPedido;
	
	@Column(name = "fechaReserva", nullable = false, unique = true)
	private Date _fechaReserva;
	
	
	@ManyToOne
	private UsuarioDomain _usuario;
	
	@OneToMany(mappedBy = "_reserva")
	private Set<ReservaDetalleDomain> _reservaDetalles = new HashSet<>();
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public Date getFechaReserva() {
		return _fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		_fechaReserva = fechaReserva;
	}
	
	public Date getFechaPedido() {
		return _fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		_fechaPedido = fechaPedido;
	}

	
	public UsuarioDomain getUsuario() {
		return _usuario;
	}

	public void setUsuario(UsuarioDomain usuario) {
		_usuario = usuario;
	}
	
	public Set<ReservaDetalleDomain> getReservaDetalles() {
		return _reservaDetalles;
	}

	public void setReservaDetalles(Set<ReservaDetalleDomain> reservaDetalles) {
		this._reservaDetalles = reservaDetalles;
	}


}


