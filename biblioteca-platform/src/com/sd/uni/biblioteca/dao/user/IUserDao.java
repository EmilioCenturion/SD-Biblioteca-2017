package com.sd.uni.biblioteca.dao.user;

import java.util.List;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.user.UserDomain;

public interface IUserDao extends IBaseDao<UserDomain> {

	public List<UserDomain>find(String textToFind);
}
