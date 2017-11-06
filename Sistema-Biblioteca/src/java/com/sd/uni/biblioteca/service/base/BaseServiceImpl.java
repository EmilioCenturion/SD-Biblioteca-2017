package com.sd.uni.biblioteca.service.base;

import com.sd.uni.biblioteca.beans.base.BaseBean;
import com.sd.uni.biblioteca.dto.base.BaseDTO;

public abstract class BaseServiceImpl<BEAN extends BaseBean, DTO extends BaseDTO> implements IBaseService<BEAN, DTO> {

	public BaseServiceImpl() {

	}

	protected abstract BEAN convertDtoToBean(DTO dto);

	protected abstract DTO convertBeanToDto(BEAN bean);

}
