package com.sd.uni.biblioteca.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sd.uni.biblioteca.dto.estado_general.Estado_generalDTO;
import com.sd.uni.biblioteca.dto.estado_general.Estado_generalResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.estado_general.IEstado_generalService;

@Path("/estado_general")
@Component
public class Estado_generalResource {
	@Autowired
	private IEstado_generalService estado_generalService;

	@GET
	@Path("/{id}")
	@Produces("application/json")

	public Estado_generalDTO getById(@PathParam("id") Integer estado_generalId) throws BibliotecaException {
		return estado_generalService.getById(estado_generalId);

	}

	@GET
	@Produces("application/xml")
	public Estado_generalResult getAll() {
		return estado_generalService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public Estado_generalResult search(@PathParam("textToFind") String textToFind) {
		return estado_generalService.find(textToFind);
	}


}
