package com.Libaray.app.repository.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Libaray.app.repository.StockRepository;
import com.Libaray.app.repository.domain.Stock;

@Service
public class PessimisticLockStockService {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void decrease(Long id, int quantity) {
        try {
            Stock stock = entityManager.find(Stock.class, id);
            stock.decrease(quantity);
            entityManager.flush();
            entityManager.clear();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}

