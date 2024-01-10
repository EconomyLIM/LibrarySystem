package com.Libaray.app.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
	
	
	// 1000: 로그인, 인증, 인가
	INVAILD_ACCESS_TOKEN(1000, "login_1000" , "잘못된 accessToken 입니다."),
	INVALID_ACCESS_GOOGLE_TOKEN(1004,"login_google_1004", "잘못된 구글 accessToken 입니다."),
	
	// 2000: 열람실
	ALREADY_SEAT_RESERVATION(2000, "S2000", "이미 예약된 좌석입니다."),
	ALREADY_USER_SEAT_RESERVATION(2001, "S2001", "한 좌석만 예약할 수 있습니다");
	
	// 3000: 도서 대여

	private int code;
	private String errorCode;
	private String message;
}
