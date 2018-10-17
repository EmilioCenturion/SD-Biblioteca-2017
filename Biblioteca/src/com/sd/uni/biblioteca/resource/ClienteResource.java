package com.sd.uni.biblioteca.resource;


import javax.ws.rs.GET;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.cliente.ClienteDto;
import com.sd.uni.biblioteca.dto.cliente.ClienteResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.cliente.IClienteService;


@Path("/cliente")
@Component
public class ClienteResource {

	@Autowired
	private IClienteService _clienteService;
	

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public ClienteDto getById(@PathParam("id") Integer clienteId) throws BibliotecaException {
		return _clienteService.getById(clienteId);
	}
	

	@GET
	@Produces("application/xml")
	public ClienteResult getAll() throws BibliotecaException{
		return _clienteService.getAll();
	}
	

	@GET
	@Path("/search/{textToFind}")
	@Produces("application/xml")
	public ClienteResult search(@PathParam("textToFind") String textToFind) throws BibliotecaException {
		return _clienteService.find(textToFind);
	}

	@POST
	public ClienteDto save(ClienteDto cliente) {
		return _clienteService.save(cliente);
	}
}
