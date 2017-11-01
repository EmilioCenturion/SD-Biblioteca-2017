package com.sd.uni.biblioteca.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.categoria.CategoriaDTO;
import com.sd.uni.biblioteca.dto.categoria.CategoriaResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.categoria.ICategoriaService;

@Path("/categoria")
@Component
public class CategoriaResource {
	@Autowired
	private ICategoriaService categoriaService;

	@GET
	@Path("/{id}")
	@Produces("application/json")

	public CategoriaDTO getById(@PathParam("id") Integer categoriaId) throws BibliotecaException {
		Object categoriaId1 = null;
		return categoriaService.getById(categoriaId);

	}

	@GET
	@Produces("application/xml")
	public CategoriaResult getAll() {
		return categoriaService.getAll();
	}

	@GET
	@Path("search/{textToFind}")
	@Produces("application/xml")
	public CategoriaResult search(@PathParam("textToFind") String textToFind) {
		return categoriaService.find(textToFind);
	}

	@POST
	public CategoriaDTO save(CategoriaDTO categoria) {
		
		return categoriaService.save(categoria);
	}
}

