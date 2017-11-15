package com.sd.uni.biblioteca.service.entrada;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.biblioteca.beans.entrada.EntradaB;
import com.sd.uni.biblioteca.rest.entrada.IEntradaResource;
import com.sd.uni.biblioteca.rest.entrada.EntradaResourceImpl;
import com.sd.uni.biblioteca.dto.entrada.EntradaDTO;
import com.sd.uni.biblioteca.dto.entrada.EntradaResult;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;
import com.sd.uni.biblioteca.service.motivoEntrada.IMotivoEntradaService;
import com.sd.uni.biblioteca.service.motivoEntrada.MotivoEntradaServiceImpl;
@Service("entradaService")
public class EntradaServiceImpl extends BaseServiceImpl<EntradaB, EntradaDTO> implements IEntradaService {
	@Autowired
	private  IEntradaResource _entradaResource= new EntradaResourceImpl();
	@Autowired
	private IMotivoEntradaService _motivoEntradaService=new MotivoEntradaServiceImpl();

	public EntradaServiceImpl() {
	}

	@Override
	public EntradaB save(EntradaB bean) {
		final EntradaDTO dto = convertBeanToDto(bean);
		final EntradaDTO entradaDTO = _entradaResource.save(dto);
		return convertDtoToBean(entradaDTO);
	}

	@Override
	public List<EntradaB> getAll() {
		final EntradaResult result = _entradaResource.getAll();
		final List<EntradaDTO> uList = null == result.getEntradas() ? new ArrayList<EntradaDTO>() : result.getEntradas();
		final List<EntradaB> entradas = new ArrayList<EntradaB>();

		for (EntradaDTO dto : uList) {
			final EntradaB entrada = convertDtoToBean(dto);
			entradas.add(entrada);
		}
		return entradas;
	}

	@Override
	public EntradaB getById(Integer id) {
		final EntradaDTO dto = _entradaResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected EntradaB convertDtoToBean(EntradaDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("descripcion", dto.getDescripcion());
		final EntradaB entrada = new EntradaB(params);
		entrada.setMotivoEntrada(_motivoEntradaService.getById(dto.getMotivoEntradaId()));
		entrada.setFecha(dto.getFecha());
		return entrada;
	}

	@Override
	protected EntradaDTO convertBeanToDto(EntradaB bean) {
		final EntradaDTO dto = new EntradaDTO();
		dto.setId(bean.getId());
		dto.setMotivoEntradaId(bean.getMotivoEntrada().getId());
		dto.setDescripcion(bean.getDescripcion());
		dto.setFecha(bean.getFecha());
		return dto;
	}

}
