package com.sd.uni.biblioteca.rest.role;

import com.sd.uni.biblioteca.dto.role.RoleDTO;
import com.sd.uni.biblioteca.dto.role.RoleResult;
import com.sd.uni.biblioteca.rest.base.IBaseResource;

public interface IRoleResource extends IBaseResource<RoleDTO> {

	public RoleResult getAll();
}