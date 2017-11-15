package com.sd.uni.biblioteca.rest.entrada;


//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.entrada.EntradaDTO;
import com.sd.uni.biblioteca.dto.entrada.EntradaResult;
import com.sd.uni.biblioteca.rest.base.BaseResourceImpl;

@Repository("entradaResource")
public class EntradaResourceImpl extends BaseResourceImpl<EntradaDTO> implements
		IEntradaResource {

	public EntradaResourceImpl() {
		super(EntradaDTO.class, "/entrada");
	}

	//@CacheEvict(value = CACHE_REGION, key = "'entrada_' + #entrada.id", condition = "#entrada.id!=null")
	@Override
	public EntradaDTO save(EntradaDTO entrada) {
		return super.save(entrada);
	}

	//@Cacheable(value = CACHE_REGION, key = "'entrada_' + #id")
	@Override
	public EntradaDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	public EntradaResult getAll() {
		EntradaResult entradas = getWebResource().get(EntradaResult.class);
		/*for (EntradaDTO entrada : entradas.getEntradas()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"state_" + entrada.getId(), entrada);
		}
		*/
		return entradas;
	}

}
