package com.Libaray.app.controller;

import java.security.Principal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Libaray.app.domain.SeatDTO;
import com.Libaray.app.domain.UserDTO;
import com.Libaray.app.service.LoginRelatedService;
import com.Libaray.app.service.SeatReservationService;


@Controller
@RequestMapping("/")
public class HomeController {
	
	
	@Autowired
	private SeatReservationService seatReservationService;
	
	@Autowired
	private LoginRelatedService loginRelatedService;
	

	@GetMapping
	public String home(Model model
			, Principal principal) throws ClassNotFoundException, SQLException {
		
		List<SeatDTO> seats = this.seatReservationService.getSeatList();
		
		if (principal != null) {
			seats = isMine(seats, Integer.parseInt(principal.getName()));
		} //if
		
		model.addAttribute("seats", seats);
		System.err.println(model.toString());
	
		return "home.home";
	}
	
	public List<SeatDTO> isMine(List<SeatDTO> seat, int studentNumber){
		
		for (int i = 0; i < seat.size(); i++) {
			if (seat.get(i).getStudentNumber() == studentNumber) {
				seat.get(i).setMine(true);
			} //if
		} // for
		
		return seat;
	}
	
	@GetMapping("/signin")
	public String signIn() {
		
		return "home/signin";
	}
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("signin/check")
	public String signInCheck(UserDTO signInCheckDTO
			,RedirectAttributes attributes) {
		
		int rowCnt = 0;
		
		String password = signInCheckDTO.getStudentPassword();
		signInCheckDTO.setStudentPassword(this.passwordEncoder.encode(password));
		signInCheckDTO.setEnabled(true);
		
		System.out.println(signInCheckDTO.toString());
		rowCnt = this.loginRelatedService.signIn(signInCheckDTO);
		
		
		
		if (rowCnt == 1) {
			return "redirect:/?signIn=success";
		}
		return "redirect:/?signIn=fail";
	}
	
	@GetMapping("/login")
	public String logInPage() {
		return "home/login";
	}
	
	@PostMapping("/seat/reservation")
	public String seatReservation(
			Principal principal,
			@RequestParam("seatId") int seatId) {
		
		
		if (principal != null) {
			int studentNumber = Integer.parseInt(principal.getName());
			
			int rowCnt = this.seatReservationService.seatReservationService(studentNumber, seatId);
			
			return "redirect:/?reservation=success";
		}
		
		return "redirect:/?reservation=false";
	}
	
	@GetMapping("/seat")
	public String getSeatList(Model model, Principal principal){
		
		List<SeatDTO> seats = this.seatReservationService.getSeatList();
		if (principal != null) {
			seats = isMine(seats, Integer.parseInt(principal.getName()));
		} //if
		model.addAttribute("seats", seats);
		
		return "home/seatlist";
	}
	
}
