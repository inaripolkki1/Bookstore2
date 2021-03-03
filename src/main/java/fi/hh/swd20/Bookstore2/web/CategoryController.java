package fi.hh.swd20.Bookstore2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.hh.swd20.Bookstore2.domain.Category;
import fi.hh.swd20.Bookstore2.domain.CategoryRepository;
@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository crepository;
	@RequestMapping("/categorylist")
	public String categoryList(Model model) {
		model.addAttribute("categories", crepository.findAll());
		return "categorylist";
	}
	
	//lisää uusi kategoria
	@RequestMapping(value = "/create")
	public String CreateCategory(Model model) {
		model.addAttribute("category", new Category());
		return "CreateCategory";
	}
	
	//tallenna uusi kategoria
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String save(Category category) {
		crepository.save(category);
		return "redirect:categorylist";
	}

	
}
