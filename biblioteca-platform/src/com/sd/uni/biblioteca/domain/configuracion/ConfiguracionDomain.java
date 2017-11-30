package com.sd.uni.biblioteca.domain.configuracion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sd.uni.biblioteca.domain.base.BaseDomain;

@Entity
@Table(name = "configuracion")
public class ConfiguracionDomain extends BaseDomain{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	@Column(name = "mail_username", nullable = false, length = 100)
	private String _mailUsername;

	@Column(name = "mail_password", nullable = false, length = 100)
	private String _mailPassword;
	
	@Column(name = "mail_to", nullable = false, length = 100)
	private String _mailTo;

	@Column(name = "send_cant_alum_enabled", nullable = false)
	private Boolean _sendCantAlumEnabled;

	@Column(name = "send_cant_prof_enabled", nullable = false)
	private Boolean _sendCantProfEnabled;
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer _id) {
		this._id = _id;
	}
	
	public String getMailUsername(){
		return _mailUsername;
	}

	public void setMailUsername(String mailUsername){
		_mailUsername= mailUsername;
	}
	
	public String getMailPassword(){
		return _mailPassword;
	}
	
	public void setMailTo(String mailTo){
		_mailTo= mailTo;
	}
	
	public String getMailTo(){
		return _mailTo;
	}

	public void setMailPassword(String mailPassword){
		_mailPassword= mailPassword;
	}
	
	public String getSendCantAlumEnabled(){
		return _sendCantAlumEnabled.toString();
	}

	public void setSendCantAlumEnabled(String sendCantAlumEnabled){
		_sendCantAlumEnabled= Boolean.valueOf(sendCantAlumEnabled);
	}
	
	public String getSendCantProfEnabled(){
		return _sendCantProfEnabled.toString();
	}

	public void setSendCantProfEnabled(String sendCantProfEnabled){
		_sendCantProfEnabled= Boolean.valueOf(sendCantProfEnabled);
	}
}