package fi.hh.swd20.Bookstore2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.swd20.Bookstore2.domain.Book;
import fi.hh.swd20.Bookstore2.domain.BookRepository;
import fi.hh.swd20.Bookstore2.domain.Category;
import fi.hh.swd20.Bookstore2.domain.CategoryRepository;
import fi.hh.swd20.Bookstore2.domain.User;
import fi.hh.swd20.Bookstore2.domain.UserRepository;

@SpringBootApplication
public class Bookstore2Application {

	public static void main(String[] args) {
		SpringApplication.run(Bookstore2Application.class, args);
	}
	private static final Logger log = LoggerFactory.getLogger(Bookstore2Application.class);
	
	@Bean
	public CommandLineRunner demo(CategoryRepository crepository, BookRepository brepository, UserRepository urepository) {
	return (args) -> {
		
		// Create users: admin/admin user/user
		User user1 = new User("user", "$2a$10$D6XoktdshEWeNzPgqBXobuvoWp9nhQzN8DnW/Kp064fUbSLEtxnQ2", "USER", "user@user.com");
		User user2 = new User("admin","$2a$10$FLMjZo.xsWYbWIX/WKRcvumZ6ITgebKjpIqH5b7ro/OT8NijkLCca", "ADMIN", "admin@admin.com");
		urepository.save(user1);
		urepository.save(user2);

	 Category b1 = new Category("Romance");
	 Category b2 = new Category("Science fiction");
	 Category b3 = new Category("Drama");
	 
	 crepository.save(b1);
	 crepository.save(b2);
	 crepository.save(b3);
	 
	 Book a1 = new Book("Home body", "Rupi Kaur", 2020, "9781471196720", 15.95, b1);
	 Book a2 = new Book("Setting free the bears", "John Irwing", 1997, "978-0345417985", 35.45, b3);
	 Book a3 = new Book("The lost spells", "Robert Macfarlane", 2020, "9780241444641", 27.95, b2);
	 
	 brepository.save(a1);
	 brepository.save(a2);
	 brepository.save(a3);
		
		log.info("Fetch all the books");
		for (Book book : brepository.findAll()) {
		   log.info(book.toString());
		}

		
		log.info("Fetch all the categories");
		for (Category category : crepository.findAll()) {
		   log.info(category.toString());
		}
	};
	}
	
	

}
