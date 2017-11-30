package com.sd.uni.biblioteca.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.autor.AutorDTO;
import com.sd.uni.biblioteca.dto.autor.AutorResult;
import com.sd.uni.biblioteca.dto.rol.RolDTO;
import com.sd.uni.biblioteca.dto.rol.RolResult;
import com.sd.uni.biblioteca.dto.usuario.UsuarioResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.autor.IAutorService;
import com.sd.uni.biblioteca.service.rol.IRolService;

@Path("/autor")
@Component
public class AutorResource {
	@Autowired
	private IAutorService autorService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN", "ROLE_STUDENT"})
	public AutorDTO getById(@PathParam("id") Integer autorId) throws BibliotecaException {
		return autorService.getById(autorId);
	}

	@GET
	@Produces("application/xml")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN", "ROLE_STUDENT"})
	public AutorResult getAll() {
		return autorService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN", "ROLE_STUDENT"})
	public AutorResult search(@PathParam("textToFind") String textToFind) {
		return autorService.find(textToFind);
	}

	@POST
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN", "ROLE_STUDENT"})
	public AutorDTO save(AutorDTO autor) {
		return autorService.save(autor);
	}
	
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN", "ROLE_STUDENT"})
	public AutorResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws BibliotecaException {
		return autorService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN", "ROLE_STUDENT"})
	public AutorResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems)
			throws BibliotecaException {
		return autorService.find(null, page, maxItems);
	}
}

