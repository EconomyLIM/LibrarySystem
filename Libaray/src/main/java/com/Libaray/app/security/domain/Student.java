package com.Libaray.app.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class Student extends User{


	public Student(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}
	
	private static final long serialVersionUID = 6150437510961576152L;
	
	private LoginUserDTO loginUserDTO;

	public Student(LoginUserDTO dto) {
		super( String.valueOf(dto.getStudentNumber()) 
				, dto.getStudentPassword()
				, dto.getAuthority().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuthority())).collect(Collectors.toList()));
		this.loginUserDTO = dto;
	}

}
