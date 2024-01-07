package com.Libaray.app;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
	
	@Autowired
	private StockRepository stockRepository;
	
	@Before
	public void before() {
		stockRepository.saveAndFlush(new Stock(1L, 100));
	}
	
//	@After
//	public void after() {
//		stockRepository.deleteAll();
//	}

	@Test
	public void decrease() throws InterruptedException {
		int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                try {
                    stockService.decrease(1L, 1);
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();

        Stock stock = stockRepository.findById(1L).orElseThrow();

        // 100 - (100 * 1) = 0
        assertEquals(0, stock.getQuantity());
	}

}
