package com.sd.uni.biblioteca.dto.cliente;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;
import com.sd.uni.biblioteca.dto.cliente.ClienteDto;

import java.util.List;

@XmlRootElement(name = "clienteResult")
public class ClienteResult extends BaseResult<ClienteDto>{
	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<ClienteDto> getClientes() {
		return getList();
	}

	public void setClientes(List<ClienteDto> dtos) {
		super.setList(dtos);
	}

}
