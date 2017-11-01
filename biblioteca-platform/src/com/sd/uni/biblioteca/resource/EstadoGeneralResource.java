package com.sd.uni.biblioteca.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.estado_general.EstadoGeneralDTO;
import com.sd.uni.biblioteca.dto.estado_general.EstadoGeneralResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.estado_general.IEstadoGeneralService;

@Path("/estado_general")
@Component
public class EstadoGeneralResource {
	@Autowired
	private IEstadoGeneralService estado_generalService;

	@GET
	@Path("/{id}")
	@Produces("application/json")

	public EstadoGeneralDTO getById(@PathParam("id") Integer estado_generalId) throws BibliotecaException {
		return estado_generalService.getById(estado_generalId);

	}

	@GET
	@Produces("application/xml")
	public EstadoGeneralResult getAll() {
		return estado_generalService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public EstadoGeneralResult search(@PathParam("textToFind") String textToFind) {
		return estado_generalService.find(textToFind);
	}


}
