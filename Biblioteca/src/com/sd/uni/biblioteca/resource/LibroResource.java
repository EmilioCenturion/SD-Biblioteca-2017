package com.sd.uni.biblioteca.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.libro.LibroDTO;
import com.sd.uni.biblioteca.dto.libro.LibroResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.libro.ILibroService;

@Path("/libro")
@Component
public class LibroResource {
	@Autowired
	private ILibroService libroService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN"})
	public LibroDTO getById(@PathParam("id") Integer libroId) throws BibliotecaException {
		return libroService.getById(libroId);

	}

	@GET
	@Produces("application/xml")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN"})
	public LibroResult getAll() {
		return libroService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN"})
	public LibroResult search(@PathParam("textToFind") String textToFind) {
		return libroService.find(textToFind);
	}

	@POST
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN"})
	public LibroDTO save(LibroDTO libro) {
		
		return libroService.save(libro);
	}
	
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN"})
	public LibroResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws BibliotecaException {
		return libroService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN"})
	public LibroResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems)
			throws BibliotecaException {
		return libroService.find(null, page, maxItems);
	}
}
