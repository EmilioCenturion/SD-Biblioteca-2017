package com.sd.uni.biblioteca.resource;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.rol.RolDTO;
import com.sd.uni.biblioteca.dto.rol.RolResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.rol.IRolService;

@Path("/rol")
@Component
public class RolResource {
	@Autowired
	private IRolService rolService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN", "ROLE_STUDENT"})
	public RolDTO getById(@PathParam("id") Integer rolId) throws BibliotecaException {
		return rolService.getById(rolId);
	}

	@GET
	@Produces("application/xml")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN", "ROLE_STUDENT"})
	public RolResult getAll() {
		return rolService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN", "ROLE_STUDENT"})
	public RolResult search(@PathParam("textToFind") String textToFind) {
		return rolService.find(textToFind);
	}

	@POST
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN", "ROLE_STUDENT"})
	public RolDTO save(RolDTO rol) {
		return rolService.save(rol);
	}
}
