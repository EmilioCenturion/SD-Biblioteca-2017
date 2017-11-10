package com.sd.uni.biblioteca.rest.rol;


import com.sd.uni.biblioteca.dto.rol.RolDTO;
import com.sd.uni.biblioteca.dto.rol.RolResult;
import com.sd.uni.biblioteca.rest.base.IBaseResource;

public interface IRolResource extends IBaseResource<RolDTO> {
	public RolResult getAll();
}