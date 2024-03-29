package com.Libaray.app.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Libaray.app.domain.SeatDTO;
import com.Libaray.app.service.SeatReservationService;

@RestController
public class HomeRestController {

	@Autowired
	private SeatReservationService seatReservationService;
	
	
	@PostMapping(value= "/seat/{seatId}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<String> seatReservation(
			Principal principal,
			@PathVariable int seatId) throws Exception {
		
		Long studentNumber = (long) Integer.parseInt(principal.getName());
		
		this.seatReservationService.seatReservation(studentNumber, seatId);
		
		return new ResponseEntity<String>("열람실 예약에 성공하였습니다.", HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/seat/{connectionseq}")
	public ResponseEntity<String> returnSeat(
			@PathVariable int connectionseq
			, Principal principal){
	
		int studentNumber = Integer.parseInt(principal.getName());
		
		int rowCnt = this.seatReservationService.seatReturnService(connectionseq, studentNumber);
		
		return rowCnt == 1? new ResponseEntity<String>("Update Success", HttpStatus.OK) : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/seat/{connectionseq}")
	public ResponseEntity<String> extensionSeat(
			@PathVariable int connectionseq
			, Principal principal){
		
		int studentNumber = Integer.parseInt(principal.getName());
		
		int rowCnt = this.seatReservationService.seatExtensionService(connectionseq, studentNumber);
		
		return rowCnt == 1? new ResponseEntity<String>("Update Success", HttpStatus.OK) : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
