package com.hlian.education.jwt.config;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2971033491841846439L;

	private String authority;

	public GrantedAuthorityImpl(String authority) {
		this.authority = authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return this.authority;
	}
}