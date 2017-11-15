package com.sd.uni.biblioteca.rest.estadoGeneral;

import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.estado_general.EstadoGeneralDTO;
import com.sd.uni.biblioteca.dto.estado_general.EstadoGeneralResult;
import com.sd.uni.biblioteca.rest.base.BaseResourceImpl;

@Repository("estadoGeneralResource")
public class EstadoGeneralResourceImpl extends BaseResourceImpl<EstadoGeneralDTO> implements
		IEstadoGeneralResource {

	public EstadoGeneralResourceImpl() {
		super(EstadoGeneralDTO.class, "/estadoGeneral");
	}

	//@CacheEvict(value = CACHE_REGION, key = "'state_' + #state.id", condition = "#state.id!=null")
	@Override
	public EstadoGeneralDTO save(EstadoGeneralDTO estadoGeneral) {
		return super.save(estadoGeneral);
	}

	//@Cacheable(value = CACHE_REGION, key = "'state_' + #id")
	@Override
	public EstadoGeneralDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	public EstadoGeneralResult getAll() {
		EstadoGeneralResult estadosGeneral = getWebResource().get(EstadoGeneralResult.class);
		return estadosGeneral;
	}

}

