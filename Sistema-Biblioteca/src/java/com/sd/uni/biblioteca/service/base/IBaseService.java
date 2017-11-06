package com.sd.uni.biblioteca.service.base;

import java.util.List;

import com.sd.uni.biblioteca.beans.base.BaseBean;
import com.sd.uni.biblioteca.dto.base.BaseDTO;

public interface IBaseService<BEAN extends BaseBean, DTO extends BaseDTO> {
	public BEAN save(BEAN bean);

	public List<BEAN> getAll();

	public BEAN getById(Integer id);
}
