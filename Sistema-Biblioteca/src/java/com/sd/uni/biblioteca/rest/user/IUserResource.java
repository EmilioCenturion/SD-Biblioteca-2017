package com.sd.uni.biblioteca.rest.user;

import  com.sd.uni.biblioteca.dto.user.UserDTO;
import  com.sd.uni.biblioteca.dto.user.UserResult;
import  com.sd.uni.biblioteca.rest.base.IBaseResource;

public interface IUserResource extends IBaseResource<UserDTO> {

	public UserResult getAll();
	
	public UserDTO getByUsername(String username);
}