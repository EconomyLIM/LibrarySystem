package com.Libaray.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.Libaray.app.service.SeatReservationService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class SeatReservationTest {

	@Autowired
	SeatReservationService seatReservationService;
	
	@Test
	public void test() {


		int studentNumber = 7;
		int seatId = 1;
		
		int rowCnt = this.seatReservationService.seatReservationService(studentNumber, seatId);
		
		assertEquals(1, rowCnt);
	}

}
