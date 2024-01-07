package com.Libaray.app.repository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Libaray.app.repository.StockRepository;
import com.Libaray.app.repository.domain.Stock;

@Service
public class PessimisticLockStockService {
	
	@Autowired
	private StockRepository stockRepository;
	
	public void decrease(Long id, int quantity) {
		Stock stock = stockRepository.findByWidhPessimisticLock(id);
		
		stock.decrease(quantity);
		
		stockRepository.saveAndFlush(stock);
	}

}// class
