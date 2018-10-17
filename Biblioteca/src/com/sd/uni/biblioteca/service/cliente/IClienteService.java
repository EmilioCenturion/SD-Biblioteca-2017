package com.sd.uni.biblioteca.service.cliente;

import com.sd.uni.biblioteca.service.base.IBaseService;
import com.sd.uni.biblioteca.dao.cliente.ClienteDaoImpl;
import com.sd.uni.biblioteca.domain.cliente.ClienteDomain;
import com.sd.uni.biblioteca.dto.cliente.ClienteDto;
import com.sd.uni.biblioteca.dto.cliente.ClienteResult;

public interface IClienteService extends IBaseService<ClienteDto, ClienteDomain, ClienteDaoImpl, ClienteResult>{
	
}