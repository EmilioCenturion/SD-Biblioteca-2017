package com.sd.uni.biblioteca.dto.cliente;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "cliente")
public class ClienteDto extends BaseDTO{
	private static final long serialVersionUID = 1L;
	private String _nombre;
	private String _apellido;
	private Integer _ci;
	private String _ruc;
	private String _telefono;
	private String _correo;
	private String _direccion;
	public boolean _invitacion;


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
	public Integer getCi() {
		return _ci;
	}
	public void setCi(Integer ci) {
		_ci = ci;
	}
	
	@XmlElement
	public String getRuc() {
		return _ruc;
	}
	
	public void setRuc(String ruc) {
		_ruc = ruc;
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
	public String getDireccion() {
		return _direccion;
	}
	
	public void setDireccion(String direccion) {
		_direccion = direccion;
	}
	
	
	@XmlElement
	public boolean getInvitacion() {
		return _invitacion;
	}
	
	public void setInvitacion(boolean invitacion) {
		_invitacion = invitacion;
	}
	
}
