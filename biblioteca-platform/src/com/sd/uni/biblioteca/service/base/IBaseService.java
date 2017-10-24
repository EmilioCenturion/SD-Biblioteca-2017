package com.sd.uni.biblioteca.service.base;

import com.sd.uni.biblioteca.dao.base.BaseDaoImpl;
import com.sd.uni.biblioteca.domain.base.BaseDomain;
import com.sd.uni.biblioteca.dto.base.BaseDTO;
import com.sd.uni.biblioteca.dto.base.BaseResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;

public interface IBaseService<DTO extends BaseDTO, DOMAIN extends BaseDomain, DAO extends BaseDaoImpl<DOMAIN>, R extends BaseResult<DTO>> {
	public DTO save(DTO dto);

	public DTO getById(Integer id) throws BibliotecaException;

	public R getAll();
	
	
	public R find(String textToFind) throws BibliotecaException;

}
