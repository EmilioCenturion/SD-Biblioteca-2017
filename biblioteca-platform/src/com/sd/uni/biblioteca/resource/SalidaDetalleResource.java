package com.sd.uni.biblioteca.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.salidaDetalle.SalidaDetalleDTO;
import com.sd.uni.biblioteca.dto.salidaDetalle.SalidaDetalleResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.salidaDetalle.ISalidaDetalleService;

@Path("/salidaDetalle")
@Component
public class SalidaDetalleResource {
	@Autowired
	private ISalidaDetalleService salidaDetalleService;

	@GET
	@Path("/{id}")
	@Produces("application/json")

	public SalidaDetalleDTO getById(@PathParam("id") Integer salidaDetalleId) throws BibliotecaException {
		return salidaDetalleService.getById(salidaDetalleId);

	}

	@GET
	@Produces("application/xml")
	public SalidaDetalleResult getAll() {
		return salidaDetalleService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public SalidaDetalleResult search(@PathParam("textToFind") String textToFind) {
		return salidaDetalleService.find(textToFind);
	}

	@POST
	public SalidaDetalleDTO save(SalidaDetalleDTO salidaDetalle) {
		
		return salidaDetalleService.save(salidaDetalle);
	}
}
