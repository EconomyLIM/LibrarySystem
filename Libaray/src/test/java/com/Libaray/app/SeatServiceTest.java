package com.Libaray.app;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.Libaray.app.domain.SeatDTO;
import com.Libaray.app.mapper.HomeMapper;
import com.Libaray.app.service.SeatReservationService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class SeatServiceTest {

	@Autowired
	private HomeMapper homeMapper;
	
	@Autowired
	private SeatReservationService reservationService;
	
	@Test
	public void test() throws Exception {

		Long studentNumber = 5L;
		int seatId = 1;
		
		this.reservationService.seatReservation(studentNumber, seatId);
		

	}
	
}

