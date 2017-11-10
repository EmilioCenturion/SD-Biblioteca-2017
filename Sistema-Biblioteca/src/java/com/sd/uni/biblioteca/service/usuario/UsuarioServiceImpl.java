package com.sd.uni.biblioteca.service.usuario;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.biblioteca.beans.usuario.UsuarioB;
import com.sd.uni.biblioteca.rest.usuario.IUsuarioResource;
import com.sd.uni.biblioteca.rest.usuario.UsuarioResourceImpl;
import com.sd.uni.biblioteca.dto.usuario.UsuarioDTO;
import com.sd.uni.biblioteca.dto.usuario.UsuarioResult;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;
import com.sd.uni.biblioteca.service.rol.IRolService;
import com.sd.uni.biblioteca.service.rol.RolServiceImpl;
@Service("usuarioService")
public class UsuarioServiceImpl extends BaseServiceImpl<UsuarioB, UsuarioDTO> implements IUsuarioService {
	@Autowired
	private  IUsuarioResource _usuarioResource= new UsuarioResourceImpl();
	@Autowired
	private IRolService _rolService=new RolServiceImpl();

	public UsuarioServiceImpl() {
	}

	@Override
	public UsuarioB save(UsuarioB bean) {
		final UsuarioDTO dto = convertBeanToDto(bean);
		final UsuarioDTO usuarioDTO = _usuarioResource.save(dto);
		return convertDtoToBean(usuarioDTO);
	}

	@Override
	public List<UsuarioB> getAll() {
		final UsuarioResult result = _usuarioResource.getAll();
		final List<UsuarioDTO> uList = null == result.getUsuarios() ? new ArrayList<UsuarioDTO>() : result.getUsuarios();
		final List<UsuarioB> usuarios = new ArrayList<UsuarioB>();

		for (UsuarioDTO dto : uList) {
			final UsuarioB usuario = convertDtoToBean(dto);
			usuarios.add(usuario);
		}
		return usuarios;
	}

	@Override
	public UsuarioB getById(Integer id) {
		final UsuarioDTO dto = _usuarioResource.getById(id);
		return convertDtoToBean(dto);
	}

	@Override
	protected UsuarioB convertDtoToBean(UsuarioDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("nombre", dto.getNombre());
		final UsuarioB usuario = new UsuarioB(params);
		usuario.setRol(_rolService.getById(dto.getRolId()));
		return usuario;
	}

	@Override
	protected UsuarioDTO convertBeanToDto(UsuarioB bean) {
		final UsuarioDTO dto = new UsuarioDTO();
		dto.setId(bean.getId());
		dto.setRolId(bean.getRol().getId());
		dto.setNombre(bean.getNombre());
		dto.setContrasenha(bean.getContrasenha());
		return dto;
	}

}
