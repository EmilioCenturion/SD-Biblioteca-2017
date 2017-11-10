package com.sd.uni.biblioteca.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.entrada.EntradaDTO;
import com.sd.uni.biblioteca.dto.entrada.EntradaResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.entrada.IEntradaService;

@Path("/entrada")
@Component
public class EntradaResource {
	@Autowired
	private IEntradaService entradaService;

	@GET
	@Path("/{id}")
	@Produces("application/json")

	public EntradaDTO getById(@PathParam("id") Integer entradaId) throws BibliotecaException {
		return entradaService.getById(entradaId);

	}

	@GET
	@Produces("application/xml")
	public EntradaResult getAll() {
		return entradaService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public EntradaResult search(@PathParam("textToFind") String textToFind) {
		return entradaService.find(textToFind);
	}

	@POST
	public EntradaDTO save(EntradaDTO entrada) {
		
		return entradaService.save(entrada);
	}
	
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	public EntradaResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page,
			@PathParam("max") Integer maxItems) throws BibliotecaException {
		return entradaService.find(textToFind, page, maxItems);
	}

	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	public EntradaResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems)
			throws BibliotecaException {
		return entradaService.find(null, page, maxItems);
	}
}
