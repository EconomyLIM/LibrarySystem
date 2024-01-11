package com.Libaray.app;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.Libaray.app.repository.StockRepository;
import com.Libaray.app.repository.domain.Stock;
import com.Libaray.app.repository.service.PessimisticLockStockService;
import com.Libaray.app.repository.service.StockService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class StockServiceTest {
	
	@Autowired
	private PessimisticLockStockService stockService;
	
	@PersistenceContext
	private EntityManager entityManager;
	
//	@Before
//	public void before() {
//		stockRepository.saveAndFlush(new Stock(1L, 100));
//	}
	
//	@After
//	public void after() {
//		stockRepository.deleteAll();
//	}
	


//	@Test
//	public void decrease() throws InterruptedException {
//		int threadCount = 100;
//        ExecutorService executorService = Executors.newFixedThreadPool(32);
//        CountDownLatch latch = new CountDownLatch(threadCount);
//
//        for (int i = 0; i < threadCount; i++) {
//            executorService.submit(() -> {
//                try {
//                    stockService.decrease(1L, 1);
//                } finally {
//                    latch.countDown();
//                }
//            });
//        }
//
//        latch.await();
//
//        Stock stock = entityManager.find(Stock.class, 1L);
//
//        // 100 - (100 * 1) = 0
//        assertEquals(0, stock.getQuantity());
//	}
	
	@Test
	public void decrease() throws InterruptedException {
	    int threadCount = 100;
	    ExecutorService executorService = Executors.newFixedThreadPool(32);
	    CountDownLatch latch = new CountDownLatch(threadCount);

	    for (int i = 0; i < threadCount; i++) {
	        executorService.submit(() -> {
	            try {
	                Stock stock = entityManager.find(Stock.class, 1L);
	                stockService.decrease(stock.getId(), 1);
	            } finally {
	                latch.countDown();
	            }
	        });
	    }

	    latch.await();

	    Stock stock = entityManager.find(Stock.class, 1L);

	    System.err.println(stock.getId());
	    System.err.println(stock.getQuantity());
	    // 100 - (100 * 1) = 0
	    assertEquals(0, stock.getQuantity());
	}


}
