package fi.hh.swd20.Bookstore2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.hh.swd20.Bookstore2.domain.Category;
import fi.hh.swd20.Bookstore2.domain.CategoryRepository;
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTests {
	
	@Autowired
	private CategoryRepository crepository;
	
	Category b4 = new Category("humour");
	
	@Test // testataan CategoryRepositoryn savecategory()-metodin toimivuutta
    public void CreateCategory() {
    	Category category = new Category("Humour");
    	crepository.save(category);
    	assertThat(category.getId()).isNotNull();
    } 
	
	@Test
	public void deleteCategory() {
		Category category = new Category("Humour");
    	crepository.save(category);
		crepository.deleteByName("Humour");
		assertThat(category.getName()).isNull();
	}
	
	@Test  // testataan CategoryRepositoryn findByCategory()-metodin toimivuutta
    public void findByCategoryShouldReturnId() {
		List<Category> categories = crepository.findByCategory("Horror");
	
        assertThat(categories).hasSize(1);
    }
}
