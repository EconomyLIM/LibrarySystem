package com.Libaray.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.Libaray.app.domain.BookDTO;
import com.Libaray.app.mapper.BookMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BookRelatedServiceImpl implements BookRelatedService {

	@Autowired
	BookMapper bookMapper;
	
	@Override
	public List<BookDTO> booklistService() {
		
		return this.bookMapper.bookList();
	}

	@Override
	@Transactional
	public int decrease(int bookId) {
		
		log.info("BookRelatedServiceImpl decrease call...bookId="+bookId);
		BookDTO bookDTO = this.bookMapper.getBookDTO(bookId);
		//int bookCount = this.bookMapper.getBookDTO(bookId).getBookCount();
		
		int bookCount = bookDTO.getBookCount();
		//int version = bookDTO.getVersion();
		
		bookCount = bookCount -1;
		if (bookCount < 0) {
			new RuntimeException("재고는 0이 될 수 없습니다.");
		}
		
		int decreaseCnt = this.bookMapper.decrease(bookId, bookCount);
		
		return decreaseCnt;
	}

	@Override
	public BookDTO getBookDTOService(int bookId) {
		// TODO Auto-generated method stub
		return this.bookMapper.getBookDTO(bookId);
	}

	@Override
	public int bookRentService(int studentNumber, int bookId) {
		int bookCount = this.bookMapper.getBookDTO(bookId).getBookCount();
		
		bookCount = bookCount -1;
		if (bookCount < 0) {
			new RuntimeException("재고는 0이 될 수 없습니다.");
		}
		
		int decreaseCnt = this.bookMapper.decrease(bookId, bookCount);
		int connectionCnt = this.bookMapper.bookRent(studentNumber, bookId);
		
		return decreaseCnt + connectionCnt;
		
	}

}
