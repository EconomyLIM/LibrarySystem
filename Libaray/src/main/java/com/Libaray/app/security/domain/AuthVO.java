package com.Libaray.app.security.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthVO implements Serializable{
	
	private static final long serialVersionUID = 8961121508118129466L;
	
	private String username;
	private String authority;
	

}
