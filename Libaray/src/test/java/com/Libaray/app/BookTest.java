package com.Libaray.app;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
public class BookTest {

	@Autowired
	BookRelatedService bookRelatedService;
	
//	@Test
//	public void test() {
//
//		//System.out.println(this.bookRelatedService.booklistService().toString());
//		
//		System.out.println(this.bookRelatedService.getBookDTOService(1));
//		
//	}
	
//	@Before
//	public void before() {
//		
//	}
	
	@Test
	public void decreaseTest() throws InterruptedException {
		
		int threadCount = 100; // 쓰레스 수 설정
		ExecutorService executorService = Executors.newFixedThreadPool(32);
		// 100개의 요청이 끝날때 까지 기다려야 하므로
		CountDownLatch latch = new CountDownLatch(threadCount);
		
		int bookId = 1;
		
		for (int i = 0; i < threadCount; i++) {
			executorService.submit(() -> {
				try {
					int rowCnt = this.bookRelatedService.decrease(bookId);
				} finally {
					latch.countDown();
				} // try finally
			});
		} //for
		
		latch.await();
		
		BookDTO bookDTO = this.bookRelatedService.getBookDTOService(bookId);
		assertEquals(0, bookDTO.getBookCount());
		
	} // decreaseTest
	

	/*
	@Test
	public void decreaseTest() throws InterruptedException {
	    int threadCount = 100;
	    ExecutorService executorService = Executors.newFixedThreadPool(32);
	    CountDownLatch latch = new CountDownLatch(threadCount);

	    int bookId = 1;

	    List<Future<Integer>> futures = new ArrayList<>();

	    for (int i = 0; i < threadCount; i++) {
	        Future<Integer> future = executorService.submit(() -> {
	            int rowCnt = this.bookRelatedService.decrease(bookId);
	            return rowCnt;
	        });

	        futures.add(future);
	    }

	    // 모든 스레드의 작업이 완료될 때까지 대기
	    for (Future<Integer> future : futures) {
	        try {
	            future.get();
	        } catch (ExecutionException e) {
	            // 예외 처리
	            e.printStackTrace();
	        }
	    }

	    // 마지막에 대기
	    latch.await();

	    // 모든 스레드의 결과 확인
	    BookDTO bookDTO = this.bookRelatedService.getBookDTOService(bookId);
	    assertEquals(0, bookDTO.getBookCount());
	}
	*/
}
