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
	@CacheEvict(value = CACHE_REGION, key = "'libros'")
	@CachePut(value = CACHE_REGION, key = "'libro_' + #libro.id", condition = "#libro.id!=null")
	public LibroDTO save(LibroDTO dto) {
		final LibroDTO libro = getWebResource().entity(dto).post(getDtoClass());
		return libro;
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'libro_' + #id")
	public LibroDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	
	public LibroResult getAll() {
		LibroResult libros = getWebResource().get(LibroResult.class);
		/*for (LibroDTO libro : libros.getLibros()) {
			getCacheManager().getCache(CACHE_REGION).put("libro_" + libro.getId(), libro);
		}*/
		return libros;
	}
}
