package com.sd.uni.biblioteca.resource;

import java.text.ParseException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.salida.SalidaDTO;
import com.sd.uni.biblioteca.dto.salida.SalidaResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.salida.ISalidaService;

@Path("/salida")
@Component
public class SalidaResource {
	@Autowired
	private ISalidaService salidaService;

	@GET
	@Path("/{id}")
	@Produces("application/json")

	public SalidaDTO getById(@PathParam("id") Integer salidaId) throws BibliotecaException {
		return salidaService.getById(salidaId);

	}

	@GET
	@Produces("application/xml")
	public SalidaResult getAll() {
		return salidaService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public SalidaResult search(@PathParam("textToFind") String textToFind) {
		return salidaService.find(textToFind);
	}

	@POST
	public SalidaDTO save(SalidaDTO salida) {
		
		return salidaService.save(salida);
	}
	
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	public SalidaResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page,
			@PathParam("max") Integer maxItems) throws BibliotecaException, ParseException {
		return salidaService.find(textToFind, page, maxItems);
	}

	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	public SalidaResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems)
			throws BibliotecaException, ParseException {
		return salidaService.find(null, page, maxItems);
	}
}
