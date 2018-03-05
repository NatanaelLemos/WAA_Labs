package edu.mum.waa.lab007.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.waa.lab007.services.TeamService;

@Controller
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@RequestMapping("/teams")
	public String teams() {
		return "team/index";
	}
}
