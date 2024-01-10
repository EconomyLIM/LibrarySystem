package com.Libaray.app.exception;

import org.apache.log4j.spi.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.log4j.Log4j;

@RestControllerAdvice
@Log4j
public class GlobalExceptionHandler {
	
	ErrorCode errorCode;

	@ExceptionHandler(SeatReservationException.class)
    public ResponseEntity<ErrorResponse> alreadySeatReservation(SeatReservationException ex) {
        log.error("SeatReservationException: " + ex);
        
        ErrorResponse response = new ErrorResponse(ex.getErrorCode());

        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getErrorCode().getCode()));
    }
}
