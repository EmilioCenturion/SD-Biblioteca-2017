package com.sd.uni.biblioteca.rest.categoria;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.categoria.CategoriaDTO;
import com.sd.uni.biblioteca.dto.categoria.CategoriaResult;
import com.sd.uni.biblioteca.dto.libro.LibroResult;
import com.sd.uni.biblioteca.rest.base.BaseResourceImpl;

@Repository("categoriaResource")
public class CategoriaResourceImpl extends BaseResourceImpl<CategoriaDTO> implements
		ICategoriaResource {

	public CategoriaResourceImpl() {
		super(CategoriaDTO.class, "/categoria");
	}

	@Override
	@CacheEvict(value = CACHE_REGION, key = "'categoria_' + #dto.id", condition = "#dto.id!=null")
	public CategoriaDTO save(CategoriaDTO dto) {
		setWebResourceBasicAuthFilter();
		final CategoriaDTO categoria = getWebResource().entity(dto).post(getDtoClass());
		return categoria;
	}

	@Cacheable(value = CACHE_REGION, key = "'categoria_' + #id")
	@Override
	public CategoriaDTO getById(Integer id) {
		setWebResourceBasicAuthFilter();
		return super.getById(id);
	}

	@Override
	public CategoriaResult getAll() {
		setWebResourceBasicAuthFilter();
		CategoriaResult categorias = getWebResource().get(CategoriaResult.class);
		for (CategoriaDTO categoria : categorias.getCategorias()) {
			getCacheManager().getCache(CACHE_REGION).put("categoria_" + categoria.getId(), categoria);
		}
		return categorias;
	}
	
	@Override
	public CategoriaResult find(int maxItems, int page){
		setWebResourceBasicAuthFilter();
		CategoriaResult categorias = search(maxItems,page).get(CategoriaResult.class);
		return categorias;
	}
	
	@Override
	public CategoriaResult find(String textToFind, int maxItems, int page){
		setWebResourceBasicAuthFilter();
		CategoriaResult categorias = search(textToFind, maxItems,page).get(CategoriaResult.class);
		
		return categorias;
	}
	
	
}
