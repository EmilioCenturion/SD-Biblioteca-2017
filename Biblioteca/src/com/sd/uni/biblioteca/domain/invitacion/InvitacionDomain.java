package com.sd.uni.biblioteca.domain.invitacion;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.sd.uni.biblioteca.domain.base.BaseDomain;
import com.sd.uni.biblioteca.domain.cliente.ClienteDomain;

@Entity
@Table(name = "oferta")
public class InvitacionDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@Column(name = "email")
	private String _email;
	
	@ManyToOne
	private ClienteDomain _cliente;
	
	@Column(name = "fecha_creacion")
	private Date _fecha_creacion;
	
	@Column(name = "fecha_envio")
	private Date _fecha_envio;
	
	public Integer getId(){
		return _id;
	}
	
	public void setId(Integer id){
		_id = id;
	}
	
	public ClienteDomain getCliente(){
		return _cliente;
	}
	
	public void setCliente(ClienteDomain cliente){
		_cliente = cliente;
	}
	
	public String getEmail(){
		return _email;
	}
	
	public void setEmail(String email){
		_email = email;
	}
	
	public Date getFechaCreacion(){
		return _fecha_creacion;
	}
	
	public void setFechaCreacion(Date fecha_creacion){
		_fecha_creacion = fecha_creacion;
	}
	
	public Date getFechaEnvio(){
		return _fecha_envio;
	}
	
	public void setFechaEnvio(Date fecha_envio){
		_fecha_envio = fecha_envio;
	}
	
	
}
