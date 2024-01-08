package com.Libaray.app.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Libaray.app.domain.SeatDTO;
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
	@Transactional
	public int seatReservationService(int studentNumber, int seatId) {
		
		return this.homeMapper.seatReservation(studentNumber, seatId);
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
		
		return this.homeMapper.checkReservation(studentNumber);
	}

}
