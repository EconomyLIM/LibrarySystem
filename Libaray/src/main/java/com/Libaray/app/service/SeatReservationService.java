package com.Libaray.app.service;

import java.util.List;

import com.Libaray.app.domain.SeatDTO;

public interface SeatReservationService {
	
	List<SeatDTO> getSeatList();
	List<SeatDTO> getSeatHitory(int studentNumber);
	
	int seatReservationService(int studentNumber, int seatId);
	
	int seatReturnService(int connectionseq, int studentNumber);
	
	int seatExtensionService(int connectionseq, int studentNumber);

	void exprireSeat();
	
	int checkReservation(int studentNumber);
	
	void seatReservation(Long studentNumber, int seatId) throws Exception;
}
