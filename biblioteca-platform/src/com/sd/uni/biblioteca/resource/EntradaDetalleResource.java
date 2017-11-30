package com.sd.uni.biblioteca.resource;



import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.entradaDetalle.EntradaDetalleDTO;
import com.sd.uni.biblioteca.dto.entradaDetalle.EntradaDetalleResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.entradaDetalle.IEntradaDetalleService;

@Path("/entradaDetalle")
@Component
public class EntradaDetalleResource {
	@Autowired
	private IEntradaDetalleService entradaDetalleService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN", "ROLE_STUDENT"})
	public EntradaDetalleDTO getById(@PathParam("id") Integer entradaDetalleId) throws BibliotecaException {
		return entradaDetalleService.getById(entradaDetalleId);

	}

	@GET
	@Produces("application/xml")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN", "ROLE_STUDENT"})
	public EntradaDetalleResult getAll() {
		return entradaDetalleService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN", "ROLE_STUDENT"})
	public EntradaDetalleResult search(@PathParam("textToFind") String textToFind) {
		return entradaDetalleService.find(textToFind);
	}

	@POST
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN", "ROLE_STUDENT"})
	public EntradaDetalleDTO save(EntradaDetalleDTO entradaDetalle) {
		
		return entradaDetalleService.save(entradaDetalle);
	}
}
