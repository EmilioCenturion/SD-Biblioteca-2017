package com.sd.uni.biblioteca.service.usuario;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;











import com.sd.uni.biblioteca.dao.rol.IRolDao;
import com.sd.uni.biblioteca.dao.usuario.IUsuarioDao;
import com.sd.uni.biblioteca.dao.usuario.UsuarioDaoImpl;
import com.sd.uni.biblioteca.domain.usuario.UsuarioDomain;
import com.sd.uni.biblioteca.dto.usuario.UsuarioDTO;
import com.sd.uni.biblioteca.dto.usuario.UsuarioResult;
import com.sd.uni.biblioteca.exception.BibliotecaException;
import com.sd.uni.biblioteca.service.base.BaseServiceImpl;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<UsuarioDTO, UsuarioDomain, UsuarioDaoImpl, UsuarioResult>
		implements IUsuarioService {
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private IRolDao rolDao;

	@Override
	@Transactional
	public UsuarioDTO save(UsuarioDTO dto) {
		final UsuarioDomain domain = convertDtoToDomain(dto);
		final UsuarioDomain usuarioDomain = usuarioDao.save(domain);
		return convertDomainToDto(usuarioDomain);
	}

	@Override
	@Transactional
	public UsuarioDTO getById(Integer id) throws BibliotecaException {
		final UsuarioDomain domain = usuarioDao.getById(id);
		final UsuarioDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public UsuarioResult getAll() {
		final List<UsuarioDTO> usuario = new ArrayList<>();
		for (UsuarioDomain domain : usuarioDao.findAll()) {
			final UsuarioDTO dto = convertDomainToDto(domain);
			usuario.add(dto);
		}
		final UsuarioResult usuarioResult = new UsuarioResult();
		usuarioResult.setUsuarios(usuario);
		return usuarioResult;
	}

	@Override
	@Transactional
	public UsuarioResult find(String textToFind) {
		final List<UsuarioDTO> usuarios = new ArrayList<>();
		for (UsuarioDomain domain : usuarioDao.find(textToFind)) {
			final UsuarioDTO dto = convertDomainToDto(domain);
			usuarios.add(dto);
		}
		final UsuarioResult usuarioResult = new UsuarioResult();
		usuarioResult.setUsuarios(usuarios);
		return usuarioResult;
	}

	@Override
	protected UsuarioDTO convertDomainToDto(UsuarioDomain domain) {
		final UsuarioDTO dto = new UsuarioDTO();
		dto.setId(domain.getId());
		dto.setNombre(domain.getNombre());
		dto.setContrasenha(domain.getContrasenha());
		dto.setRolId(domain.getRol().getId());
		return dto;
	}

	@Override
	protected UsuarioDomain convertDtoToDomain(UsuarioDTO dto) {
		final UsuarioDomain domain = new UsuarioDomain();
		domain.setId(dto.getId());
		domain.setNombre(dto.getNombre());
		domain.setContrasenha(dto.getContrasenha());
		domain.setRol(rolDao.getById(dto.getRolId()));
		
		return domain;
	}

}
