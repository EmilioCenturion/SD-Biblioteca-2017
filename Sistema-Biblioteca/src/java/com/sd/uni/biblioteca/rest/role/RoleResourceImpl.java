package com.sd.uni.biblioteca.rest.role;

import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.role.RoleDTO;
import com.sd.uni.biblioteca.dto.role.RoleResult;
import com.sd.uni.biblioteca.rest.base.BaseResourceImpl;

@Repository("roleResource")
public class RoleResourceImpl extends BaseResourceImpl<RoleDTO> implements IRoleResource {

	public RoleResourceImpl() {
		super(RoleDTO.class, "/role");
	}

	@Override
	public RoleResult getAll() {
		setWebResourceBasicAuthFilter();
		return getWebResource().get(RoleResult.class);
	}

	@Override
	public RoleDTO getById(Integer id) {
		return getWebResource().path("/" + id).get(getDtoClass());
	}

}