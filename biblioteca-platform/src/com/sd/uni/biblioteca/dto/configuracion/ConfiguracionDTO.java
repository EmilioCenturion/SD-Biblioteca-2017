package com.sd.uni.biblioteca.dto.configuracion;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

@XmlRootElement(name = "configuracion")
public class ConfiguracionDTO extends BaseDTO{

	private static final long serialVersionUID = 1L;
	private String _mailUsername;
	private String _mailPassword;
	private String _mailTo;
	private String _sendCantAlumEnabled;
	private String _sendCantProfEnabled;
	
	@XmlElement
	public String getMailUsername(){
		return _mailUsername;
	}

	public void setMailUsername(String mailUsername){
		_mailUsername= mailUsername;
	}
	
	@XmlElement
	public String getMailPassword(){
		return _mailPassword;
	}
	
	public void setMailPassword(String mailPassword){
		_mailPassword= mailPassword;
	}
	
	@XmlElement
	public String getMailTo(){
		return _mailTo;
	}
	
	public void setMailTo(String mailTo){
		_mailTo= mailTo;
	}
	
	@XmlElement
	public String getSendCantAlumEnabled(){
		return _sendCantAlumEnabled;
	}

	public void setSendCantAlumEnabled(String sendCantAlumEnabled){
		_sendCantAlumEnabled= sendCantAlumEnabled;
	}
	
	@XmlElement
	public String getSendCantProfEnabled(){
		return _sendCantProfEnabled;
	}

	public void setSendCantProfEnabled(String sendCantProfEnabled){
		_sendCantProfEnabled= sendCantProfEnabled;
	}
}