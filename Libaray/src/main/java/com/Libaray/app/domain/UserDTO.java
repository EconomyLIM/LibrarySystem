package com.Libaray.app.domain;

import java.util.List;

import com.Libaray.app.security.domain.AuthVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private int studentNumber;
	private String studentName;
	private String studentPassword;
	
	// 권한 정보
	private boolean enabled;
	private List<AuthVO> authority;

}
