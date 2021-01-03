package bitirme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bitirme.entity.Book;
import bitirme.service.BookService;


@RestController
@RequestMapping("/library")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public Book findByEmpNo(@PathVariable("id") Long id) {
		
		return bookService.findByBookNo(id);
	}

	@RequestMapping(value="/book/list", method=RequestMethod.GET)
	public List<Book> getAllBook(){
		
		return bookService.getAll();
	}
}
