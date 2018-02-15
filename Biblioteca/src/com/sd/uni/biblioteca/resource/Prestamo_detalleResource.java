package com.sd.uni.biblioteca.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.prestamo_detalle.PrestamoDetalleDTO;
import com.sd.uni.biblioteca.dto.prestamo_detalle.PrestamoDetalleResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.prestamo_detalle.IPrestamoDetalleService;

@Path("/prestamoDetalle")
@Component
public class Prestamo_detalleResource {
	@Autowired
	private IPrestamoDetalleService prestamo_detalleService;

	@GET
	@Path("/{id}")
	@Produces("application/json")

	public PrestamoDetalleDTO getById(@PathParam("id") Integer prestamo_detalleId) throws BibliotecaException {
		return prestamo_detalleService.getById(prestamo_detalleId);

	}

	@GET
	@Produces("application/xml")
	public PrestamoDetalleResult getAll() {
		return prestamo_detalleService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public PrestamoDetalleResult search(@PathParam("textToFind") String textToFind) {
		return prestamo_detalleService.find(textToFind);
	}

	@POST
	public PrestamoDetalleDTO save(PrestamoDetalleDTO prestamo_detalle) {
		
		return prestamo_detalleService.save(prestamo_detalle);
	}
}

