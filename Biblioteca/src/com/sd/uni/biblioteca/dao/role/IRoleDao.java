package com.sd.uni.biblioteca.dao.role;

import java.util.List;
import java.util.Map;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.role.RoleDomain;


public interface IRoleDao extends IBaseDao<RoleDomain> {

	List<RoleDomain> findAllBy(Map<String, String> args);


	RoleDomain delete(RoleDomain domain);

	}