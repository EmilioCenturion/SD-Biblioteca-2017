package com.sd.uni.biblioteca.resource;



import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.disponibilidad.DisponibilidadDTO;
import com.sd.uni.biblioteca.dto.disponibilidad.DisponibilidadResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.disponibilidad.IDisponibilidadService;

@Path("/disponibilidad")
@Component
public class DisponibilidadResource {
	@Autowired
	private IDisponibilidadService disponibilidadService;

	@GET
	@Path("/{id}")
	@Produces("application/json")

	public DisponibilidadDTO getById(@PathParam("id") Integer disponibilidadId) throws BibliotecaException {
		return disponibilidadService.getById(disponibilidadId);

	}

	@GET
	@Produces("application/xml")
	public DisponibilidadResult getAll() {
		return disponibilidadService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public DisponibilidadResult search(@PathParam("textToFind") String textToFind) {
		return disponibilidadService.find(textToFind);
	}

	@POST
	public DisponibilidadDTO save(DisponibilidadDTO disponibilidad) {
		
		return disponibilidadService.save(disponibilidad);
	}
}