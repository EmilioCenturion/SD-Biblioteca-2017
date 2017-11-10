package com.sd.uni.biblioteca.service.rol;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.biblioteca.beans.rol.RolB;
import com.sd.uni.biblioteca.rest.rol.IRolResource;
import com.sd.uni.biblioteca.rest.rol.RolResourceImpl;
import com.sd.uni.biblioteca.dto.rol.RolDTO;
import com.sd.uni.biblioteca.dto.rol.RolResult;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service("rolService")
public class RolServiceImpl extends BaseServiceImpl<RolB, RolDTO>
		implements IRolService {
	@Autowired
	private IRolResource _rolResource=new RolResourceImpl();
	
	@Override
	public RolB save(RolB bean) {
		final RolDTO dto = convertBeanToDto(bean);
		final RolDTO rolDTO = _rolResource.save(dto);
		return convertDtoToBean(rolDTO);
	}

	@Override
	public List<RolB> getAll() {
		final RolResult result = _rolResource.getAll();
		final List<RolDTO> rList = null == result.getRols() ? new ArrayList<RolDTO>()
				: result.getRols();
		final List<RolB> rols = new ArrayList<RolB>();

		for (RolDTO dto : rList) {
			final RolB rolB = convertDtoToBean(dto);
			rols.add(rolB);
		}
		return rols;
	}

	@Override
	public RolB getById(Integer id) {
		final RolDTO dto = _rolResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected RolB convertDtoToBean(RolDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("nombre", dto.getNombre());
		final RolB rolB = new RolB(params);
		return rolB;
	}

	@Override
	protected RolDTO convertBeanToDto(RolB bean) {
		final RolDTO dto = new RolDTO();
		dto.setId(bean.getId());
		dto.setNombre(bean.getNombre());
		return dto;
	}

}