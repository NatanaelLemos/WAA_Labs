package edu.mum.waa.lab007.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.waa.lab007.models.Stadium;
import edu.mum.waa.lab007.services.StadiumService;

@Controller
public class StadiumController {
	
	@Autowired
	private StadiumService stadiumService;
	
	@RequestMapping("/stadiums")
	public String stadiums(Model model) {
		model.addAttribute("stadiums", stadiumService.getAll());
		return "stadium/index";
	}
	
	@RequestMapping(value = "/stadiums/add", method = RequestMethod.GET)
	public String add(@ModelAttribute("stadium") Stadium stadium) {
		return "stadium/add";
	}
	
	@RequestMapping(value = "/stadiums/add", method = RequestMethod.POST)
	public String add(@Valid Stadium stadium, BindingResult result) {
		if(result.hasErrors()) {
			return "stadium/add";
		}
		
		stadiumService.add(stadium);
		return "redirect:/stadiums";
	}
	
	@RequestMapping(value = "/stadiums/edit/{id}", method = RequestMethod.GET)
	public String edit(@ModelAttribute("stadium") Stadium stadium, @PathVariable int id, Model model) {
		model.addAttribute("stadium", stadiumService.get(id));
		return "stadium/edit";
	}

	@RequestMapping(value = "/stadiums/edit/{id}", method = RequestMethod.POST)
	public String edit(@PathVariable int id, @Valid Stadium stadium, BindingResult result) {
		if (result.hasErrors()) {
			return "stadium/edit";
		}
		
		stadiumService.edit(id, stadium);		
		return "redirect:/stadiums";
	}
	
	@RequestMapping(value = "/stadiums/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable int id) {
		stadiumService.delete(id);
		return "redirect:/stadiums";
	}
}
