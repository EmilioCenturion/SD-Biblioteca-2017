package com.sd.uni.biblioteca.service.role;


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

import com.sd.uni.biblioteca.dao.role.IRoleDao;
import com.sd.uni.biblioteca.dao.role.RoleDaoImpl;
import com.sd.uni.biblioteca.domain.role.RoleDomain;
import com.sd.uni.biblioteca.dto.role.RoleDTO;
import com.sd.uni.biblioteca.dto.role.RoleResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;


@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleDTO, RoleDomain, RoleDaoImpl, RoleResult> implements IRoleService {

	@Autowired
	private IRoleDao roleDao;

	@Autowired CacheManager cacheManager;

	@Override
	@Caching(evict = { @CacheEvict(value="biblioteca-platform-cache", key="'role_getAll'"), 
	                   @CacheEvict(value="biblioteca-platform-cache", key="'role_getById_'+#dto.getId()") })
	@Transactional
	public RoleDTO delete(RoleDTO dto){
		final RoleDomain domain = convertDtoToDomain(dto);
		final RoleDomain roleDomain = roleDao.delete(domain);
		return convertDomainToDto(roleDomain);
	}

	@Override
	@CacheEvict(value="biblioteca-platform-cache", key="'role_getAll'")
	@CachePut(value="biblioteca-platform-cache", key="'role_getById_'+#dto.getId()", condition="#dto.getId() != null")
	@Transactional
	public RoleDTO save(RoleDTO dto) {
		final RoleDomain domain = convertDtoToDomain(dto);
		final RoleDomain roleDomain = roleDao.save(domain);
		return convertDomainToDto(roleDomain);
	}

	@Override
	@Cacheable(value="biblioteca-platform-cache", key="'role_'+#root.methodName+'_'+#id")
	@Transactional(readOnly = true)
	public RoleDTO getById(Integer id) {
		final RoleDomain roleDomain = roleDao.getById(id);
		return convertDomainToDto(roleDomain);
	}

	@Override
	@Cacheable(value="biblioteca-platform-cache", key="'role_'+#root.methodName")
	@Transactional(readOnly = true)
	//@Secured("ROLE_SUPERUSER")
	public RoleResult getAll() {
		final List<RoleDTO> roles = new ArrayList<>();
		for (RoleDomain domain : roleDao.findAll()) {
			final RoleDTO dto = convertDomainToDto(domain);
			roles.add(dto);
		}

		final RoleResult roleResult = new RoleResult();
		roleResult.setRoles(roles);
		return roleResult;
	}

	@Override
	@Cacheable(value="biblioteca-platform-cache", key="'role_'+#root.methodName+'_'+#args")
	@Transactional(readOnly = true)
	public RoleResult getAllBy(Map<String, String> args) {
		final List<RoleDTO> roles = new ArrayList<>();
		for (RoleDomain domain : roleDao.findAllBy(args)) {
			final RoleDTO dto = convertDomainToDto(domain);
			roles.add(dto);
		}

		final RoleResult roleResult = new RoleResult();
		roleResult.setRoles(roles);
		return roleResult;
	}

	@Override
	public RoleDTO convertDomainToDto(RoleDomain domain) {
		final RoleDTO dto = new RoleDTO();
		dto.setId(domain.getId());
		dto.setAuthority(domain.getAuthority());
		return dto;
	}

	@Override
	public RoleDomain convertDtoToDomain(RoleDTO dto) {
		final RoleDomain domain = new RoleDomain();
		domain.setId(dto.getId());
		domain.setAuthority(dto.getAuthority());
		return domain;
	}

	@Override
	public RoleResult find(String textToFind) throws BibliotecaException {
		// TODO Auto-generated method stub
		return null;
	}
}

