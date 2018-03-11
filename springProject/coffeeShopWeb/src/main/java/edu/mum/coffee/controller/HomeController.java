package edu.mum.coffee.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;

	@GetMapping({ "/", "/index", "/home" })
	public String homePage(Model model) {
		populateModel(model);
		return "home/index";
	}

	private void populateModel(Model model) {

		Product featured = null;
		List<Product> products = productService.getAll();
		model.addAttribute("products", products);

		if (products.size() > 0) {
			Random randFeatured = new Random();
			int n = randFeatured.nextInt(products.size());
			featured = products.get(n);
		}
		
		model.addAttribute("featured", featured);
	}

	@GetMapping({ "/secure" })
	public String securePage() {
		return "home/secure";
	}
}
