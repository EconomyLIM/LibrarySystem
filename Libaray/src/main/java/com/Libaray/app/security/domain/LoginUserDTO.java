package com.Libaray.app.security.domain;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserDTO implements Serializable{

	private static final long serialVersionUID = -4943718915168084694L;
	
	private int studentNumber;
	private String studentPassword;
	private String studentName;
	
	// 권한 정보
		private boolean enabled;
		private List<AuthVO> authority;

}
