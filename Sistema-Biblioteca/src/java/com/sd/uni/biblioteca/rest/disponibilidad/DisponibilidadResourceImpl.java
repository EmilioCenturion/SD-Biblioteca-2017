package com.sd.uni.biblioteca.rest.disponibilidad;

import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.disponibilidad.DisponibilidadDTO;
import com.sd.uni.biblioteca.dto.disponibilidad.DisponibilidadResult;
import com.sd.uni.biblioteca.rest.base.BaseResourceImpl;

@Repository("disponibilidadResource")
public class DisponibilidadResourceImpl extends BaseResourceImpl<DisponibilidadDTO> implements
IDisponibilidadResource {

	public DisponibilidadResourceImpl() {
		super(DisponibilidadDTO.class, "/disponibilidad");
	}
	
	@Override
	public DisponibilidadDTO save(DisponibilidadDTO disponibilidad) {
		return super.save(disponibilidad);
	}

	@Override
	public DisponibilidadDTO getById(Integer id) {
		return super.getById(id);
	}
	
	@Override
	public DisponibilidadResult getAll() {
		DisponibilidadResult disponibilidades = getWebResource().get(DisponibilidadResult.class);
		/*for (UsuarioDTO usuario : usuarios.getUsuarios()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"state_" + usuario.getId(), usuario);
		}
		*/
		return disponibilidades;
	}
	
}
