package com.Libaray.app.repository.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Access(AccessType.FIELD)
@Data
@NoArgsConstructor
@Table(name = "stock")
public class Stock{

	@Id
	private Long id;
	
	@Column
	private int quantity;


	public Stock(Long id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}


	public void decrease(int quantity) {
		if (this.quantity - quantity < 0) {
			throw new RuntimeException("재고는 0개가 될 수 없습니다.");
		}
		
		this.quantity -= quantity;
	}
	
}
