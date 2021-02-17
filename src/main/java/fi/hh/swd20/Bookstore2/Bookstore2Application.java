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
	 Book a = new Book("A farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 49.99);
	 Book b = new Book("Setting free the bears", "John Irwing", 1997, "978-0345417985", 35.45);
	 Book c = new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 39.99);
	 
	 repository.save(a);
	 repository.save(b);
	 repository.save(c);
	};
	}

}
