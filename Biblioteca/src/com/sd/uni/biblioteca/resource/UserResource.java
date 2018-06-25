 package com.sd.uni.biblioteca.resource;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.user.UserDTO;
import com.sd.uni.biblioteca.dto.user.UserResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.user.IUserService;

@Path("/user")
@Component
public class UserResource {
	@Autowired
	private IUserService userService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Secured({"ROLE_SUPERUSER", "ROLE_STUDENT","ROLE_TEACHER","ROLE_ADMIN","ROLE_SECRETARY"})
	public UserDTO getById(@PathParam("id") Integer userId) throws BibliotecaException {
		return userService.getById(userId);
	}
	
	@GET
	@Path("/username/{username}")
	@Produces("application/json")
	//Debe estar desprotegido para que desde el formulario de acceso del cliente
	//se pueda buscar el nombre de usuario especificado y comparar la contrasenha en el registro
	//devuelto con la contrasenha especificada en el formulario
	public UserDTO getByUsername(@PathParam("username") String username) {
		return userService.getByUsername(username);
	}

	@GET
	@Produces("application/xml")
	@Secured({"ROLE_SUPERUSER", "ROLE_ADMIN"})
	public UserResult getAll() {
		return userService.getAll();
	}
    
	/* En la carga inicial con createInitialData necesita que save este desprotegido
	 * porque si ningun usuario no existe como te autenticas?
	 * Para solucionar esto se podria tener ya un rol admin y un user admin en la base 
	 * de datos cargado a mano para poder securizar esto */
	@POST
	//@Secured({"ROLE_SUPERUSER", "ROLE_SECRETARY","ROLE_STUDENT","ROLE_TEACHER"})
	public UserDTO save(UserDTO user) {
		return userService.save(user);
	}
	
}
