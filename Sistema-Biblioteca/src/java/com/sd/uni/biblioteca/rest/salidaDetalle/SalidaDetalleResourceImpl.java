package com.sd.uni.biblioteca.rest.salidaDetalle;


//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.salidaDetalle.SalidaDetalleDTO;
import com.sd.uni.biblioteca.dto.salidaDetalle.SalidaDetalleResult;
import com.sd.uni.biblioteca.rest.base.BaseResourceImpl;

@Repository("salidaDetalleResource")
public class SalidaDetalleResourceImpl extends BaseResourceImpl<SalidaDetalleDTO> implements
		ISalidaDetalleResource {

	public SalidaDetalleResourceImpl() {
		super(SalidaDetalleDTO.class, "/salidaDetalle");
	}

	//@CacheEvict(value = CACHE_REGION, key = "'salidaDetalle_' + #salidaDetalle.id", condition = "#salidaDetalle.id!=null")
	@Override
	public SalidaDetalleDTO save(SalidaDetalleDTO salidaDetalle) {
		setWebResourceBasicAuthFilter();
		return super.save(salidaDetalle);
	}

	//@Cacheable(value = CACHE_REGION, key = "'salidaDetalle_' + #id")
	@Override
	public SalidaDetalleDTO getById(Integer id) {
		setWebResourceBasicAuthFilter();
		return super.getById(id);
	}

	@Override
	public SalidaDetalleResult getAll() {
		setWebResourceBasicAuthFilter();
		SalidaDetalleResult salidaDetalles = getWebResource().get(SalidaDetalleResult.class);
		/*for (SalidaDetalleDTO salidaDetalle : salidaDetalles.getSalidaDetalles()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"state_" + salidaDetalle.getId(), salidaDetalle);
		}
		*/
		return salidaDetalles;
	}

}
