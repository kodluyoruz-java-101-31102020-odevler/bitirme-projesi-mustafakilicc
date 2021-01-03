package bitirme.ui.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bitirme.entity.Book;
import bitirme.service.BookService;
import bitirme.service.model.BookModel;



@Controller
@RequestMapping("/pages")
public class PageController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public String getBooks(Model model) {
		
		List<Book> books = bookService.getAll();
		
		model.addAttribute("books", books);
		
		return "thyme_book_list";
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String getBookSavePage(BookModel bookModel) {
		
		return "thyme_book_save";
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
    public String save(BookModel bookModel, BindingResult result, Model model) {
        
		//bookModel.setBirthDate(new Date());
		//bookModel.setHireDate(new Date());
		
		bookService.save(bookModel);
        
		model.addAttribute("books", bookService.getAll());
        
        return "thyme_book_list";
    }
	
	@RequestMapping(value = "/book/list", method = RequestMethod.POST)
    public String search(BookModel book_Model, BindingResult result, Model model) {
        
		//bookModel.setBirthDate(new Date());
		//bookModel.setHireDate(new Date());
		
		//bookService.search(book_Model.getTitle());
        
		model.addAttribute("books", bookService.getAll());
        
        return "thyme_book_list";
    }
	
}
