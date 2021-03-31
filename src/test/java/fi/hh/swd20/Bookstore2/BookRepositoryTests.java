package fi.hh.swd20.Bookstore2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.hh.swd20.Bookstore2.domain.Book;
import fi.hh.swd20.Bookstore2.domain.BookRepository;
import fi.hh.swd20.Bookstore2.domain.Category;


@ExtendWith(SpringExtension.class)
@DataJpaTest

public class BookRepositoryTests {

	@Autowired
	private BookRepository brepository;
	
	
	Category b4 = new Category("humour");
	
	@Test // testataan BookRepositoryn save()-metodin toimivuutta
    public void addBook() {
    	Book book = new Book("Kirja1", "Kirjailija1", 2020, "9781471191414321", 12.00, b4);
    	brepository.save(book);
    	assertThat(book.getId()).isNotNull();
    } 
	
	@Test
	public void deleteBook() {
		Book book = new Book("Kirja1", "Kirjailija1", 2020, "9781471191414321", 12.00, b4);
    	brepository.save(book);
		brepository.deleteByAuthor("Kirjailija1");
		assertThat(book.getAuthor()).isNull();
	}
	
	@Test  // testataan BookRepositoryn findByAuthor()-metodin toimivuutta
    public void findByAuthorShouldReturnTitle() {
        List<Book> books = brepository.findByAuthor("Rupi Kaur");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Home body");
    }
	
	
}
