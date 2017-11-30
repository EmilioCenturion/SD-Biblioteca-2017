package com.sd.uni.biblioteca.domain.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sd.uni.biblioteca.domain.base.BaseDomain;

@Entity
@Table(name = "role")
public class RoleDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "authority", nullable = false, length = 50, unique = true)
	private String _authority;
	/*	
	@OneToMany(mappedBy="_role", cascade=CascadeType.ALL)
	private Set<UserRoleDomain> _users_roles;
	
	public Set<UserRoleDomain> getUsersRoles(){
		return _users_roles;
	}
	*/
	public Integer getId() {
		return _id;
	}

	public void setId(Integer _id) {
		this._id = _id;
	}

	public String getAuthority() {
		return _authority;
	}

	public void setAuthority(String _authority) {
		this._authority = _authority;
	}	
}

