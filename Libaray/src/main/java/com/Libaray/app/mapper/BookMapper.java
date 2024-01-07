package com.Libaray.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.Libaray.app.domain.BookDTO;

public interface BookMapper {
	
	List<BookDTO> bookList();
	
	int decrease(@Param("bookId") int bookId, @Param("bookCount") int bookCount);
	
	BookDTO getBookDTO (@Param("bookId") int bookId);
	
	public int bookRent(@Param("studentNumber")int studentNumber, @Param("bookId") int bookId);

}
