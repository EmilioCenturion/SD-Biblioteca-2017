package com.sd.uni.biblioteca.rest.base;

import com.sd.uni.biblioteca.dto.base.BaseDTO;

public interface IBaseResource<DTO extends BaseDTO> {

	public DTO save(DTO dto);

	public DTO getById(Integer id);

}
