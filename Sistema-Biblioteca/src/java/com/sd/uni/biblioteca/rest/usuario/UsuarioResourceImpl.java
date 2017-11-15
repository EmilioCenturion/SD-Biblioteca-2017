package com.sd.uni.biblioteca.rest.usuario;


//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.usuario.UsuarioDTO;
import com.sd.uni.biblioteca.dto.usuario.UsuarioResult;
import com.sd.uni.biblioteca.rest.base.BaseResourceImpl;

@Repository("usuarioResource")
public class UsuarioResourceImpl extends BaseResourceImpl<UsuarioDTO> implements
		IUsuarioResource {

	public UsuarioResourceImpl() {
		super(UsuarioDTO.class, "/usuario");
	}

	//@CacheEvict(value = CACHE_REGION, key = "'usuario_' + #usuario.id", condition = "#usuario.id!=null")
	@Override
	public UsuarioDTO save(UsuarioDTO usuario) {
		return super.save(usuario);
	}

	//@Cacheable(value = CACHE_REGION, key = "'usuario_' + #id")
	@Override
	public UsuarioDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	public UsuarioResult getAll() {
		UsuarioResult usuarios = getWebResource().get(UsuarioResult.class);
		/*for (UsuarioDTO usuario : usuarios.getUsuarios()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"state_" + usuario.getId(), usuario);
		}
		*/
		return usuarios;
	}

}
