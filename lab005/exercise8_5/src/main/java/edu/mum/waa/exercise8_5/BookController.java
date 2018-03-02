package edu.mum.waa.exercise8_5;

import javax.validation.*;
import org.springframework.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bookStore")
public class BookController {

	@Autowired
	private IBookDao bookDao;
	
	@RequestMapping("")
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
	public String get(@ModelAttribute("book") Book book, @PathVariable int id, Model model) {
		model.addAttribute("bookAttribute", bookDao.get(id));
		return "bookDetail";
	}

	@RequestMapping(value = "/books/{id}", method = RequestMethod.POST)
	public String update(@PathVariable int id, @Valid Book book, BindingResult result) {
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
