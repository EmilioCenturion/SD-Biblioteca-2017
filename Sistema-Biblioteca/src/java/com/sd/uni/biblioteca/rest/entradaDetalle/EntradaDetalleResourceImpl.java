package com.sd.uni.biblioteca.rest.entradaDetalle;


//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.entradaDetalle.EntradaDetalleDTO;
import com.sd.uni.biblioteca.dto.entradaDetalle.EntradaDetalleResult;
import com.sd.uni.biblioteca.rest.base.BaseResourceImpl;

@Repository("entradaDetalleResource")
public class EntradaDetalleResourceImpl extends BaseResourceImpl<EntradaDetalleDTO> implements
		IEntradaDetalleResource {

	public EntradaDetalleResourceImpl() {
		super(EntradaDetalleDTO.class, "/entradaDetalle");
	}

	//@CacheEvict(value = CACHE_REGION, key = "'entradaDetalle_' + #entradaDetalle.id", condition = "#entradaDetalle.id!=null")
	@Override
	public EntradaDetalleDTO save(EntradaDetalleDTO entradaDetalle) {
		return super.save(entradaDetalle);
	}

	//@Cacheable(value = CACHE_REGION, key = "'entradaDetalle_' + #id")
	@Override
	public EntradaDetalleDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	public EntradaDetalleResult getAll() {
		EntradaDetalleResult entradaDetalles = getWebResource().get(EntradaDetalleResult.class);
		/*for (EntradaDetalleDTO entradaDetalle : entradaDetalles.getEntradaDetalles()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"state_" + entradaDetalle.getId(), entradaDetalle);
		}
		*/
		return entradaDetalles;
	}

}
