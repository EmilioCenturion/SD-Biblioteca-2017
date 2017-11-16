package com.sd.uni.biblioteca.rest.motivoSalida;

import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.motivoEntrada.MotivoEntradaDTO;
import com.sd.uni.biblioteca.dto.motivoSalida.MotivoSalidaDTO;
import com.sd.uni.biblioteca.dto.motivoSalida.MotivoSalidaResult;
import com.sd.uni.biblioteca.rest.base.BaseResourceImpl;

@Repository("motivoSalidaResource")
public class MotivoSalidaResourceImpl extends BaseResourceImpl<MotivoSalidaDTO> implements IMotivoSalidaResource{

	public MotivoSalidaResourceImpl() {
		super(MotivoSalidaDTO.class, "/motivoSalida");
	}

	
	@Override
	//@CacheEvict(value = CACHE_REGION, key = "'rol_' + #dto.id", condition = "#dto.id!=null")
	public MotivoSalidaDTO save(MotivoSalidaDTO dto) {
		final MotivoSalidaDTO motivoSalida = getWebResource().entity(dto).post(getDtoClass());
		return motivoSalida;
	}

	//@Cacheable(value = CACHE_REGION, key = "'country_' + #id")
	@Override
	public MotivoSalidaDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	public MotivoSalidaResult getAll() {
		MotivoSalidaResult motivos = getWebResource().get(MotivoSalidaResult.class);
		return motivos;
	}

}
