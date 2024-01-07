package com.Libaray.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Libaray.app.service.BookRelatedService;

@RestController
public class BookRestController {
	
	@Autowired
	private BookRelatedService bookRelatedService;

	@PostMapping(value= "/book/{bookId}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<String> bookRent(
			Principal principal,
			@PathVariable int bookId){
		
		System.err.println(bookId);
		
		if (principal == null) {
			return new ResponseEntity<String>("로그인 후 이용해주세요.", HttpStatus.INTERNAL_SERVER_ERROR);
		} // if
		
		int rowCnt = this.bookRelatedService.bookRentService(Integer.parseInt(principal.getName()), bookId);
		
		if (rowCnt != 2) {
			return new ResponseEntity<String>("내부 서버 오류", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<String>("책 대여 완료", HttpStatus.OK);
	} // bookRent
	
	
} // class
