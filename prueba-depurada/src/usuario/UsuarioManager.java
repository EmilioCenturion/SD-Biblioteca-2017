package usuario;

import base.AbstractBaseManager;
import com.sd.uni.biblioteca.dto.usuario.UsuarioDTO;
import com.sd.uni.biblioteca.dto.usuario.UsuarioResult;
import com.sd.uni.biblioteca.dto.rol.RolDTO;
import com.sd.uni.biblioteca.dto.rol.RolResult;

public class UsuarioManager extends AbstractBaseManager {
	public UsuarioManager() {
		super();
		addRols();
		
	}
	
	public void addRols(){
		
		RolDTO rolDTO1 = new RolDTO();
		rolDTO1.setNombre("Administrado");
		
		RolDTO rolDTO2 = new RolDTO();
		rolDTO2.setNombre("Secretaria");
		
		RolDTO rolDTO3 = new RolDTO();
		rolDTO3.setNombre("Doctor");
		
		getJerseyClient().resource(getBaseUrl() + "/rol").entity(rolDTO1).post(RolDTO.class);
		getJerseyClient().resource(getBaseUrl() + "/rol").entity(rolDTO2).post(RolDTO.class);
		getJerseyClient().resource(getBaseUrl() + "/rol").entity(rolDTO3).post(RolDTO.class);
		
	}
	
	public void addUsuario(String nombre, String contrasenha, Integer rolId) {
		
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setNombre(nombre);
		usuarioDTO.setContrasenha(contrasenha);
		usuarioDTO.setRolId(rolId);
		
		getJerseyClient().resource(getBaseUrl() + "/usuario").entity(usuarioDTO).post(UsuarioDTO.class);
	}
	
	
	public void getAllUsuarios() {
		UsuarioResult usuarioResult = getJerseyClient().resource(getBaseUrl() + "/usuario").get(UsuarioResult.class);
		for (UsuarioDTO p : usuarioResult.getUsuarios()) {
			System.out.println("Nombre: "+p.getNombre());
			System.out.println("Contrasenha: "+p.getContrasenha());
			System.out.println("Rol: "+p.getRolId());
			
		}
	}
	
	public void getByIdUsuario(int id){
		UsuarioDTO usuarioResult = getJerseyClient().resource(getBaseUrl() + "/usuario/"+id).get(UsuarioDTO.class);
		System.out.println("Nombre: "+ usuarioResult.getNombre());
		System.out.println("Contrasenha: "+ usuarioResult.getContrasenha());
		System.out.println("Rol: "+ usuarioResult.getRolId());
		
	}
	
	public void getByPropertyUsuario(String textToFind){
		UsuarioResult patResult = getJerseyClient().resource(getBaseUrl() + "/usuario/search/"+textToFind).get(UsuarioResult.class);
		for (UsuarioDTO c : patResult.getUsuarios()) {
			System.out.println("Nombre: "+c.getNombre());
			System.out.println("Contrasenha: "+c.getContrasenha());
			System.out.println("Rol: "+c.getRolId());
			
		}
		
	}
	
}


