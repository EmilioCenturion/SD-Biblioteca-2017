package com.sd.uni.biblioteca.service.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sd.uni.biblioteca.beans.role.RoleB;
import com.sd.uni.biblioteca.dto.role.RoleDTO;
import com.sd.uni.biblioteca.dto.role.RoleResult;
import com.sd.uni.biblioteca.rest.role.IRoleResource;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<RoleB, RoleDTO> implements
		IRoleService {

	@Autowired
	private IRoleResource _roleResource;

	public RoleServiceImpl() {
	}

	

	@Override
	@CacheEvict(value="isp-client-web-cache", key="'role_getAll'")
	@CachePut(value="isp-client-web-cache", key="'role_getById_'+#bean.getId()", condition="#bean.getId() != null")
	public RoleB save(RoleB bean) {
		final RoleDTO dto = convertBeanToDto(bean);
		final RoleDTO roleDTO = _roleResource.save(dto);
		return convertDtoToBean(roleDTO);
	}

	@Override
	@Cacheable(value="isp-client-web-cache", key="'role_'+#root.methodName")
	public List<RoleB> getAll() {
		final RoleResult result = _roleResource.getAll();
		final List<RoleDTO> cList = null == result.getRoles() ? new ArrayList<RoleDTO>()
				: result.getRoles();
		final List<RoleB> roles = new ArrayList<RoleB>();
		for (RoleDTO dto : cList) {
			final RoleB role = convertDtoToBean(dto);
			roles.add(role);
		}
		return roles;
	}

	@Override
	@Cacheable(value="isp-client-web-cache", key="'role_'+#root.methodName+'_'+#id")
	public RoleB getById(Integer id) {
		final RoleDTO dto = _roleResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected RoleB convertDtoToBean(RoleDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("authority", dto.getAuthority());

		final RoleB role = new RoleB(params);
		return role;
	}

	@Override
	protected RoleDTO convertBeanToDto(RoleB bean) {
		final RoleDTO dto = new RoleDTO();
		dto.setId(bean.getId());
		dto.setAuthority(bean.getAuthority());

		return dto;
	}
}
