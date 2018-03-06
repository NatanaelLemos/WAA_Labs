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

import edu.mum.waa.lab007.models.Match;
import edu.mum.waa.lab007.services.MatchService;
import edu.mum.waa.lab007.services.StadiumService;
import edu.mum.waa.lab007.services.TeamService;

@Controller
public class MatchController {
	@Autowired private MatchService matchService;
	@Autowired private StadiumService stadiumService;
	@Autowired private TeamService teamService;
	
	@RequestMapping("/matches")
	public String matches(Model model) {
		model.addAttribute("matches", matchService.getAll());
		return "match/index";
	}
	
	@RequestMapping(value = "/matches/add", method = RequestMethod.GET)
	public String add(@ModelAttribute("match") Match match, Model model) {
		fillModel(model);
		return "match/add";
	}
	
	private void fillModel(Model model) {
		model.addAttribute("stadiums", stadiumService.getAll());
		model.addAttribute("teams", teamService.getAll());
	}
	
	@RequestMapping(value = "/matches/add", method = RequestMethod.POST)
	public String add(@Valid Match match, BindingResult result, Model model) {
		if(result.hasErrors()) {
			fillModel(model);
			return "match/add";
		}
		
		matchService.add(match);
		return "redirect:/matches";
	}
	
	@RequestMapping(value = "/matches/edit/{id}", method = RequestMethod.GET)
	public String edit(@ModelAttribute("match") Match match, @PathVariable int id, Model model) {
		fillModel(model);
		model.addAttribute("match", matchService.get(id));
		return "match/edit";
	}

	@RequestMapping(value = "/matches/edit/{id}", method = RequestMethod.POST)
	public String edit(@PathVariable int id, @Valid Match match, BindingResult result, Model model) {
		if (result.hasErrors()) {
			fillModel(model);
			return "match/edit";
		}
		
		matchService.edit(id, match);		
		return "redirect:/matches";
	}
	
	@RequestMapping(value = "/matches/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable int id) {
		matchService.delete(id);
		return "redirect:/matches";
	}
}
