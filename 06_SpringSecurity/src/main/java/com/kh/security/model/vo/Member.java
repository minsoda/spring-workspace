package com.kh.security.model.vo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
// UserDetails 상속을 받아야 security가 반응할수이따!
public class Member implements UserDetails{

	private String id;
	private String password;
	private String name;
	private String address;
	private String auth;
	private int enabled;
	
	// getAuthorities : 회원의 auth(role) 정보 getter
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> authList = new ArrayList();
		authList.add(new SimpleGrantedAuthority(auth));
		return authList;
	}
	@Override
	public String getUsername() {
		// id를 사용할거라서 
		return id;
	}
	@Override // 계정관련
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override // 약관관련
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override // private int enabled 관련
	public boolean isEnabled() {
		return enabled == 1 ? true : false;
	}
	
}
