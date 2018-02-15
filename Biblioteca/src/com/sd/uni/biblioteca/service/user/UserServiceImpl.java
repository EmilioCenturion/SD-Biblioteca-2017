package com.sd.uni.biblioteca.service.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.dao.role.IRoleDao;
import com.sd.uni.biblioteca.dao.user.IUserDao;
import com.sd.uni.biblioteca.dao.user.UserDaoImpl;
import com.sd.uni.biblioteca.domain.role.RoleDomain;
import com.sd.uni.biblioteca.domain.user.UserDomain;
import com.sd.uni.biblioteca.dto.user.UserDTO;
import com.sd.uni.biblioteca.dto.user.UserResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserDTO, UserDomain, UserDaoImpl, UserResult> implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Autowired
	private IRoleDao roleDao;

	@Autowired CacheManager cacheManager;

	@Override
	@Caching(evict = { @CacheEvict(value="biblioteca-platform-cache", key="'user_getAll'"), 
			   		   @CacheEvict(value="biblioteca-platform-cache", key="'user_getByUsername_'+'#dto.getUsername()'") })
	@Transactional
	public UserDTO delete(UserDTO dto){
		final UserDomain domain = convertDtoToDomain(dto);
		final UserDomain userDomain = userDao.delete(domain);
		return convertDomainToDto(userDomain);
	}

	@Override
	@Caching(evict = { @CacheEvict(value="biblioteca-platform-cache", key="'user_getAll'"),
	                   @CacheEvict(value="biblioteca-platform-cache", key="'user_getByUsername_'+#dto.getUsername()") })
	@CachePut(value="biblioteca-platform-cache", key="'user_getById_'+#dto.getId()", condition="#dto.getId() != null")
	@Transactional
	public UserDTO save(UserDTO dto) {
		final UserDomain domain = convertDtoToDomain(dto);
		final UserDomain userDomain = userDao.save(domain);
		return convertDomainToDto(userDomain);
	}

	@Override
	@Cacheable(value="biblioteca-platform-cache", key="'user_'+#root.methodName+'_'+#id")
	@Transactional(readOnly = true)
	public UserDTO getById(Integer id) {
		final UserDomain userDomain = userDao.getById(id);
		return convertDomainToDto(userDomain);
	}

	@Cacheable(value="biblioteca-platform-cache", key="'user_'+#root.methodName+'_'+#username")
	@Transactional(readOnly = true)
	public UserDTO getByUsername(String username) {
		final UserDomain userDomain = userDao.getByUsername(username);
		return convertDomainToDto(userDomain);
	}

	@Override
	@Cacheable(value="biblioteca-platform-cache", key="'user_'+#root.methodName")
	@Transactional(readOnly = true)
	public UserResult getAll() {
		final List<UserDTO> users = new ArrayList<>();
		for (UserDomain domain : userDao.findAll()) {
			final UserDTO dto = convertDomainToDto(domain);
			users.add(dto);
		}

		final UserResult userResult = new UserResult();
		userResult.setUsers(users);
		return userResult;
	}

	@Override
	protected UserDTO convertDomainToDto(UserDomain domain) {
		final UserDTO dto = new UserDTO();
		dto.setId(domain.getId());
		dto.setUsername(domain.getUsername());
		dto.setPassword(domain.getPassword());
		dto.setName(domain.getName());
		dto.setType(domain.getType());
		dto.setAccountLocked(domain.getAccountLocked());

		final List<Integer> rolesIds = new ArrayList<>();
		Set<RoleDomain> roles = domain.getRoles();
		if(roles!=null){
			for (RoleDomain roleDomain : roles) {
				rolesIds.add(roleDomain.getId());
			}
			dto.setRolesIds(rolesIds);
		}
		return dto;
	}

	@Override
	protected UserDomain convertDtoToDomain(UserDTO dto) {
		final UserDomain domain = new UserDomain();
		domain.setId(dto.getId());
		domain.setUsername(dto.getUsername());
		domain.setPassword(dto.getPassword(),dto.getId());
		domain.setName(dto.getName());
		domain.setType(dto.getType());
		domain.setAccountLocked(dto.getAccountLocked());

		final Set<RoleDomain> roles = new HashSet<>();
		List<Integer> rolesIds = dto.getRolesIds();
		if(rolesIds!=null){
			for (Integer roleId : rolesIds) {
				roles.add(roleDao.getById(roleId));
			}
			domain.setRoles(roles);
		}


		return domain;
	}

	@Override
	public UserResult find(String textToFind) throws BibliotecaException {
		
		return null;
	}
}

