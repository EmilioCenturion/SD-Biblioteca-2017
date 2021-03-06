package com.sd.uni.biblioteca.rest.rol;


//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.rol.RolDTO;
import com.sd.uni.biblioteca.dto.rol.RolResult;
import com.sd.uni.biblioteca.rest.base.BaseResourceImpl;

@Repository("rolResource")
public class RolResourceImpl extends BaseResourceImpl<RolDTO> implements
		IRolResource {

	public RolResourceImpl() {
		super(RolDTO.class, "/rol");
	}

	@Override
	//@CacheEvict(value = CACHE_REGION, key = "'rol_' + #dto.id", condition = "#dto.id!=null")
	public RolDTO save(RolDTO dto) {
		setWebResourceBasicAuthFilter();
		final RolDTO rol = getWebResource().entity(dto).post(getDtoClass());
		return rol;
	}

	//@Cacheable(value = CACHE_REGION, key = "'rol_' + #id")
	@Override
	public RolDTO getById(Integer id) {
		setWebResourceBasicAuthFilter();
		return super.getById(id);
	}

	@Override
	public RolResult getAll() {
		setWebResourceBasicAuthFilter();
		RolResult rols = getWebResource().get(RolResult.class);
		/*for (RolDTO rol : rols.getRols()) {
			getCacheManager().getCache(CACHE_REGION).put("rol_" + rol.getId(), rol);
		}*/
		return rols;
	}
}
