package libro;

import base.AbstractBaseManager;

import com.sd.uni.biblioteca.dto.libro.LibroDTO;
import com.sd.uni.biblioteca.dto.libro.LibroResult;
import com.sd.uni.biblioteca.dto.autor.AutorDTO;
import com.sd.uni.biblioteca.dto.autor.AutorResult;
import com.sd.uni.biblioteca.dto.categoria.CategoriaDTO;

public class LibroManager extends AbstractBaseManager {
	public LibroManager() {
		
		super();
		addAutores();
		addCategorias();
	}
	
	public void addAutores(){
		System.out.println("Autores!!");
		AutorDTO autorDTO1 = new AutorDTO();
		autorDTO1.setNombre("Cortazar");
		
		AutorDTO autorDTO2 = new AutorDTO();
		autorDTO2.setNombre("Roa Bastos");
		
		AutorDTO autorDTO3 = new AutorDTO();
		autorDTO3.setNombre("Coelho");
		
		getJerseyClient().resource(getBaseUrl() + "/autor").entity(autorDTO1).post(AutorDTO.class);
		getJerseyClient().resource(getBaseUrl() + "/autor").entity(autorDTO2).post(AutorDTO.class);
		getJerseyClient().resource(getBaseUrl() + "/autor").entity(autorDTO3).post(AutorDTO.class);
		
	}
	
public void addCategorias(){
	System.out.println("Categorias!!");
		CategoriaDTO categoriaDTO1 = new CategoriaDTO();
		categoriaDTO1.setDescripcion("cuentos");
		
		CategoriaDTO categoriaDTO2 = new CategoriaDTO();
		categoriaDTO2.setDescripcion("poesia");
		
		CategoriaDTO categoriaDTO3 = new CategoriaDTO();
		categoriaDTO3.setDescripcion("compilado");
		
		getJerseyClient().resource(getBaseUrl() + "/categoria").entity(categoriaDTO1).post(CategoriaDTO.class);
		getJerseyClient().resource(getBaseUrl() + "/categoria").entity(categoriaDTO2).post(CategoriaDTO.class);
		getJerseyClient().resource(getBaseUrl() + "/categoria").entity(categoriaDTO3).post(CategoriaDTO.class);
		
	}

	
	public void addLibro(String nombre, String anho, Integer autorId, Integer categoriaId, Integer cantidad) {
		
		LibroDTO libroDTO = new LibroDTO();
		libroDTO.setNombre(nombre);
		libroDTO.setCantidad(cantidad);
		libroDTO.setAnho(anho);
		libroDTO.setAutorId(autorId);
		libroDTO.setCategoriaId(categoriaId);
		getJerseyClient().resource(getBaseUrl() + "/libro").entity(libroDTO).post(LibroDTO.class);
	}
	
	
	public void getAllLibros() {
		LibroResult libroResult = getJerseyClient().resource(getBaseUrl() + "/libro").get(LibroResult.class);
		for (LibroDTO p : libroResult.getLibros()) {
			System.out.println("Nombre: "+p.getNombre());
			System.out.println("Año: "+p.getAnho());
			System.out.println("Autor: "+p.getAutorId());
			System.out.println("Categoria: "+p.getCategoriaId());
			
		}
	}
	
	public void getLibros(int max, int page) {
		LibroResult libroResult = getJerseyClient().resource(getBaseUrl() + "/libro/search/"+max+"/"+page).get(LibroResult.class);
		for (LibroDTO p : libroResult.getLibros()) {
			System.out.println("Nombre: "+p.getNombre());
			System.out.println("Año: "+p.getAnho());
			System.out.println("Autor: "+p.getAutorId());
			System.out.println("Categoria: "+p.getCategoriaId());
			
		}
	} 
	public void getByIdLibro(int id){
		LibroDTO libroResult = getJerseyClient().resource(getBaseUrl() + "/libro/"+id).get(LibroDTO.class);
		System.out.println("Nombre: "+ libroResult.getNombre());
		System.out.println("Anho: "+ libroResult.getAnho());
		System.out.println("Autor: "+ libroResult.getAutorId());
		System.out.println("Categoria: "+ libroResult.getCategoriaId());
		
	}
	
	public void getByPropertyLibro(String textToFind){
		LibroResult patResult = getJerseyClient().resource(getBaseUrl() + "/libro/search/"+textToFind).get(LibroResult.class);
		for (LibroDTO c : patResult.getLibros()) {
			System.out.println("Nombre: "+c.getNombre());
			System.out.println("Anho: "+c.getAnho());
			System.out.println("Autor: "+c.getAutorId());
			System.out.println("Categoria: "+c.getCategoriaId());
			
		}
		
	}
	
}


