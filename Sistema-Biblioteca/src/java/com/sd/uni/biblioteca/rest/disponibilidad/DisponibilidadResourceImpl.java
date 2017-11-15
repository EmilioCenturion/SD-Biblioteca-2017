package com.sd.uni.biblioteca.rest.disponibilidad;

import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.disponibilidad.DisponibilidadDTO;
import com.sd.uni.biblioteca.dto.disponibilidad.DisponibilidadResult;
import com.sd.uni.biblioteca.rest.base.BaseResourceImpl;

@Repository("disponibilidadLibroResource")
public class DisponibilidadResourceImpl extends BaseResourceImpl<DisponibilidadDTO> implements
		IDisponibilidadResource {

	public DisponibilidadResourceImpl() {
		super(DisponibilidadDTO.class, "/disponibilidadLibro");
	}

	//@CacheEvict(value = CACHE_REGION, key = "'state_' + #state.id", condition = "#state.id!=null")
	@Override
	public DisponibilidadDTO save(DisponibilidadDTO disponibilidadLibro) {
		return super.save(disponibilidadLibro);
	}

	//@Cacheable(value = CACHE_REGION, key = "'state_' + #id")
	@Override
	public DisponibilidadDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	public DisponibilidadResult getAll() {
		DisponibilidadResult disponibilidad_libros = getWebResource().get(DisponibilidadResult.class);
		
		return disponibilidad_libros;
	}

}