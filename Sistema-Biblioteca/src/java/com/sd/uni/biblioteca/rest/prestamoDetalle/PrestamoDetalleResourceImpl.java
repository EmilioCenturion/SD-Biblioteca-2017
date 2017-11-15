package com.sd.uni.biblioteca.rest.prestamoDetalle;

import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.prestamo_detalle.PrestamoDetalleDTO;
import com.sd.uni.biblioteca.dto.prestamo_detalle.PrestamoDetalleResult;
import com.sd.uni.biblioteca.rest.base.BaseResourceImpl;

@Repository("prestamoResource")
public class PrestamoDetalleResourceImpl extends BaseResourceImpl<PrestamoDetalleDTO> implements
		IPrestamoDetalleResource {

	public PrestamoDetalleResourceImpl() {
		super(PrestamoDetalleDTO.class, "/prestamoDetalle");
	}

	//@CacheEvict(value = CACHE_REGION, key = "'state_' + #state.id", condition = "#state.id!=null")
	@Override
	public PrestamoDetalleDTO save(PrestamoDetalleDTO prestamoDetalle) {
		return super.save(prestamoDetalle);
	}

	//@Cacheable(value = CACHE_REGION, key = "'state_' + #id")
	@Override
	public PrestamoDetalleDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	public PrestamoDetalleResult getAll() {
		PrestamoDetalleResult prestamoDetalles = getWebResource().get(PrestamoDetalleResult.class);
		return prestamoDetalles;
	}

}
