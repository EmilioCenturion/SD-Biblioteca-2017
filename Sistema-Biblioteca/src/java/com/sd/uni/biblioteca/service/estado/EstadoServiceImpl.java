package com.sd.uni.biblioteca.service.estado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.biblioteca.beans.estado.EstadoB;
import com.sd.uni.biblioteca.rest.estado.IEstadoResource;
import com.sd.uni.biblioteca.rest.estado.EstadoResourceImpl;
import com.sd.uni.biblioteca.dto.estado.EstadoDTO;
import com.sd.uni.biblioteca.dto.estado.EstadoResult;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service("estadoService")
public class EstadoServiceImpl extends BaseServiceImpl<EstadoB, EstadoDTO> implements IEstadoService {
	@Autowired
	private  IEstadoResource _estadoResource= new EstadoResourceImpl();
	//@Autowired
	//private IRolService _rolService=new RolServiceImpl();
	

	public EstadoServiceImpl() {
	}

	@Override
	public EstadoB save(EstadoB bean) {
		final EstadoDTO dto = convertBeanToDto(bean);
		final EstadoDTO estadoDTO = _estadoResource.save(dto);
		return convertDtoToBean(estadoDTO);
	}

	@Override
	public List<EstadoB> getAll() {
		final EstadoResult result = _estadoResource.getAll();
		final List<EstadoDTO> uList = null == result.getEstados() ? new ArrayList<EstadoDTO>() : result.getEstados();
		final List<EstadoB> estados = new ArrayList<EstadoB>();

		for (EstadoDTO dto : uList) {
			final EstadoB estado = convertDtoToBean(dto);
			estados.add(estado);
		}
		return estados;
	}

	@Override
	public EstadoB getById(Integer id) {
		final EstadoDTO dto = _estadoResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected EstadoB convertDtoToBean(EstadoDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("descripcion", dto.getDescripcion());
		final EstadoB estado = new EstadoB(params);
		//usuario.setRol(_rolService.getById(dto.getRolId()));
		return estado;
	}

	@Override
	protected EstadoDTO convertBeanToDto(EstadoB bean) {
		final EstadoDTO dto = new EstadoDTO();
		dto.setId(bean.getId());
		dto.setDescripcion(bean.getDescripcion());
		return dto;
	}

}
