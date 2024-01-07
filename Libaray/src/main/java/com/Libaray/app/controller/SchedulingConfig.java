//package com.Libaray.app.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import com.Libaray.app.service.SeatReservationService;
//
//@Configuration
//@EnableScheduling
//public class SchedulingConfig {
//
//	@Autowired
//	private SeatReservationService reservationService;
//	
//	@Scheduled(cron = "0 * * * * *")
//	public void ExpiredReservation() {
//		this.reservationService.exprireSeat();
//		System.out.println("업데이트 완료");
//	}
//}
