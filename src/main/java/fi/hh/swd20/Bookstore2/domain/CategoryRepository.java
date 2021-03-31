package fi.hh.swd20.Bookstore2.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	List<Category> findByCategory(String Category);

	List<Category> deleteByName(String Name);

}
