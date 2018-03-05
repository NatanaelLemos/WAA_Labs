package edu.mum.waa.lab007.models;

import java.util.ArrayList;
import java.util.List;

public class Stadium {
	private int stadiumKey;
	private String name;
	private String city;
	private String state;
	private List<Match> matches;
	
	public Stadium() {
		matches = new ArrayList<Match>();
	}
}
