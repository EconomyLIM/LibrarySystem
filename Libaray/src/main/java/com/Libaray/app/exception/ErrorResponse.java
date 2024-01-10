package com.Libaray.app.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	// exception 발생시 응답하는 에러 정보 클래스 작성
	
	
	private int code;
	private String errorCode;
	private String message;
	
	public ErrorResponse(ErrorCode errorCode) {
		this.code = errorCode.getCode();
		this.errorCode = errorCode.getErrorCode();
		this.message = errorCode.getMessage();
	}

}
