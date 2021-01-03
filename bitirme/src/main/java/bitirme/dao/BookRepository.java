package bitirme.dao;

import java.util.List;

import bitirme.entity.Book;



public interface BookRepository {
	
	public List<Book> getAll();	
	public List<Book> search(String value);	
	public Book findByBookNo(Long bookNo);
	public Book save(Book book);	
	public Book update(Book book);

}
