/* Este servicio provee los metodos para obtener el username y password del usuario
 * logueado. Este servicio se usa en rest/BaseResourceImpl en el método setWebResourceBasicAuthFilter */
package com.sd.uni.biblioteca.service.auth;

import grails.plugin.springsecurity.userdetails.GrailsUser;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
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

@Service("AuthService")
public class AuthServiceImpl implements IAuthService {
		
	public AuthServiceImpl(){		
	}	
	
	public String getUsername(){
		GrailsUser userDetails = (GrailsUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Authentication au = SecurityContextHolder.getContext().getAuthentication();

	    if (au.getPrincipal() instanceof UserDetails) {
	        String username=((UserDetails) au.getPrincipal()).getUsername();
	        
	        return username;
	    } else {
	    	return null;
	        
	    }
		
	}	
	
	public String getPassword(){
		//GrailsUser userDetails = (GrailsUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Authentication au = SecurityContextHolder.getContext().getAuthentication();

	    if (au.getPrincipal() instanceof UserDetails) {
	        String password=((UserDetails) au.getPrincipal()).getPassword();
	        
	        return password;
	    } else {
	    	return null;
	        
	    }
	}
}
