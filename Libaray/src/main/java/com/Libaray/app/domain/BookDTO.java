package com.Libaray.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

	private int bookId;
	private String bookName;
	private String bookWriter;
	private int bookCount;
	//private int version;
	
}
