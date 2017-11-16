package com.sd.uni.biblioteca.rest.salida;

import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.salida.SalidaDTO;
import com.sd.uni.biblioteca.dto.salida.SalidaResult;
import com.sd.uni.biblioteca.rest.base.BaseResourceImpl;

@Repository("salidaResource")
public class SalidaResourceImpl extends BaseResourceImpl<SalidaDTO> implements ISalidaResource{

	public SalidaResourceImpl() {
		super(SalidaDTO.class, "/salida");
	}

	@Override
	//@CacheEvict(value = CACHE_REGION, key = "'salida_' + #dto.id", condition = "#dto.id!=null")
	public SalidaDTO save(SalidaDTO dto) {
		final SalidaDTO salida = getWebResource().entity(dto).post(getDtoClass());
		return salida;
	}

	//@Cacheable(value = CACHE_REGION, key = "'country_' + #id")
	@Override
	public SalidaDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	public SalidaResult getAll() {
		SalidaResult salidas = getWebResource().get(SalidaResult.class);
		return salidas;
	}

}
