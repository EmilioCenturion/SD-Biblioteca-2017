package com.sd.uni.biblioteca.service.motivoSalida;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.biblioteca.beans.motivoSalida.MotivoSalidaB;
import com.sd.uni.biblioteca.beans.rol.RolB;
import com.sd.uni.biblioteca.dto.motivoSalida.MotivoSalidaDTO;
import com.sd.uni.biblioteca.dto.motivoSalida.MotivoSalidaResult;
import com.sd.uni.biblioteca.dto.rol.RolDTO;
import com.sd.uni.biblioteca.dto.rol.RolResult;
import com.sd.uni.biblioteca.rest.motivoSalida.IMotivoSalidaResource;
import com.sd.uni.biblioteca.rest.motivoSalida.MotivoSalidaResourceImpl;
import com.sd.uni.biblioteca.rest.rol.IRolResource;
import com.sd.uni.biblioteca.rest.rol.RolResourceImpl;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service("motivoSalidaService")
public class MotivoSalidaServiceImpl extends BaseServiceImpl<MotivoSalidaB, MotivoSalidaDTO> implements IMotivoSalidaService {

	@Autowired
	private IMotivoSalidaResource _motivoSalidaResource=new MotivoSalidaResourceImpl();
	
	@Override
	public MotivoSalidaB save(MotivoSalidaB bean) {
		final MotivoSalidaDTO dto = convertBeanToDto(bean);
		final MotivoSalidaDTO motivoDTO = _motivoSalidaResource.save(dto);
		return convertDtoToBean(motivoDTO);
	}
	
	@Override
	public List<MotivoSalidaB> getAll() {
		final MotivoSalidaResult result = _motivoSalidaResource.getAll();
		final List<MotivoSalidaDTO> rList = null == result.getMotivos() ? new ArrayList<MotivoSalidaDTO>()
				: result.getMotivos();
		final List<MotivoSalidaB> motivos = new ArrayList<MotivoSalidaB>();

		for (MotivoSalidaDTO dto : rList) {
			final MotivoSalidaB motivoB = convertDtoToBean(dto);
			motivos.add(motivoB);
		}
		return motivos;
	}

	@Override
	public MotivoSalidaB getById(Integer id) {
		final MotivoSalidaDTO dto = _motivoSalidaResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected MotivoSalidaB convertDtoToBean(MotivoSalidaDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("descripcion", dto.getDescripcion());
		final MotivoSalidaB motivoB = new MotivoSalidaB(params);
		return motivoB;
	}

	@Override
	protected MotivoSalidaDTO convertBeanToDto(MotivoSalidaB bean) {
		final MotivoSalidaDTO dto = new MotivoSalidaDTO();
		dto.setId(bean.getId());
		dto.setDescripcion(bean.getDescripcion());
		return dto;
	}

}
