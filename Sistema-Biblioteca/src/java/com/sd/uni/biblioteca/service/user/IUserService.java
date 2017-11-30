package com.sd.uni.biblioteca.service.user;

import com.sd.uni.biblioteca.beans.user.UserB;
import com.sd.uni.biblioteca.dto.user.UserDTO;
import com.sd.uni.biblioteca.service.base.IBaseService;

public interface IUserService extends IBaseService<UserB, UserDTO> {		
	
	public UserB getByUsername(String username);
}
