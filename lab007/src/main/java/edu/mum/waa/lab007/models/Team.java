package edu.mum.waa.lab007.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Team {
	private int teamKey;
	private String name;
	private String city;
	private String mascot;
	private List<String> players;
	private String homeUniform;
	private String visitUniform;
	private List<Match> matchesAsHome;
	private List<Match> matchesAsVisitor;
	
	public Team() {
		players = new ArrayList<String>();
		matchesAsHome = new ArrayList<Match>();
		matchesAsVisitor = new ArrayList<Match>();
	}

	public Team(int key, String name, String city, String mascot, String homeUniform, String visitUniform) {
		this.setTeamKey(key);
		this.setName(name);
		this.setCity(city);
		this.setMascot(mascot);
		this.setHomeUniform(homeUniform);
		this.setVisitUniform(visitUniform);
	}
	
	public int getTeamKey() { return this.teamKey; }
	public void setTeamKey(int key) { this.teamKey = key; }
	
	@NotNull
	@NotBlank
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }

	@NotNull
	@NotBlank
	public String getCity() { return this.city; }
	public void setCity(String city) { this.city = city; }

	@NotNull
	@NotBlank
	public String getMascot() { return this.mascot; }
	public void setMascot(String mascot) { this.mascot = mascot; }

	@NotNull
	@NotBlank
	public String getHomeUniform() { return this.homeUniform; }
	public void setHomeUniform(String homeUniform) { this.homeUniform = homeUniform; }

	@NotNull
	@NotBlank
	public String getVisitUniform() { return this.visitUniform; }
	public void setVisitUniform(String visitUniform) { this.visitUniform = visitUniform; }
}
