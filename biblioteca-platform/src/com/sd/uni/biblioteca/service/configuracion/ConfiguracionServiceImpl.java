package com.sd.uni.biblioteca.service.configuracion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.dao.configuracion.IConfiguracionDao;
import com.sd.uni.biblioteca.dao.configuracion.ConfiguracionDaoImpl;
import com.sd.uni.biblioteca.domain.configuracion.ConfiguracionDomain;
import com.sd.uni.biblioteca.dto.configuracion.ConfiguracionDTO;
import com.sd.uni.biblioteca.dto.configuracion.ConfiguracionResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;


@Service
public class ConfiguracionServiceImpl extends BaseServiceImpl<ConfiguracionDTO, ConfiguracionDomain, ConfiguracionDaoImpl, ConfiguracionResult> implements IConfiguracionService{

	@Autowired private IConfiguracionDao configuracionDao;	
	@Autowired CacheManager cacheManager;
	
	@Override
	@Caching(evict = { @CacheEvict(value="biblioteca-platform-cache", key="'configuracion_getAll'"),					   
	           		   @CacheEvict(value="biblioteca-platform-cache", key="'configuracion_getById_'+#dto.getId()") })
	@Transactional
	public ConfiguracionDTO delete(ConfiguracionDTO dto){
		final ConfiguracionDomain domain = convertDtoToDomain(dto);
		final ConfiguracionDomain configuracionDomain = configuracionDao.delete(domain);
		return convertDomainToDto(configuracionDomain);
	}

	@Override
	@Caching(evict = { @CacheEvict(value="biblioteca-platform-cache", key="'configuracion_getAll'") })
	@CachePut(value="biblioteca-platform-cache", key="'configuracion_getById_'+#dto.getId()", condition="#dto.getId() != null")
	@Transactional
	public ConfiguracionDTO save(ConfiguracionDTO dto){
		final ConfiguracionDTO configuracionDto = dto;		
		final ConfiguracionDomain domain = convertDtoToDomain(configuracionDto);
		final ConfiguracionDomain configuracionDomain = configuracionDao.save(domain);
		return convertDomainToDto(configuracionDomain);
	}

	@Override
	@Cacheable(value="biblioteca-platform-cache", key="'configuracion_'+#root.methodName+'_'+#id")
	@Transactional(readOnly = true)
	public ConfiguracionDTO getById(Integer id){
		final ConfiguracionDomain configuracionDomain = configuracionDao.getById(id);
		return convertDomainToDto(configuracionDomain);
	}

	@Override
	@Cacheable(value="biblioteca-platform-cache", key="'configuracion_'+#root.methodName")
	@Transactional(readOnly = true)
	public ConfiguracionResult getAll(){
		final List<ConfiguracionDTO> configuracions = new ArrayList<>();
		for (ConfiguracionDomain domain : configuracionDao.findAll()){
			final ConfiguracionDTO dto = convertDomainToDto(domain);
			configuracions.add(dto);
		}
		final ConfiguracionResult configuracionResult = new ConfiguracionResult();
		configuracionResult.setConfiguracions(configuracions);
		return configuracionResult;
	}

	@Override
	protected ConfiguracionDTO convertDomainToDto(ConfiguracionDomain domain){
		final ConfiguracionDTO dto = new ConfiguracionDTO();
		dto.setId(domain.getId());
		dto.setMailUsername(domain.getMailUsername());
		dto.setMailPassword(domain.getMailPassword());
		dto.setMailTo(domain.getMailTo());
		dto.setSendCantAlumEnabled(domain.getSendCantAlumEnabled());
		dto.setSendCantProfEnabled(domain.getSendCantProfEnabled());
		
		return dto;
	}

	@Override
	protected ConfiguracionDomain convertDtoToDomain(ConfiguracionDTO dto){
		final ConfiguracionDomain domain = new ConfiguracionDomain();
		domain.setId(dto.getId());
		domain.setMailUsername(dto.getMailUsername());
		domain.setMailPassword(dto.getMailPassword());
		domain.setMailTo(dto.getMailTo());
		domain.setSendCantAlumEnabled(dto.getSendCantAlumEnabled());
		domain.setSendCantProfEnabled(dto.getSendCantProfEnabled());
		return domain;
	}

	@Override
	@Cacheable(value="biblioteca-platform-cache", key="'configuracion_'+#root.methodName+'_'+#args")
	@Transactional(readOnly = true)
	public ConfiguracionDTO getBy(Map<String, String> args) {
		final ConfiguracionDomain configuracionDomain = configuracionDao.getBy(args);
		return convertDomainToDto(configuracionDomain);
	}

	@Override
	public ConfiguracionResult find(String textToFind)
			throws BibliotecaException {
		// TODO Auto-generated method stub
		return null;
	}
}