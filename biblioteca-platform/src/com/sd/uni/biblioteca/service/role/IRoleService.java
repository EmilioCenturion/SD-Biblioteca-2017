package com.sd.uni.biblioteca.service.role;

import java.util.Map;

import com.sd.uni.biblioteca.dao.role.RoleDaoImpl;
import com.sd.uni.biblioteca.domain.role.RoleDomain;
import com.sd.uni.biblioteca.dto.role.RoleDTO;
import com.sd.uni.biblioteca.dto.role.RoleResult;
import com.sd.uni.biblioteca.service.base.IBaseService;


public interface IRoleService extends IBaseService<RoleDTO,RoleDomain,RoleDaoImpl,RoleResult> {

	RoleResult getAllBy(Map<String, String> args);

	RoleDTO delete(RoleDTO dto);

}
