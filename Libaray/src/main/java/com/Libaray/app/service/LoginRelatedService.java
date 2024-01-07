package com.Libaray.app.service;

import com.Libaray.app.domain.UserDTO;
import com.Libaray.app.security.domain.LoginUserDTO;

public interface LoginRelatedService {

	int signIn(UserDTO signInCheckDTO) ;
	
	LoginUserDTO read (int studentNumber);
}
