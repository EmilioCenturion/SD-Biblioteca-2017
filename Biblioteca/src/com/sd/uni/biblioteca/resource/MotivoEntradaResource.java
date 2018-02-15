package com.sd.uni.biblioteca.resource;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.motivoEntrada.MotivoEntradaDTO;
import com.sd.uni.biblioteca.dto.motivoEntrada.MotivoEntradaResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.motivoEntrada.IMotivoEntradaService;

@Path("/motivoEntrada")
@Component
public class MotivoEntradaResource {
	@Autowired
	private IMotivoEntradaService motivoEntradaService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN"})
	public MotivoEntradaDTO getById(@PathParam("id") Integer motivoEntradaId) throws BibliotecaException {
		return motivoEntradaService.getById(motivoEntradaId);
	}

	@GET
	@Produces("application/xml")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN"})
	public MotivoEntradaResult getAll() {
		return motivoEntradaService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN"})
	public MotivoEntradaResult search(@PathParam("textToFind") String textToFind) {
		return motivoEntradaService.find(textToFind);
	}

	@POST
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN"})
	public MotivoEntradaDTO save(MotivoEntradaDTO motivoEntrada) {
		return motivoEntradaService.save(motivoEntrada);
	}
}
