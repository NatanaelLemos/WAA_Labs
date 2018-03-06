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

import edu.mum.waa.lab007.models.Team;
import edu.mum.waa.lab007.services.TeamService;

@Controller
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@RequestMapping("/teams")
	public String teams(Model model) {
		model.addAttribute("teams", teamService.getAll());
		return "team/index";
	}
	
	@RequestMapping(value = "/teams/add", method = RequestMethod.GET)
	public String add(@ModelAttribute("team") Team team) {
		return "team/add";
	}
	
	@RequestMapping(value = "/teams/add", method = RequestMethod.POST)
	public String add(@Valid Team team, BindingResult result) {
		if(result.hasErrors()) {
			return "team/add";
		}
		
		teamService.add(team);
		return "redirect:/teams";
	}
	
	@RequestMapping(value = "/teams/edit/{id}", method = RequestMethod.GET)
	public String edit(@ModelAttribute("team") Team team, @PathVariable int id, Model model) {
		model.addAttribute("team", teamService.get(id));
		return "team/edit";
	}

	@RequestMapping(value = "/teams/edit/{id}", method = RequestMethod.POST)
	public String edit(@PathVariable int id, @Valid Team team, BindingResult result) {
		if (result.hasErrors()) {
			return "team/edit";
		}
		
		teamService.edit(id, team);		
		return "redirect:/teams";
	}
	
	@RequestMapping(value = "/teams/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable int id) {
		teamService.delete(id);
		return "redirect:/teams";
	}
}
