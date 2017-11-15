package com.sd.uni.biblioteca.rest.estado;

import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.estado.EstadoDTO;
import com.sd.uni.biblioteca.dto.estado.EstadoResult;
import com.sd.uni.biblioteca.rest.base.BaseResourceImpl;

@Repository("estadoResource")
public class EstadoResourceImpl extends BaseResourceImpl<EstadoDTO> implements
		IEstadoResource {

	public EstadoResourceImpl() {
		super(EstadoDTO.class, "/estado");
	}

	//@CacheEvict(value = CACHE_REGION, key = "'state_' + #state.id", condition = "#state.id!=null")
	@Override
	public EstadoDTO save(EstadoDTO estado) {
		return super.save(estado);
	}

	//@Cacheable(value = CACHE_REGION, key = "'state_' + #id")
	@Override
	public EstadoDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	public EstadoResult getAll() {
		EstadoResult estados = getWebResource().get(EstadoResult.class);
		return estados;
	}

}
