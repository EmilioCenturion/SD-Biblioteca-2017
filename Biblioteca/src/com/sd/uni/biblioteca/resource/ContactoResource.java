package com.sd.uni.biblioteca.resource;

import javax.ws.rs.GET;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.contacto.ContactoDto;
import com.sd.uni.biblioteca.dto.contacto.ContactoResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.contacto.IContactoService;


@Path("/contacto")
@Component
public class ContactoResource {

	@Autowired
	private IContactoService _contactoService;
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public ContactoDto getById(@PathParam("id") Integer contactoId) throws BibliotecaException {
		return _contactoService.getById(contactoId);
	}
	
	
	@GET
	@Produces("application/xml")
	public ContactoResult getAll() throws BibliotecaException{
		return _contactoService.getAll();
	}
	

	@GET
	@Path("/search/{textToFind}")
	@Produces("application/xml")
	public ContactoResult search(@PathParam("textToFind") String textToFind) throws BibliotecaException {
		return _contactoService.find(textToFind);
	}

	@POST
	public ContactoDto save(ContactoDto contacto) {
		return _contactoService.save(contacto);
	}
}

