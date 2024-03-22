package com.Libaray.app.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Libaray.app.domain.SeatDTO;
import com.Libaray.app.service.SeatReservationService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class SeatController {
	
	@Autowired
	private SeatReservationService seatReservationService;
	
	@GetMapping("/seat/usedhistory")
	public String usedHistory(Principal principal
			, Model model) {
	
		log.info("SeatController_usedHistory_call");
		int studentNumber = Integer.parseInt(principal.getName());
		
		List<SeatDTO> seatList = this.seatReservationService.getSeatHitory(studentNumber);
		
		model.addAttribute("seatList", seatList);
		
		return "home.usedhistory";
	}

}
