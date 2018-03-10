package edu.mum.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@GetMapping({"/"})
	public String list() {
		return "cart/index";
	}
	
	@GetMapping({"/add/{id}"})
	public String add(@PathVariable int id, Model model) {
		return "redirect:/";
	}
}
