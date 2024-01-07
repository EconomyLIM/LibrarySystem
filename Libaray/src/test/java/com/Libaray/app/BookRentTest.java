package com.Libaray.app;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.Libaray.app.domain.BookDTO;
import com.Libaray.app.service.BookRelatedService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class BookRentTest {

	@Autowired
	BookRelatedService bookRelatedService;
	
	@Test
	public void bookrent() {
		
		int studentNumber = 5;
		int bookId = 17;
		int rowCnt = this.bookRelatedService.bookRentService(studentNumber, bookId);
		
		assertEquals(2, rowCnt);
	}

}
