package com.Libaray.app.service;

import java.util.List;

import com.Libaray.app.domain.SeatDTO;

public interface SeatReservationService {
	
	List<SeatDTO> getSeatList();
	
	int seatReservationService(int studentNumber, int seatId);
	
	int seatReturnService(int connectionseq, int studentNumber);
	
	int seatExtensionService(int connectionseq, int studentNumber);

	void exprireSeat();
}
