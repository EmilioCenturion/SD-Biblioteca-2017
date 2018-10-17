package com.sd.uni.biblioteca.domain.contacto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sd.uni.biblioteca.domain.base.BaseDomain;

@Entity
@Table(name = "contacto")
public class ContactoDomain extends BaseDomain{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@Column(name = "nombre")
	private String _nombre;
	
	@Column(name = "apellido")
	private String _apellido;
	
	@Column(name = "telefono")
	private String _telefono;
	
	@Column(name = "correo")
	private String _correo;
	
	@Column(name = "mensaje")
	private String _mensaje;
	
	
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
	
	public String getMensaje() {
		return _mensaje;
	}
	public void setMensaje(String mensaje) {
		_mensaje = mensaje;
	}
	

}
