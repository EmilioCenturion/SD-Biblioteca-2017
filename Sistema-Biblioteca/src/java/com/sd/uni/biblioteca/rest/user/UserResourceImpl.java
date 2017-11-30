package com.sd.uni.biblioteca.rest.user;

import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.user.UserDTO;
import com.sd.uni.biblioteca.dto.user.UserResult;
import com.sd.uni.biblioteca.rest.base.BaseResourceImpl;

@Repository("userResource")
public class UserResourceImpl extends BaseResourceImpl<UserDTO> implements IUserResource {
		
	public UserResourceImpl() {
		super(UserDTO.class, "/user");
	}

	@Override
	public UserResult getAll() {
		setWebResourceBasicAuthFilter();
		return getWebResource().get(UserResult.class);
	}
	
	@Override
	public UserDTO getByUsername(String username) {		
		return getWebResource().path("/username/" + username).get(getDtoClass());
	}
}