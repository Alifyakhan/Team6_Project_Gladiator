package com.lti.security;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.lti.domain.UserT;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name="user_role")
@SequenceGenerator(name = "seq3", sequenceName = "seq3", allocationSize = 1)
public class UserRole implements Serializable {
	
	private static final long serialVersionUID = 890345L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq3")
	private long userRoleId;
	
	public UserRole() {}
	
	public UserRole (UserT userr, Role role) {
		this.userr = userr;
		this.role = role;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private UserT userr;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;

	public long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public UserT getUserr() {
		return userr;
	}

	public void setUserr(UserT userr) {
		this.userr = userr;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
