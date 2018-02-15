package com.sd.uni.biblioteca.domain.reservaDetalle;



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
import com.sd.uni.biblioteca.domain.reserva.ReservaDomain;

@Entity
@Table(name = "reservaDetalle")
public class ReservaDetalleDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@ManyToOne
	private LibroDomain _libro;
	
	@ManyToOne
	private ReservaDomain _reserva;
	
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public ReservaDomain getReserva() {
		return _reserva;
	}

	public void setReserva(ReservaDomain reserva) {
		_reserva = reserva;
	}
	
	
	public LibroDomain getLibro() {
		return _libro;
	}

	public void setLibro(LibroDomain libro) {
		_libro = libro;
	}
	

}
