/* Al ejecutar esta clase, se crearÃ¡n los roles y usuarios necesarios
 * en la base de datos, para comenzar a utilizar la aplicaciÃ³n
 * Nota: El webservice debe estar corriendo para que esto funcione, o darÃ¡ un error de connection refused
 * 	     Para que esto funcione se tuvo que crear un agujero en la seguridad en applicationContext
 *       se da un permitAll() a user y en los service de user de comentaron las anotaciones
 *       @Secured para guardar user, lo cual es totalmente inseguro
 */
import java.util.ArrayList;
import java.util.List;

import com.sd.uni.biblioteca.dto.configuracion.ConfiguracionDTO;
import com.sd.uni.biblioteca.dto.role.RoleDTO;
import com.sd.uni.biblioteca.dto.user.UserDTO;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class CreateInitialData {

	public static void main(String[] args) {

		final String BASE_URL = "http://localhost:8080/biblioteca-platform/rest";
		com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create();

		/* Roles */
		
		final RoleDTO r1 = new RoleDTO();
		r1.setAuthority("ROLE_SUPERUSER");
		final RoleDTO role1 = client.resource(BASE_URL + "/role").entity(r1).post(RoleDTO.class);

		final RoleDTO r2 = new RoleDTO();
		r2.setAuthority("ROLE_ADMIN");
		RoleDTO role2 = client.resource(BASE_URL + "/role").entity(r2).post(RoleDTO.class);

		final RoleDTO r3 = new RoleDTO();
		r3.setAuthority("ROLE_SECRETARY");
		final RoleDTO role3 = client.resource(BASE_URL + "/role").entity(r3).post(RoleDTO.class);
				
		r3.setAuthority("ROLE_STUDENT");
		client.resource(BASE_URL + "/role").entity(r3).post(RoleDTO.class);
		
		r3.setAuthority("ROLE_TEACHER");
		client.resource(BASE_URL + "/role").entity(r3).post(RoleDTO.class);

		System.out.println("<< Roles Creados >>");

		/* Usuarios */
		
		List<Integer> rolesIds = new ArrayList<>();
		rolesIds.add(role1.getId());
		rolesIds.add(role2.getId());

		UserDTO user = new UserDTO();
		user.setUsername("admin");
		user.setPassword("admin");
		user.setAccountLocked("true");
		user.setName("Florinda Meza");
		user.setType("Empleado");
		user.setRolesIds(rolesIds);
		
		client.resource(BASE_URL + "/user").entity(user).post(UserDTO.class);

		rolesIds = new ArrayList<>();
		rolesIds.add(role3.getId());

		user = new UserDTO();
		user.setUsername("secretary");
		user.setPassword("secretary");
		user.setAccountLocked("true");
		user.setName("DoÃ±a Clotilde");
		user.setType("Empleado");
		user.setRolesIds(rolesIds);
		client.resource(BASE_URL + "/user").entity(user).post(UserDTO.class);
	
		System.out.println("<< Usuarios Creados >>");
		
		
		/*  "se inicia sessión" */
		HTTPBasicAuthFilter feature = new HTTPBasicAuthFilter("admin", "admin");
		/*se crea una nuevo cliente con esa sesión para tener los permisos necesarios para cambiar la configuración */
		com.sun.jersey.api.client.Client jerseyClient = com.sun.jersey.api.client.Client.create();
		jerseyClient.addFilter(feature);

		
		/* CONFIGURACION */
		ConfiguracionDTO conf = new ConfiguracionDTO();
		conf.setMailUsername("rodrickclash");
		conf.setMailPassword("rodrickclash54321");
		conf.setMailTo("rodrickclash@gmail.com");
		conf.setSendCantAlumEnabled("false");
		conf.setSendCantProfEnabled("false");
		
		jerseyClient.resource(BASE_URL + "/configuracion").entity(conf).post(ConfiguracionDTO.class);
		
		System.out.println("<< Configuracion Creada >>");
		
		
		System.out.println("Â¡Carga Terminada!");
	}
}
