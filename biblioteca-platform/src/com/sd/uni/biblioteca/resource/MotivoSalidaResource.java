package com.sd.uni.biblioteca.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.motivoSalida.MotivoSalidaDTO;
import com.sd.uni.biblioteca.dto.motivoSalida.MotivoSalidaResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.motivoSalida.IMotivoSalidaService;

@Path("/motivoSalida")
@Component
public class MotivoSalidaResource {
	@Autowired
	private IMotivoSalidaService motivoSalidaService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public MotivoSalidaDTO getById(@PathParam("id") Integer motivoSalidaId) throws BibliotecaException {
		return motivoSalidaService.getById(motivoSalidaId);
	}

	@GET
	@Produces("application/xml")
	public MotivoSalidaResult getAll() {
		return motivoSalidaService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public MotivoSalidaResult search(@PathParam("textToFind") String textToFind) {
		return motivoSalidaService.find(textToFind);
	}

	@POST
	public MotivoSalidaDTO save(MotivoSalidaDTO motivoSalida) {
		return motivoSalidaService.save(motivoSalida);
	}
}
