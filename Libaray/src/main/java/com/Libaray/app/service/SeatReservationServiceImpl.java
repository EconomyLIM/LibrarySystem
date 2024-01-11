package com.Libaray.app.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Libaray.app.domain.SeatDTO;
import com.Libaray.app.exception.ErrorCode;
import com.Libaray.app.exception.SeatReservationException;
import com.Libaray.app.mapper.HomeMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class SeatReservationServiceImpl implements SeatReservationService{

	@Autowired
	private HomeMapper homeMapper;
	
	@Override
	@Transactional
	public List<SeatDTO> getSeatList() {
		// TODO Auto-generated method stub
		try {
			return this.homeMapper.getSeat();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public List<SeatDTO> getSeatHitory(int studentNumber) {
		log.info("SeatReservationServiceImpl getSeatHitory call_ studentNumber: "+ studentNumber);
		try {
			return this.homeMapper.getSeatHistory(studentNumber);
		} catch (ClassNotFoundException | SQLException e) {
			log.error("SeatReservationServiceImpl getSeatHitory error");
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	@Transactional
	public int seatReservationService(int studentNumber, int seatId) {
		
		return 1;
		// return this.homeMapper.seatReservation(studentNumber, seatId);
	}

	@Override
	@Transactional
	public int seatReturnService(int connectionseq, int studentNumber) {
		
		return this.homeMapper.seatReturn(connectionseq, studentNumber);
	}

	@Override
	@Transactional
	public int seatExtensionService(int connectionseq, int studentNumber) {
		
		return this.homeMapper.seatExtension(connectionseq, studentNumber);
	}

	@Override
	@Transactional
	public void exprireSeat() {
		List<String> connectionseq = this.homeMapper.getExpireseat();
		
		if (connectionseq.size() >= 1) {
			int rowCnt = this.homeMapper.expiredReservation(connectionseq);
		}
	} // exprireSeat

	@Override
	public int checkReservation(int studentNumber) {
		
		log.info("SeatReservationServiceImpl checkReservation call_ studentNumber : " + studentNumber);
		
		// return this.homeMapper.checkReservation(studentNumber);
		return 1;
	}

	
	@Override
	@Transactional
	public void seatReservation(Long studentNumber, int seatId) throws Exception {
		
		// 로그인을 했는지
		if (studentNumber == null) {
			throw new Exception();
		}
		
		// 그 자리에 예약이 있는지
		if (this.homeMapper.isSeatReservation(seatId) == 1) {
			throw new SeatReservationException("already reservation", ErrorCode.ALREADY_SEAT_RESERVATION);
		}
		
		// 로그인한 사람이 예약을 했는지
		if (this.homeMapper.checkReservation(studentNumber) == 1) {
			throw new SeatReservationException("already user reservation", ErrorCode.ALREADY_USER_SEAT_RESERVATION);
		}
		
		int seatReservationCnt = this.homeMapper.seatReservation(studentNumber, seatId);

	} // seatReservation

	

}
