package com.Libaray.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Libaray.app.domain.BookDTO;
import com.Libaray.app.service.BookRelatedService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookRelatedService bookRelatedService;
	
	@GetMapping
	public String bookList(Model model) {
		
		List<BookDTO> booklist = this.bookRelatedService.booklistService();
		model.addAttribute("booklist", booklist);
		
		return "book.booklist";
	}

}
