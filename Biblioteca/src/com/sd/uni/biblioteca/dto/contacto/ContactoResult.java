package com.sd.uni.biblioteca.dto.contacto;

import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;
import com.sd.uni.biblioteca.dto.contacto.ContactoDto;

import java.util.List;

@XmlRootElement(name = "contactoResult")
public class ContactoResult extends BaseResult<ContactoDto>{
	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<ContactoDto> getContactos() {
		return getList();
	}

	public void setContactos(List<ContactoDto> dtos) {
		super.setList(dtos);
	}

}
