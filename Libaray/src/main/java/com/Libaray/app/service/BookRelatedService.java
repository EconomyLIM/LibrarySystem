package com.Libaray.app.service;

import java.util.List;

import com.Libaray.app.domain.BookDTO;

public interface BookRelatedService {

	List<BookDTO> booklistService();
	
	// Test용 서비스
	int decrease (int bookId);
	
	BookDTO getBookDTOService (int bookId);
	
	int bookRentService(int studentNumber, int bookId);
}
