package com.sd.uni.biblioteca.rest.autor;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.autor.AutorDTO;
import com.sd.uni.biblioteca.dto.autor.AutorResult;
import com.sd.uni.biblioteca.dto.libro.LibroResult;
import com.sd.uni.biblioteca.rest.base.BaseResourceImpl;

@Repository("autorResource")
public class AutorResourceImpl extends BaseResourceImpl<AutorDTO> implements
		IAutorResource {

	public AutorResourceImpl() {
		super(AutorDTO.class, "/autor");
	}

	@Override
	@CacheEvict(value = CACHE_REGION, key = "'autor_' + #dto.id", condition = "#dto.id!=null")
	public AutorDTO save(AutorDTO dto) {
		setWebResourceBasicAuthFilter();
		final AutorDTO autor = getWebResource().entity(dto).post(getDtoClass());
		return autor;
	}

	@Cacheable(value = CACHE_REGION, key = "'autor_' + #id")
	@Override
	public AutorDTO getById(Integer id) {
		setWebResourceBasicAuthFilter();
		return super.getById(id);
	}

	@Override
	public AutorResult getAll() {
		setWebResourceBasicAuthFilter();
		AutorResult autors = getWebResource().get(AutorResult.class);
		for (AutorDTO autor : autors.getAutors()) {
			getCacheManager().getCache(CACHE_REGION).put("autor_" + autor.getId(), autor);
		}
		return autors;
	}
	
	@Override
	public AutorResult find(int maxItems, int page){
		setWebResourceBasicAuthFilter();
		AutorResult autores = search(maxItems,page).get(AutorResult.class);
		
		return autores;
	}
	
	@Override
	public AutorResult find(String textToFind, int maxItems, int page){
		setWebResourceBasicAuthFilter();
		AutorResult autores = search(textToFind, maxItems,page).get(AutorResult.class);
		
		return autores;
	}
}
