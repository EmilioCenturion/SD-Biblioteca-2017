package com.sd.uni.biblioteca.service.rol;

import com.sd.uni.biblioteca.dao.rol.RolDaoImpl;
import com.sd.uni.biblioteca.domain.rol.RolDomain;
import com.sd.uni.biblioteca.dto.rol.RolDTO;
import com.sd.uni.biblioteca.dto.rol.RolResult;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IRolService extends IBaseService<RolDTO, RolDomain, RolDaoImpl, RolResult> {

	public RolResult find(String textToFind);
}
