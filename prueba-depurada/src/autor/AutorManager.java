package autor;

import base.AbstractBaseManager;
import com.sd.uni.biblioteca.dto.autor.AutorDTO;
import com.sd.uni.biblioteca.dto.autor.AutorResult;

public class AutorManager extends AbstractBaseManager {
	public AutorManager() {
		super();
		
	}
	
	
	
	public void addAutor(String nombre) {
		
		AutorDTO autorDTO = new AutorDTO();
		autorDTO.setNombre(nombre);
		
		
		getJerseyClient().resource(getBaseUrl() + "/autor").entity(autorDTO).post(AutorDTO.class);
	}
	
	
	public void getAllAutors() {
		AutorResult autorResult = getJerseyClient().resource(getBaseUrl() + "/autor").get(AutorResult.class);
		for (AutorDTO p : autorResult.getAutors()) {
			System.out.println("Nombre: "+p.getNombre());
			
			
		}
	}
	
	public void getByIdAutor(int id){
		AutorDTO autorResult = getJerseyClient().resource(getBaseUrl() + "/autor/"+id).get(AutorDTO.class);
		System.out.println("Nombre: "+ autorResult.getNombre());
		
	}
	
	public void getByPropertyAutor(String textToFind){
		AutorResult patResult = getJerseyClient().resource(getBaseUrl() + "/autor/search/"+textToFind).get(AutorResult.class);
		for (AutorDTO c : patResult.getAutors()) {
			System.out.println("Nombre: "+c.getNombre());
			
			
		}
		
	}
	
}

