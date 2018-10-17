package com.sd.uni.biblioteca.dto.contacto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "contacto")
public class ContactoDto extends BaseDTO{
	private static final long serialVersionUID = 1L;
	private String _nombre;
	private String _apellido;
	private String _telefono;
	private String _correo;
	private String _mensaje;


	@XmlElement
	public String getNombre() {
		return _nombre;
	}
	
	public void setNombre(String nombre) {
		_nombre = nombre;
	}
	
	@XmlElement
	public String getApellido() {
		return _apellido;
	}
	
	public void setApellido(String apellido) {
		_apellido = apellido;
	}
	
	@XmlElement
	public String getTelefono() {
		return _telefono;
	}
	
	public void setTelefono(String telefono) {
		_telefono = telefono;
	}
	
	@XmlElement
	public String getCorreo() {
		return _correo;
	}
	
	public void setCorreo(String correo) {
		_correo = correo;
	}
	
	@XmlElement
	public String getMensaje() {
		return _mensaje;
	}
	
	public void setMensaje(String mensaje) {
		_mensaje = mensaje;
	}
	
}