package fi.hh.swd20.Bookstore2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.hh.swd20.Bookstore2.web.BookController;
import fi.hh.swd20.Bookstore2.web.CategoryController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class Bookstore2ApplicationTests {
	
	@Autowired
	private BookController bookController;

	@Autowired
	private CategoryController categoryController;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
		assertThat(categoryController).isNotNull();
	}
	
}
