package com.sd.uni.biblioteca.resource;



import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
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

	public EntradaDetalleDTO getById(@PathParam("id") Integer entradaDetalleId) throws BibliotecaException {
		return entradaDetalleService.getById(entradaDetalleId);

	}

	@GET
	@Produces("application/xml")
	public EntradaDetalleResult getAll() {
		return entradaDetalleService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public EntradaDetalleResult search(@PathParam("textToFind") String textToFind) {
		return entradaDetalleService.find(textToFind);
	}

	@POST
	public EntradaDetalleDTO save(EntradaDetalleDTO entradaDetalle) {
		
		return entradaDetalleService.save(entradaDetalle);
	}
}