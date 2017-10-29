package com.sd.uni.biblioteca.resource;



import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.reserva.ReservaDTO;
import com.sd.uni.biblioteca.dto.reserva.ReservaResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.reserva.IReservaService;

@Path("/reserva")
@Component
public class ReservaResource {
	@Autowired
	private IReservaService reservaService;

	@GET
	@Path("/{id}")
	@Produces("application/json")

	public ReservaDTO getById(@PathParam("id") Integer reservaId) throws BibliotecaException {
		return reservaService.getById(reservaId);

	}

	@GET
	@Produces("application/xml")
	public ReservaResult getAll() {
		return reservaService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public ReservaResult search(@PathParam("textToFind") String textToFind) {
		return reservaService.find(textToFind);
	}

	@POST
	public ReservaDTO save(ReservaDTO reserva) {
		
		return reservaService.save(reserva);
	}
}
