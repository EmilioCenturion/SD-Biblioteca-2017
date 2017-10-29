package com.sd.uni.biblioteca.resource;



import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.reservaDetalle.ReservaDetalleDTO;
import com.sd.uni.biblioteca.dto.reservaDetalle.ReservaDetalleResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.reservaDetalle.IReservaDetalleService;

@Path("/reservaDetalle")
@Component
public class ReservaDetalleResource {
	@Autowired
	private IReservaDetalleService reservaDetalleService;

	@GET
	@Path("/{id}")
	@Produces("application/json")

	public ReservaDetalleDTO getById(@PathParam("id") Integer reservaDetalleId) throws BibliotecaException {
		return reservaDetalleService.getById(reservaDetalleId);

	}

	@GET
	@Produces("application/xml")
	public ReservaDetalleResult getAll() {
		return reservaDetalleService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public ReservaDetalleResult search(@PathParam("textToFind") String textToFind) {
		return reservaDetalleService.find(textToFind);
	}

	@POST
	public ReservaDetalleDTO save(ReservaDetalleDTO reservaDetalle) {
		
		return reservaDetalleService.save(reservaDetalle);
	}
}
