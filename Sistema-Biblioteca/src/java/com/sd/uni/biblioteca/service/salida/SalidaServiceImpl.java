package com.sd.uni.biblioteca.service.salida;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.biblioteca.beans.motivoSalida.MotivoSalidaB;
import com.sd.uni.biblioteca.beans.salida.SalidaB;
import com.sd.uni.biblioteca.beans.usuario.UsuarioB;
import com.sd.uni.biblioteca.dto.motivoSalida.MotivoSalidaDTO;
import com.sd.uni.biblioteca.dto.salida.SalidaDTO;
import com.sd.uni.biblioteca.dto.salida.SalidaResult;
import com.sd.uni.biblioteca.dto.usuario.UsuarioDTO;
import com.sd.uni.biblioteca.dto.usuario.UsuarioResult;
import com.sd.uni.biblioteca.rest.motivoSalida.IMotivoSalidaResource;
import com.sd.uni.biblioteca.rest.motivoSalida.MotivoSalidaResourceImpl;
import com.sd.uni.biblioteca.rest.salida.ISalidaResource;
import com.sd.uni.biblioteca.rest.salida.SalidaResourceImpl;
import com.sd.uni.biblioteca.rest.usuario.IUsuarioResource;
import com.sd.uni.biblioteca.rest.usuario.UsuarioResourceImpl;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;
import com.sd.uni.biblioteca.service.motivoSalida.IMotivoSalidaService;
import com.sd.uni.biblioteca.service.motivoSalida.MotivoSalidaServiceImpl;
import com.sd.uni.biblioteca.service.rol.IRolService;
import com.sd.uni.biblioteca.service.rol.RolServiceImpl;

@Service("SalidaService")
public class SalidaServiceImpl extends BaseServiceImpl<SalidaB, SalidaDTO> implements ISalidaService {

	@Autowired
	private  ISalidaResource _salidaResource= new SalidaResourceImpl();
	@Autowired
	private IMotivoSalidaService _motivoSalidaService= new MotivoSalidaServiceImpl();
	
	@Override
	public SalidaB save(SalidaB bean) {
		final SalidaDTO dto = convertBeanToDto(bean);
		final SalidaDTO salidaDTO = _salidaResource.save(dto);
		return convertDtoToBean(salidaDTO);
	}

	@Override
	public List<SalidaB> getAll() {
		final SalidaResult result = _salidaResource.getAll();
		final List<SalidaDTO> sList = null == result.getSalidas() ? new ArrayList<SalidaDTO>() : result.getSalidas();
		final List<SalidaB> salidas = new ArrayList<SalidaB>();

		for (SalidaDTO dto : sList) {
			final SalidaB salida = convertDtoToBean(dto);
			salidas.add(salida);
		}
		return salidas;
	}

	@Override
	public SalidaB getById(Integer id) {
		final SalidaDTO dto = _salidaResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected SalidaB convertDtoToBean(SalidaDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("descripcion", dto.getDescripcion());
		
		final SalidaB salida = new SalidaB(params);
		salida.setMotivoSalida(_motivoSalidaService.getById(dto.getMotivoSalidaId()));
		salida.setFecha(dto.getFecha());
		return salida;
	}

	@Override
	protected SalidaDTO convertBeanToDto(SalidaB bean) {
		final SalidaDTO dto = new SalidaDTO();
		dto.setId(bean.getId());
		dto.setMotivoSalidaId(bean.getMotivoSalida().getId());
		dto.setDescripcion(bean.getDescripcion());
		dto.setFecha(bean.getFecha());
		return dto;
	}


}
