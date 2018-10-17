package com.sd.uni.biblioteca.rest.libro;


//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.libro.LibroDTO;
import com.sd.uni.biblioteca.dto.libro.LibroResult;
import com.sd.uni.biblioteca.rest.base.BaseResourceImpl;

@Repository("libroResource")
public class LibroResourceImpl extends BaseResourceImpl<LibroDTO> implements
		ILibroResource {

	public LibroResourceImpl() {
		super(LibroDTO.class, "/libro");
	}

	@Override
	//@CacheEvict(value = CACHE_REGION, key = "'libros'")
	//@CachePut(value = CACHE_REGION, key = "'libro_' + #libro.id", condition = "#libro.id!=null")
	public LibroDTO save(LibroDTO dto) {
		setWebResourceBasicAuthFilter();
		final LibroDTO libro = getWebResource().entity(dto).post(getDtoClass());
		return libro;
	}

	@Override
	//@Cacheable(value = CACHE_REGION, key = "'libro_' + #id")
	public LibroDTO getById(Integer id) {
		setWebResourceBasicAuthFilter();
		return super.getById(id);
	}

	@Override
	
	public LibroResult getAll() {
		setWebResourceBasicAuthFilter();
		LibroResult libros = getWebResource().get(LibroResult.class);
		/*for (LibroDTO libro : libros.getLibros()) {
			getCacheManager().getCache(CACHE_REGION).put("libro_" + libro.getId(), libro);
		}*/
		return libros;
	}
	
	@Override
	public LibroResult find(int maxItems, int page){
		setWebResourceBasicAuthFilter();
		LibroResult libros = search(maxItems,page).get(LibroResult.class);
		
		return libros;
	}
	
	@Override
	public LibroResult find(String textToFind, int maxItems, int page){
		setWebResourceBasicAuthFilter();
		LibroResult libros = search(textToFind, maxItems,page).get(LibroResult.class);
		
		return libros;
	}
}
