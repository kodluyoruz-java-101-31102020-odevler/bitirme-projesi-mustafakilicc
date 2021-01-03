package bitirme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bitirme.dao.BookRepository;
import bitirme.dao.BookRepositoryImpl;
import bitirme.entity.Book;
import bitirme.service.model.BookModel;

@Service
public class BookService implements IBookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookRepositoryImpl bookRepositoryImpl;

	@Transactional
	public List<Book> getAll() {
		return bookRepository.getAll();
	}

	@Transactional
	public List<Book> search(String value) {
		return bookRepository.search(value);
	}

	@Transactional
	public Book findByBookNo(Long bookNo) {
		return bookRepository.findByBookNo(bookNo);
	}

	@Transactional
	public Long save(BookModel bookmodel) {
		Book book = new Book();
		book.setTitle(bookmodel.getTitle());
		book.setExplanation(bookmodel.getExplanation());
		book.setNote(bookmodel.getNote());
		book.setYear(bookmodel.getYear());
		bookRepository.save(book);
		return (long) book.getId();
	}

	@Transactional
	public Long update(BookModel bookmodel) {
		Book book = bookRepository.findByBookNo((long) bookmodel.getId());
		if (book == null) {
			throw new RuntimeException(bookmodel.getId() + " ID not found in DB!");
		}

		book.setTitle(bookmodel.getTitle());
		book.setExplanation(bookmodel.getExplanation());
		book.setNote(bookmodel.getNote());
		book.setYear(bookmodel.getYear());
		bookRepository.save(book);
		return (long) book.getId();
	}

}
