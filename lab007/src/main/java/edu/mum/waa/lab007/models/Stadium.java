package edu.mum.waa.lab007.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Stadium {

	private int stadiumKey;
	private String name;
	private String city;
	private String state;
	private List<Match> matches;
	
	public Stadium() {
		matches = new ArrayList<Match>();
	}
	
	public Stadium(int id, String name, String city, String state) {
		this.setStadiumKey(id);
		this.setName(name);
		this.setCity(city);
		this.setState(state);
	}
	
	public int getStadiumKey() { return stadiumKey; }
	public void setStadiumKey(int stadiumKey) { this.stadiumKey = stadiumKey; }

	@NotNull
	@NotBlank
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	@NotNull
	@NotBlank
	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }

	@NotNull
	@NotBlank
	public String getState() { return state; }
	public void setState(String state) { this.state = state; }

	public List<Match> getMatches() { return matches; }
	public void setMatches(List<Match> matches) { this.matches = matches; }
}
