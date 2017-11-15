package com.sd.uni.biblioteca.rest.prestamo;

import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.prestamo.PrestamoDTO;
import com.sd.uni.biblioteca.dto.prestamo.PrestamoResult;
import com.sd.uni.biblioteca.rest.base.BaseResourceImpl;

@Repository("prestamoResource")
public class PrestamoResourceImpl extends BaseResourceImpl<PrestamoDTO> implements
		IPrestamoResource {

	public PrestamoResourceImpl() {
		super(PrestamoDTO.class, "/prestamo");
	}

	//@CacheEvict(value = CACHE_REGION, key = "'state_' + #state.id", condition = "#state.id!=null")
	@Override
	public PrestamoDTO save(PrestamoDTO prestamo) {
		return super.save(prestamo);
	}

	//@Cacheable(value = CACHE_REGION, key = "'state_' + #id")
	@Override
	public PrestamoDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	public PrestamoResult getAll() {
		PrestamoResult prestamos = getWebResource().get(PrestamoResult.class);
		
		return prestamos;
	}

}
