package com.Libaray.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Libaray.app.domain.UserDTO;
import com.Libaray.app.mapper.HomeMapper;
import com.Libaray.app.security.domain.LoginUserDTO;

@Service
public class LoginRelatedServiceImpl implements LoginRelatedService{
	
	@Autowired
	private HomeMapper homeMapper;

	@Override
	public int signIn(UserDTO signInCheckDTO){
		
		return this.homeMapper.signIn(signInCheckDTO);
	}

	@Override
	public LoginUserDTO read(int studentNumber) {
		
		return this.homeMapper.read(studentNumber);
	}
	
	

}
