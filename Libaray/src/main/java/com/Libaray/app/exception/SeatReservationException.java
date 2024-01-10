package com.Libaray.app.exception;

import lombok.Getter;

@Getter
public class SeatReservationException extends RuntimeException {

	private ErrorCode errorCode;

	public SeatReservationException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	
}
