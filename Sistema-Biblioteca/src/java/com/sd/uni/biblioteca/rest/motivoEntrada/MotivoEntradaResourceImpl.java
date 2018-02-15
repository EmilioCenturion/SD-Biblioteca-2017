package com.sd.uni.biblioteca.rest.motivoEntrada;


//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.motivoEntrada.MotivoEntradaDTO;
import com.sd.uni.biblioteca.dto.motivoEntrada.MotivoEntradaResult;
import com.sd.uni.biblioteca.rest.base.BaseResourceImpl;

@Repository("motivoEntradaResource")
public class MotivoEntradaResourceImpl extends BaseResourceImpl<MotivoEntradaDTO> implements
		IMotivoEntradaResource {

	public MotivoEntradaResourceImpl() {
		super(MotivoEntradaDTO.class, "/motivoEntrada");
	}

	@Override
	//@CacheEvict(value = CACHE_REGION, key = "'motivoEntrada_' + #dto.id", condition = "#dto.id!=null")
	public MotivoEntradaDTO save(MotivoEntradaDTO dto) {
		setWebResourceBasicAuthFilter();
		final MotivoEntradaDTO motivoEntrada = getWebResource().entity(dto).post(getDtoClass());
		return motivoEntrada;
	}

	//@Cacheable(value = CACHE_REGION, key = "'motivoEntrada_' + #id")
	@Override
	public MotivoEntradaDTO getById(Integer id) {
		setWebResourceBasicAuthFilter();
		return super.getById(id);
	}

	@Override
	public MotivoEntradaResult getAll() {
		setWebResourceBasicAuthFilter();
		MotivoEntradaResult motivoEntradas = getWebResource().get(MotivoEntradaResult.class);
		/*for (MotivoEntradaDTO motivoEntrada : motivoEntradas.getMotivoEntradas()) {
			getCacheManager().getCache(CACHE_REGION).put("motivoEntrada_" + motivoEntrada.getId(), motivoEntrada);
		}*/
		return motivoEntradas;
	}
}
