package com.sd.uni.biblioteca.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sd.uni.biblioteca.dto.prestamo_detalle.Prestamo_detalleDTO;
import com.sd.uni.biblioteca.dto.prestamo_detalle.Prestamo_detalleResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.prestamo_detalle.IPrestamo_detalleService;

@Path("/prestamo")
@Component
public class Prestamo_detalleResource {
	@Autowired
	private IPrestamo_detalleService prestamo_detalleService;

	@GET
	@Path("/{id}")
	@Produces("application/json")

	public Prestamo_detalleDTO getById(@PathParam("id") Integer prestamo_detalleId) throws BibliotecaException {
		return prestamo_detalleService.getById(prestamo_detalleId);

	}

	@GET
	@Produces("application/xml")
	public Prestamo_detalleResult getAll() {
		return prestamo_detalleService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public Prestamo_detalleResult search(@PathParam("textToFind") String textToFind) {
		return prestamo_detalleService.find(textToFind);
	}

	@POST
	public Prestamo_detalleDTO save(Prestamo_detalleDTO prestamo_detalle) {
		
		return prestamo_detalleService.save(prestamo_detalle);
	}
}

