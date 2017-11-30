package com.sd.uni.biblioteca.dao.configuracion;

import java.util.Map;

import com.sd.uni.biblioteca.dao.base.IBaseDao;
import com.sd.uni.biblioteca.domain.configuracion.ConfiguracionDomain;

public interface IConfiguracionDao extends IBaseDao<ConfiguracionDomain> {

	ConfiguracionDomain getBy(Map<String, String> args);

	ConfiguracionDomain delete(ConfiguracionDomain domain);

}