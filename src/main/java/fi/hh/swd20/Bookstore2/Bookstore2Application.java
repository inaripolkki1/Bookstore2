package fi.hh.swd20.Bookstore2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.swd20.Bookstore2.domain.Book;
import fi.hh.swd20.Bookstore2.domain.BookRepository;

@SpringBootApplication
public class Bookstore2Application {

	public static void main(String[] args) {
		SpringApplication.run(Bookstore2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
	 Book a = new Book("Home body", "Rupi Kaur", 2020, "9781471196720", 15.95);
	 Book b = new Book("Setting free the bears", "John Irwing", 1997, "978-0345417985", 35.45);
	 Book c = new Book("The lost spells", "Robert Macfarlanee", 2020, "9780241444641", 27.95);
	 
	 repository.save(a);
	 repository.save(b);
	 repository.save(c);
	};
	}

}
