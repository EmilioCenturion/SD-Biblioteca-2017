package com.sd.uni.biblioteca.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN", "ROLE_STUDENT"})
	public EstadoDTO getById(@PathParam("id") Integer estadoId) throws BibliotecaException {
		return estadoService.getById(estadoId);

	}

	@GET
	@Produces("application/xml")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN", "ROLE_STUDENT"})
	public EstadoResult getAll() {
		return estadoService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN", "ROLE_STUDENT"})
	public EstadoResult search(@PathParam("textToFind") String textToFind) {
		return estadoService.find(textToFind);
	}

	@POST
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN", "ROLE_STUDENT"})
	public EstadoDTO save(EstadoDTO estado) {
		
		return estadoService.save(estado);
	}
}

