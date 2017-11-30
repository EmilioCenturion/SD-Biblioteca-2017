/* Se crea una versión propia del AuthenticationProvider de SpringSecurity y se sobreescribe
 * su método authenticate. Este método básicamente obtiene el username y password del webservice
 * en base al username especificado en el formulario; compara el password especificado en el formulario
 * con el password encriptado traido del webservice, si son iguales, se obtiene los roles del usuario
 * especificado desde el webservice y se establecen las autorizaciones correspondientes */
package login;

/* Implementación basada en las siguientes fuentes:
 * - http://stackoverflow.com/questions/8649818/implement-custom-authenticationprovider-in-spring-security-2-06
 * - https://github.com/itbrain/grails-custom-authentication-provider-example
 * */

import grails.plugin.springsecurity.userdetails.GrailsUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.sd.uni.biblioteca.beans.role.RoleB;
import com.sd.uni.biblioteca.beans.user.UserB;
import com.sd.uni.biblioteca.service.user.IUserService;


class MyAuthenticationProvider implements AuthenticationProvider {
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	private IUserService _userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
		String username = String.valueOf(auth.getPrincipal());
		String password = String.valueOf(auth.getCredentials());			
		
		System.out.println(authentication);
		UserB user = _userService.getByUsername(username);	
		System.out.println(user.getUsername());
		if(user!=null){ 
			if (passwordEncoder.matches(password,user.getPassword())) {
								
				List<GrantedAuthority> authorities = getUserRoles(user);
				if(authorities != null){
					//MyUserDetails(String username, String password, boolean enabled,boolean accountNonExpired, boolean credentialsNonExpired,boolean accountNonLocked,Collection<GrantedAuthority> authorities,long id) {
					//Se usa el atributo accountLocked del user como enabled. 
					//Si accountLocked es true entonces el usuario esta activo o habilitado
					//Si enabled es false, el usuario no podrá acceder a ninguna parte
					//En la interfaz de nuevo usuario, al crear un nuevo usuario el checkbox habilitado
					//equivale a enabled y/o accountLocked
					Boolean enabled=Boolean.valueOf(user.getAccountLocked());
					
					GrailsUser userDetails = new GrailsUser(username, password, enabled, true, true, true, authorities, 1);
					UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
					
					
					token.setDetails(authentication.getDetails());
				
					return token;
				}else{
					throw new BadCredentialsException("Log in failed: El usuario no tiene ningun rol");
				}
			}else{
				throw new BadCredentialsException("Log in failed: Contraseña incorrecta"); 			
			}
		}//else throw new BadCredentialsException("Log in failed: El usuario especificado no existe");//Nunca salta porque la excepcion ya ocurre en UserB user = getUser(username);	
		
		return auth;
	}	
	
	private UserB getUser(String username){	
		UserB userB = _userService.getByUsername(username);
		
		return userB;		
	}	
	
	private List<GrantedAuthority> getUserRoles(UserB user) {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
				
		final Set<RoleB> roles = user.getRoles();
		if(roles!=null){
			System.out.print("Roles del usuario "+user.getUsername()+" ");//Borrar
			for (RoleB roleB : roles) {
				
				list.add(new GrantedAuthorityImpl(roleB.getAuthority()));
				System.out.print(roleB.getAuthority()+" ");//Borrar
			}
		}

		return list;
	}

	@Override
	public boolean supports(Class<?> arg0) {		
		return true;
	}


}

