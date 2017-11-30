package com.sd.uni.biblioteca.rest.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.sd.uni.biblioteca.dto.base.BaseDTO;
import com.sd.uni.biblioteca.service.auth.IAuthService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

@Repository
public abstract class BaseResourceImpl<DTO extends BaseDTO> implements IBaseResource<DTO> {
	private final String _resourcePath;
	private final Class<DTO> _dtoClass;
	private final WebResource _webResource;
	@Autowired
	private IAuthService authService;

	private static final String BASE_URL = "http://localhost:8080/biblioteca-platform/rest";
	protected static final String CACHE_REGION = "biblioteca-platform-web-cache";
	

	@Autowired
	
	
	public BaseResourceImpl(Class<DTO> dtoClass, String resourcePath) {
		_dtoClass = dtoClass;
		_resourcePath = BASE_URL + resourcePath;

		final Client jerseyClient = Client.create();

		_webResource = jerseyClient.resource(_resourcePath);
	}

	protected WebResource getWebResource() {
		return _webResource;
	}

	protected Class<DTO> getDtoClass() {
		return _dtoClass;
	}
	
	/* Este método se encarga de establecer un usuario y contraseña en la cabecera del request
	 * del webResource, lo que le permite autenticarse para acceder a los recursos del webService
	 * El web service esta configurado para requerir un tipo de autenticación básica la cual se 
	 * establece en este método
	 * Este método se usa siempre antes de llamar al método getWebResource() en todas las clases ResourceImpl
	 * menos las clases ResourceImpl de user y role, en donde authService provocaría un fallo
	 * ya que authService requiere que el usuario este logueado para que pueda funcionar
	 */
	public void setWebResourceBasicAuthFilter(){
		Authentication au = SecurityContextHolder.getContext().getAuthentication();

		String username="";
		String password="";
	    if (au.getPrincipal() instanceof UserDetails) {
	        username=((UserDetails) au.getPrincipal()).getUsername();
	        password=((UserDetails) au.getPrincipal()).getPassword();
	        System.out.println("username "+username);
	    } else {
	    	System.out.println("el resto" + au.getPrincipal().toString());
	        
	    }
	    System.out.println("usernameeee "+username);
		//String u = authService.getUsername();
		//String p = authService.getPassword();
				
		_webResource.addFilter(new HTTPBasicAuthFilter(username,password));		
	}
	
	@Override
	public DTO save(DTO dto) {
		return getWebResource().entity(dto).post(getDtoClass());
	}

	@Override
	public DTO getById(Integer id) {
		return getWebResource().path("/" + id).get(getDtoClass());
	}

	
}
