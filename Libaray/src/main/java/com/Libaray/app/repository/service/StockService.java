package com.Libaray.app.repository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Libaray.app.repository.StockRepository;
import com.Libaray.app.repository.domain.Stock;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	
	@Transactional
	public void decrease(Long id, int quantity) {
		
		
		Stock stock = stockRepository.findById(id).orElseThrow();
		stock.decrease(quantity);
		
		stockRepository.saveAndFlush(stock);
	}
}
