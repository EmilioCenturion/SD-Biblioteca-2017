package com.sd.uni.biblioteca.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.prestamo.PrestamoDTO;
import com.sd.uni.biblioteca.dto.prestamo.PrestamoResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.prestamo.IPrestamoService;

@Path("/prestamo")
@Component
public class PrestamoResource {
	@Autowired
	private IPrestamoService prestamoService;

	@GET
	@Path("/{id}")
	@Produces("application/json")

	public PrestamoDTO getById(@PathParam("id") Integer prestamoId) throws BibliotecaException {
		return prestamoService.getById(prestamoId);

	}

	@GET
	@Produces("application/xml")
	public PrestamoResult getAll() {
		return prestamoService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public PrestamoResult search(@PathParam("textToFind") String textToFind) {
		return prestamoService.find(textToFind);
	}

	@POST
	public PrestamoDTO save(PrestamoDTO prestamo) {
		
		return prestamoService.save(prestamo);
	}
}
