package com.sd.uni.biblioteca.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.estado.EstadoDTO;
import com.sd.uni.biblioteca.dto.estado.EstadoResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.estado.IEstadoService;

@Path("/estado")
@Component
public class EstadoResource {
	@Autowired
	private IEstadoService estadoService;

	@GET
	@Path("/{id}")
	@Produces("application/json")

	public EstadoDTO getById(@PathParam("id") Integer estadoId) throws BibliotecaException {
		return estadoService.getById(estadoId);

	}

	@GET
	@Produces("application/xml")
	public EstadoResult getAll() {
		return estadoService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public EstadoResult search(@PathParam("textToFind") String textToFind) {
		return estadoService.find(textToFind);
	}

	@POST
	public EstadoDTO save(EstadoDTO estado) {
		
		return estadoService.save(estado);
	}
}

