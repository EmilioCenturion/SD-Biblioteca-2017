package com.sd.uni.biblioteca.service.estadoGeneral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.biblioteca.beans.estadoGeneral.EstadoGeneralB;
import com.sd.uni.biblioteca.rest.estadoGeneral.IEstadoGeneralResource;
import com.sd.uni.biblioteca.rest.estadoGeneral.EstadoGeneralResourceImpl;
import com.sd.uni.biblioteca.dto.estado_general.EstadoGeneralDTO;
import com.sd.uni.biblioteca.dto.estado_general.EstadoGeneralResult;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service("estadoGeneralService")
public class EstadoGeneralServiceImpl extends BaseServiceImpl<EstadoGeneralB, EstadoGeneralDTO> implements IEstadoGeneralService {
	@Autowired
	private  IEstadoGeneralResource _estadoGeneralResource= new EstadoGeneralResourceImpl();
	//@Autowired
	//private IRolService _rolService=new RolServiceImpl();
	

	public EstadoGeneralServiceImpl() {
	}

	@Override
	public EstadoGeneralB save(EstadoGeneralB bean) {
		final EstadoGeneralDTO dto = convertBeanToDto(bean);
		final EstadoGeneralDTO estadoGeneralDTO = _estadoGeneralResource.save(dto);
		return convertDtoToBean(estadoGeneralDTO);
	}

	@Override
	public List<EstadoGeneralB> getAll() {
		final EstadoGeneralResult result = _estadoGeneralResource.getAll();
		final List<EstadoGeneralDTO> uList = null == result.getEstadoGenerales() ? new ArrayList<EstadoGeneralDTO>() : result.getEstadoGenerales();
		final List<EstadoGeneralB> estadosGeneral = new ArrayList<EstadoGeneralB>();

		for (EstadoGeneralDTO dto : uList) {
			final EstadoGeneralB estadoGeneral = convertDtoToBean(dto);
			estadosGeneral.add(estadoGeneral);
		}
		return estadosGeneral;
	}

	@Override
	public EstadoGeneralB getById(Integer id) {
		final EstadoGeneralDTO dto = _estadoGeneralResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected EstadoGeneralB convertDtoToBean(EstadoGeneralDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("descripcion", dto.getDescripcion());
		final EstadoGeneralB estadoGeneral = new EstadoGeneralB(params);
		//usuario.setRol(_rolService.getById(dto.getRolId()));
		return estadoGeneral;
	}

	@Override
	protected EstadoGeneralDTO convertBeanToDto(EstadoGeneralB bean) {
		final EstadoGeneralDTO dto = new EstadoGeneralDTO();
		dto.setId(bean.getId());
		dto.setDescripcion(bean.getDescripcion());
		return dto;
	}

}