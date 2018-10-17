package com.sd.uni.biblioteca.domain.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sd.uni.biblioteca.domain.base.BaseDomain;

@Entity
@Table(name = "cliente")
public class ClienteDomain extends BaseDomain{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@Column(name = "nombre")
	private String _nombre;
	
	@Column(name = "apellido")
	private String _apellido;
	
	@Column(name = "ci")
	private Integer _ci;
	
	@Column(name = "ruc")
	private String _ruc;
	
	@Column(name = "telefono")
	private String _telefono;
	
	@Column(name = "correo")
	private String _correo;
	
	@Column(name = "direccion")
	private String _direccion;
	
	@Column(name = "invitacion")
	private boolean _invitacion;
	
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
	
	public String getApellido() {
		return _apellido;
	}
	public void setApellido(String apellido) {
		_apellido = apellido;
	}
	
	public Integer getCi() {
		return _ci;
	}
	public void setCi(Integer ci) {
		_ci = ci;
	}
	
	public String getRuc() {
		return _ruc;
	}
	public void setRuc(String ruc) {
		_ruc = ruc;
	}
	
	public String getTelefono() {
		return _telefono;
	}
	public void setTelefono(String telefono) {
		_telefono = telefono;
	}
	
	public String getCorreo() {
		return _correo;
	}
	public void setCorreo(String correo) {
		_correo = correo;
	}
	
	public String getDireccion() {
		return _direccion;
	}
	public void setDireccion(String direccion) {
		_direccion = direccion;
	}
	
	public boolean getInvitacion() {
		return _invitacion;
	}
	public void setInvitacion(boolean invitacion) {
		_invitacion = invitacion;
	}
	
	
}
