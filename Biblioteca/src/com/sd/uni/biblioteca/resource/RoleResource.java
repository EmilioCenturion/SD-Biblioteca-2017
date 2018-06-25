package com.sd.uni.biblioteca.resource;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.dto.role.RoleDTO;
import com.sd.uni.biblioteca.dto.role.RoleResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.role.IRoleService;

@Path("/role")
@Component
public class RoleResource {
	@Autowired
	private IRoleService roleService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public RoleDTO getById(@PathParam("id") Integer roleId) throws BibliotecaException {
		return roleService.getById(roleId);
	}

	@GET
	@Produces("application/xml")
	@Secured({"ROLE_SUPERUSER", "ROLE_SECRETARY","ROLE_STUDENT","ROLE_TEACHER","ROLE_ADMIN"})
	public RoleResult getAll() {
		return roleService.getAll();
	}
		
	@GET
	@Path("/authority/{authority}")
	@Produces("application/xml")
	@Secured({"ROLE_SUPERUSER", "ROLE_SECRETARY","ROLE_STUDENT","ROLE_TEACHER","ROLE_ADMIN"})
	public RoleResult getAllBy(@PathParam("authority") String authority){
		Map<String, String> args = new HashMap<>();
		args.put("authority", authority);

		return roleService.getAllBy(args);
	}
	
	/* En la carga inicial con createInitialData necesita que save este desprotegido
	 * porque si ningun usuario no existe como te autenticas?
	 * Para solucionar esto se podria tener ya un rol admin y un user admin en la base 
	 * de datos cargado a mano para poder securizar esto */
	@POST
	//@Secured({"ROLE_SUPERUSER"})//si esta activo, no se podra crear roles iniciales usando los servicios
	public RoleDTO save(RoleDTO role) {
		return roleService.save(role);
	}
	
	@DELETE
	@Path("/{id}")
	@Secured({"ROLE_SUPERUSER"})
	public RoleDTO delete(@PathParam("id") Integer roleId) throws BibliotecaException{
		return roleService.delete(roleService.getById(roleId));		
	}
}
