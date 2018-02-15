package com.sd.uni.biblioteca.domain.user;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sd.uni.biblioteca.domain.base.BaseDomain;
import com.sd.uni.biblioteca.domain.role.RoleDomain;

@Entity
@Table(name = "user")
public class UserDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "username", nullable = false, length = 50, unique = true)
	private String _username;
	
	@Column(name = "name", nullable = false, length = 50)
	private String _name;
	
	@Column(name = "type", nullable = false, length = 15)
	private String _type;
	
	@Column(name = "password", nullable = false, length = 250)
	private String _password;
	
	@Column(name = "account_expired", nullable = true)
	private Boolean _accountExpired;
	
	@Column(name = "account_locked", nullable = true)
	private Boolean _accountLocked;
	
	@Column(name = "password_expired", nullable = true)
	private Boolean _passwordExpired;
	
	
	/* Fuente: https://dzone.com/tutorials/java/hibernate/hibernate-example/hibernate-mapping-many-to-many-using-annotations-1.html */ 
	@ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
		    name="user_role",
		    joinColumns= @JoinColumn(name="user_id", referencedColumnName="id"),
		    inverseJoinColumns= @JoinColumn(name="role_id", referencedColumnName="id")
    )
	private Set<RoleDomain> _roles;
	
	public Set<RoleDomain> getRoles(){
		return _roles;
	}
	
	public void setRoles(Set<RoleDomain> roles){
		_roles = roles;
	}
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer _id) {
		this._id = _id;
	}

	public String getUsername() {
		return _username;
	}

	public void setUsername(String _username) {
		this._username = _username;
	}

	public String getPassword() {
		return _password;
	}
	//Cuando el usuario es nuevo userId is null, solo cuando el usuario
	//es nuevo, se codifica el password
	public void setPassword(String _password, Integer userId) {
		if(userId==null){
			/* Codifica el password usando BCrypt */
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(_password);
			
			this._password = hashedPassword;
		}else{
			this._password = _password;
		}		
	}
	
	public String getName() {
		return _name;
	}

	public void setName(String _name) {
		this._name = _name;
	}
	
	public String getType() {
		return _type;
	}

	public void setType(String _type) {
		this._type = _type;
	}

	public String getAccountExpired() {
		return _accountExpired.toString();
	}

	public void setAccountExpired(String _accountExpired) {
		this._accountExpired = Boolean.valueOf(_accountExpired);
	}

	public String getAccountLocked() {
		return _accountLocked.toString();
	}

	public void setAccountLocked(String _accountLocked) {
		this._accountLocked = Boolean.valueOf(_accountLocked);
	}

	public String getPasswordExpired() {
		return _passwordExpired.toString();
	}

	public void setPasswordExpired(String _passwordExpired) {
		this._passwordExpired = Boolean.valueOf(_passwordExpired);
	}		
}

