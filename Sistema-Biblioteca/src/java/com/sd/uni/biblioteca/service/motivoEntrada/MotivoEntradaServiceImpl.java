package com.sd.uni.biblioteca.service.motivoEntrada;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.biblioteca.beans.motivoEntrada.MotivoEntradaB;
import com.sd.uni.biblioteca.rest.motivoEntrada.IMotivoEntradaResource;
import com.sd.uni.biblioteca.rest.motivoEntrada.MotivoEntradaResourceImpl;
import com.sd.uni.biblioteca.dto.motivoEntrada.MotivoEntradaDTO;
import com.sd.uni.biblioteca.dto.motivoEntrada.MotivoEntradaResult;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service("motivoEntradaService")
public class MotivoEntradaServiceImpl extends BaseServiceImpl<MotivoEntradaB, MotivoEntradaDTO>
		implements IMotivoEntradaService {
	@Autowired
	private IMotivoEntradaResource _motivoEntradaResource=new MotivoEntradaResourceImpl();
	
	@Override
	public MotivoEntradaB save(MotivoEntradaB bean) {
		final MotivoEntradaDTO dto = convertBeanToDto(bean);
		final MotivoEntradaDTO motivoEntradaDTO = _motivoEntradaResource.save(dto);
		return convertDtoToBean(motivoEntradaDTO);
	}

	@Override
	public List<MotivoEntradaB> getAll() {
		final MotivoEntradaResult result = _motivoEntradaResource.getAll();
		final List<MotivoEntradaDTO> rList = null == result.getMotivoEntradas() ? new ArrayList<MotivoEntradaDTO>()
				: result.getMotivoEntradas();
		final List<MotivoEntradaB> motivoEntradas = new ArrayList<MotivoEntradaB>();

		for (MotivoEntradaDTO dto : rList) {
			final MotivoEntradaB motivoEntradaB = convertDtoToBean(dto);
			motivoEntradas.add(motivoEntradaB);
		}
		return motivoEntradas;
	}

	@Override
	public MotivoEntradaB getById(Integer id) {
		final MotivoEntradaDTO dto = _motivoEntradaResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected MotivoEntradaB convertDtoToBean(MotivoEntradaDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("descripcion", dto.getDescripcion());
		final MotivoEntradaB motivoEntradaB = new MotivoEntradaB(params);
		return motivoEntradaB;
	}

	@Override
	protected MotivoEntradaDTO convertBeanToDto(MotivoEntradaB bean) {
		final MotivoEntradaDTO dto = new MotivoEntradaDTO();
		dto.setId(bean.getId());
		dto.setDescripcion(bean.getDescripcion());
		return dto;
	}

}
