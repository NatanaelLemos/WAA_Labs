package edu.mum.waa.lab007.models;

import java.util.ArrayList;
import java.util.List;

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
}
