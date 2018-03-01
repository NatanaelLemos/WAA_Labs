package cs544.exercise8;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bookStore")
public class BookController {

	@Resource
	private IBookDao bookDao;

	@RequestMapping("") // Redirect fixed
	public String redirectRoot() {
		return "redirect:/bookStore/books";
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("books", bookDao.getAll());
		return "bookList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(@ModelAttribute("book") Book book) {
		return "addBook";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "addBook";
		}

		bookDao.add(book);
		return "redirect:/bookStore/books";
	}

	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	public String get(@ModelAttribute("bookModel") Book bookModel, @PathVariable int id, Model model) {
		model.addAttribute("book", bookDao.get(id));
		return "bookDetail";
	}

	@RequestMapping(value = "/books/{id}", method = RequestMethod.POST)
	public String update(Book book, @PathVariable int id, BindingResult result) {
		if (result.hasErrors()) {
			return "bookDetail";
		}
		
		bookDao.update(id, book);
		return "redirect:/bookStore/books";
	}

	@RequestMapping(value = "/books/delete", method = RequestMethod.POST)
	public String delete(int bookId) {
		bookDao.delete(bookId);
		return "redirect:/bookStore/books";
	}

	@ExceptionHandler(value = NoSuchResourceException.class)
	public ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.getModel().put("e", e);
		mv.setViewName("noSuchResource");
		return mv;
	}
}
