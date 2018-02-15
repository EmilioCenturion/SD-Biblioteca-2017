package categoria;

import base.AbstractBaseManager;
import com.sd.uni.biblioteca.dto.categoria.CategoriaDTO;
import com.sd.uni.biblioteca.dto.categoria.CategoriaResult;

public class CategoriaManager extends AbstractBaseManager {
	public CategoriaManager() {
		super();
		
	}
	
	
	
	public void addCategoria(String descripcion) {
		
		CategoriaDTO categoriaDTO = new CategoriaDTO();
		categoriaDTO.setDescripcion(descripcion);
		
		
		getJerseyClient().resource(getBaseUrl() + "/categoria").entity(categoriaDTO).post(CategoriaDTO.class);
	}
	
	
	public void getAllCategorias() {
		CategoriaResult categoriaResult = getJerseyClient().resource(getBaseUrl() + "/categoria/all").get(CategoriaResult.class);
		for (CategoriaDTO p : categoriaResult.getCategorias()) {
			System.out.println("Descripcion: "+p.getDescripcion());
			
			
		}
	}
	
	public void getByIdCategoria(int id){
		CategoriaDTO categoriaResult = getJerseyClient().resource(getBaseUrl() + "/categoria/"+id).get(CategoriaDTO.class);
		System.out.println("Descripcion: "+ categoriaResult.getDescripcion());
		
	}
	
	public void getByPropertyCategoria(String textToFind){
		CategoriaResult patResult = getJerseyClient().resource(getBaseUrl() + "/categoria/search/"+textToFind).get(CategoriaResult.class);
		for (CategoriaDTO c : patResult.getCategorias()) {
			System.out.println("Descripcion: "+c.getDescripcion());
			
			
		}
		
	}
	
}
