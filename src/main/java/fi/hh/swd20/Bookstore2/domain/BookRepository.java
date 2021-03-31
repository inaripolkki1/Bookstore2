package fi.hh.swd20.Bookstore2.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findByAuthor(String Author);

	List<Book> deleteByAuthor(String Author);

}
