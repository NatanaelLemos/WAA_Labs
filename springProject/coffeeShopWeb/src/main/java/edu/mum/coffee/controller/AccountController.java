package edu.mum.coffee.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.coffee.domain.*;
import edu.mum.coffee.service.PersonService;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private PersonService service;
	
	@GetMapping({"/register"})
	public String register(@ModelAttribute("person") Person person) {
		return "account/register";
	}
	
	@PostMapping({"/register"})
	public String register(@Valid Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "account/register";
		}
		
		service.add(person);
		return "redirect:/login";
	}
}
