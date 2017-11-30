package com.sd.uni.biblioteca.service.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.sd.uni.biblioteca.beans.role.RoleB;
import com.sd.uni.biblioteca.beans.user.UserB;
import com.sd.uni.biblioteca.dto.user.UserDTO;
import com.sd.uni.biblioteca.dto.user.UserResult;
import com.sd.uni.biblioteca.rest.user.IUserResource;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;
import com.sd.uni.biblioteca.service.role.IRoleService;
import com.sd.uni.biblioteca.service.user.IUserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserB, UserDTO> implements
		IUserService {

	@Autowired
	private IUserResource _userResource;
	@Autowired
	private IRoleService _roleService;

	public UserServiceImpl() {
	}

	

	@Override
	@Caching(evict = { @CacheEvict(value="isp-client-web-cache", key="'user_getAll'"),
	   		           @CacheEvict(value="isp-client-web-cache", key="'user_getByUsername_'+#bean.getUsername()") })
	@CachePut(value="isp-client-web-cache", key="'user_getById_'+#bean.getId()", condition="#bean.getId() != null")
	public UserB save(UserB bean) {
		final UserDTO dto = convertBeanToDto(bean);
		final UserDTO userDTO = _userResource.save(dto);
		return convertDtoToBean(userDTO);
	}

	@Override
	@Cacheable(value="isp-client-web-cache", key="'user_'+#root.methodName")
	public List<UserB> getAll() {
		final UserResult result = _userResource.getAll();
		final List<UserDTO> cList = null == result.getUsers() ? new ArrayList<UserDTO>()
				: result.getUsers();
		final List<UserB> users = new ArrayList<UserB>();
		for (UserDTO dto : cList) {
			final UserB user = convertDtoToBean(dto);
			users.add(user);
		}
		return users;
	}

	@Override
	@Cacheable(value="isp-client-web-cache", key="'user_'+#root.methodName+'_'+#id")
	public UserB getById(Integer id) {
		final UserDTO dto = _userResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	@Cacheable(value="isp-client-web-cache", key="'user_'+#root.methodName+'_'+#username")
	public UserB getByUsername(String username) {
		final UserDTO dto = _userResource.getByUsername(username);
		return convertDtoToBean(dto);
	}

	@Override
	protected UserB convertDtoToBean(UserDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("username", dto.getUsername());
		params.put("password", dto.getPassword());
		params.put("name", dto.getName());
		params.put("type", dto.getType());
		params.put("accountLocked", dto.getAccountLocked());
		final UserB user = new UserB(params);

		final Set<RoleB> roles = new HashSet<RoleB>();
		List<Integer> rolesIds = dto.getRolesIds();

		if(rolesIds!=null){
			if(rolesIds.size()>0){
				for (Integer roleId : rolesIds) {
					roles.add(_roleService.getById(roleId));
				}
				user.setRoles(roles);
			}
		}else{
			System.out.println("No trae roles desde el web service");
		}
		return user;
	}

	@Override
	protected UserDTO convertBeanToDto(UserB bean) {
		final UserDTO dto = new UserDTO();
		dto.setId(bean.getId());
		dto.setUsername(bean.getUsername());
		dto.setPassword(bean.getPassword());
		dto.setName(bean.getName());
		dto.setType(bean.getType());
		dto.setAccountLocked(bean.getAccountLocked());

		final List<Integer> rolesIds = new ArrayList<Integer>();
		Set<RoleB> roles = bean.getRoles();
		if(roles!=null){
			for (RoleB roleB : roles) {
				rolesIds.add(roleB.getId());
				//System.out.println("Sus roles son id: "+roleB.getId()+" nombre: "+roleB.getAuthority());
			}
			dto.setRolesIds(rolesIds);
		}else{
			System.out.println("No se especifico roles en el cliente!!");
		}

		return dto;
	}
}
