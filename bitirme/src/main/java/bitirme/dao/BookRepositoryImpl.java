package bitirme.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bitirme.entity.Book;

@Repository("bookDao")
public class BookRepositoryImpl implements BookRepository {

	private EntityManager entityManager;

	@Autowired
	public BookRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Book> getAll() {

		Session session = entityManager.unwrap(Session.class);

		Query<Book> query = session.createQuery("SELECT book FROM Book book", Book.class);
		List<Book> result = query.getResultList();

		return result;
	}

	public List<Book> search(String value) {

		Session session = entityManager.unwrap(Session.class);

		Query<Book> query = session.createQuery("SELECT * FROM Book WHERE title LIKE :value", Book.class);
		query.setParameter("value", value);
		List<Book> result = query.getResultList();

		return result;
	}

	public Book findByBookNo(Long bookNo) {
		Session session = entityManager.unwrap(Session.class);
		Query<Book> query = session.createQuery("select * from Book where bookNo=: bookId", Book.class);
		query.setParameter("bookId", bookNo);
		Book book = query.getSingleResult();

		return book;
	}

	public Book save(Book book) {
		Session session = entityManager.unwrap(Session.class);
		session.save(book);
		return book;
	}

	public Book update(Book book) {
		Session session = entityManager.unwrap(Session.class);
		session.update(book);
		return book;
	}

}
