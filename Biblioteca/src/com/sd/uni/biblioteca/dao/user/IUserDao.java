package com.sd.uni.biblioteca.dao.user;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.user.UserDomain;

public interface IUserDao extends IBaseDao<UserDomain> {

	UserDomain getByUsername(String username);

	UserDomain delete(UserDomain domain);



}