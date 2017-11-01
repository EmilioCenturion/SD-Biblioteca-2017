package com.sd.uni.biblioteca.domain.prestamo_detalle;
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
import com.sd.uni.biblioteca.domain.estado.EstadoDomain;
import com.sd.uni.biblioteca.domain.libro.LibroDomain;
import com.sd.uni.biblioteca.domain.prestamo.PrestamoDomain;
import com.sd.uni.biblioteca.domain.rol.RolDomain;
import com.sd.uni.biblioteca.domain.usuario.UsuarioDomain;

@Entity
@Table(name = "prestamo_detalle")
public class PrestamoDetalleDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	
	@Column(name = "fecha_devolucion", nullable = false, unique = true)
	private Date _fecha_devolucion;
	
	@ManyToOne
	private PrestamoDomain _prestamo;
	
	@ManyToOne
	private EstadoDomain _estado;
	
	@ManyToOne
	private LibroDomain _libro;
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	
	public Date getFecha_devolucion() {
		return _fecha_devolucion;
	}

	public void setFecha_devolucion( Date fecha_devolucion) {
		_fecha_devolucion = fecha_devolucion;
	}
	
}
