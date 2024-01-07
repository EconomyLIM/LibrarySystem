package com.Libaray.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.Libaray.app.domain.UserDTO;
import com.Libaray.app.security.domain.LoginUserDTO;
import com.Libaray.app.security.domain.Student;
import com.Libaray.app.service.LoginRelatedService;

@Component("studentDetailsService")
public class StudentDetailsService implements UserDetailsService{

	@Autowired
	LoginRelatedService loginRelatedService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		LoginUserDTO loginUserDTO = this.loginRelatedService.read(Integer.parseInt(username));
		
		return loginUserDTO == null ? null : new Student(loginUserDTO);
	}

}
