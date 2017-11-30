package com.sd.uni.biblioteca.dto.configuracion;

import com.sd.uni.biblioteca.dto.base.BaseResult;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import java.util.List;

@XmlRootElement(name = "configuracionResult")
public class ConfiguracionResult extends BaseResult<ConfiguracionDTO>{

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<ConfiguracionDTO> getConfiguracions(){
		return getList();
	}

	public void setConfiguracions(List<ConfiguracionDTO> dtos) {
		super.setList(dtos);
	}
}