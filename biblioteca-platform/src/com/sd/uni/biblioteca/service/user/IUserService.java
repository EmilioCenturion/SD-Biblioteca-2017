package com.sd.uni.biblioteca.service.user;

import com.sd.uni.biblioteca.dao.user.UserDaoImpl;
import com.sd.uni.biblioteca.domain.user.UserDomain;
import com.sd.uni.biblioteca.dto.user.UserDTO;
import com.sd.uni.biblioteca.dto.user.UserResult;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IUserService extends IBaseService<UserDTO, UserDomain, UserDaoImpl, UserResult> {

	public UserResult find(String textToFind);
}
