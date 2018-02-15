package com.sd.uni.biblioteca.resource;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.service.configuracion.IConfiguracionService;
import com.sd.uni.biblioteca.dto.configuracion.ConfiguracionDTO;
import com.sd.uni.biblioteca.exception.BibliotecaException;

@Path("/configuracion")
@Component
public class ConfiguracionResource {

	@Autowired
	private IConfiguracionService configuracionService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN"})
	public ConfiguracionDTO getById(@PathParam("id") Integer configuracionId) throws BibliotecaException{
		return configuracionService.getById(configuracionId);
	}		

	@POST
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN"})
	public ConfiguracionDTO save(ConfiguracionDTO configuracion){
		return configuracionService.save(configuracion);
	}

}