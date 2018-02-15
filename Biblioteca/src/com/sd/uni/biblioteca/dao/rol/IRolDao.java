package com.sd.uni.biblioteca.dao.rol;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.rol.RolDomain;

public interface IRolDao extends IBaseDao<RolDomain> {

	public List<RolDomain>find(String textToFind);
}
