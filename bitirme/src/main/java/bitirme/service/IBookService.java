package bitirme.service;

import java.util.List;

import bitirme.entity.Book;
import bitirme.service.model.BookModel;

public interface IBookService {
	
	public List<Book> getAll();	
	public List<Book> search(String value);	
	public Book findByBookNo(Long bookNo);
	public Long save(BookModel book);	
	public Long update(BookModel book);

}
