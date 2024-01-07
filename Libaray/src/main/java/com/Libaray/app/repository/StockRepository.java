package com.Libaray.app.repository;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import com.Libaray.app.repository.domain.Stock;

public interface StockRepository extends org.springframework.data.jpa.repository.JpaRepository<Stock, Long>{

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select s from Stock s where s.id = :id")
	Stock findByWidhPessimisticLock(Long id);
}
