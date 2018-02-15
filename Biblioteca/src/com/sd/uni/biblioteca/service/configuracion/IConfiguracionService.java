package com.sd.uni.biblioteca.service.configuracion;

import java.util.Map;

import com.sd.uni.biblioteca.dao.configuracion.ConfiguracionDaoImpl;
import com.sd.uni.biblioteca.domain.configuracion.ConfiguracionDomain;
import com.sd.uni.biblioteca.dto.configuracion.ConfiguracionDTO;
import com.sd.uni.biblioteca.dto.configuracion.ConfiguracionResult;
import com.sd.uni.biblioteca.service.base.IBaseService;


public interface IConfiguracionService extends IBaseService<ConfiguracionDTO,ConfiguracionDomain,ConfiguracionDaoImpl,ConfiguracionResult> {

	ConfiguracionDTO getBy(Map<String, String> args);

	ConfiguracionDTO delete(ConfiguracionDTO dto);

}