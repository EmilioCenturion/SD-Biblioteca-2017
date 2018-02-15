package com.sd.uni.biblioteca.dto.motivoSalida;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.biblioteca.dto.base.BaseResult;

@XmlRootElement(name = "motivoSalidaResult")
public class MotivoSalidaResult extends BaseResult<MotivoSalidaDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<MotivoSalidaDTO> getMotivos() {
		return getList();
	}

	public void setMotivos(List<MotivoSalidaDTO> dtos) {
		super.setList(dtos);
	}
}
