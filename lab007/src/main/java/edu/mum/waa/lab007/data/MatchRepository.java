package edu.mum.waa.lab007.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import edu.mum.waa.lab007.models.*;

@Repository
public class MatchRepository {
	private static Map<Integer, Team> teams;
	private static Map<Integer, Stadium> stadiums;
	private static Map<Integer, Match> matches;

	public MatchRepository() {
		if (teams == null) {
			teams = new HashMap<Integer, Team>();
			teams.put(1, new Team(1, "Team 1", "Here", "Super Cow", "White", "Black"));
			teams.put(2, new Team(2, "Team 2", "There", "Atomic Chicken", "Yellow", "Brown"));
		}
		
		if(stadiums == null) {
			stadiums = new HashMap<Integer, Stadium>();
			stadiums.put(1, new Stadium(1, "Stadium 1", "City", "ST"));
			stadiums.put(2, new Stadium(2, "Stadium 2", "City", "ST"));
		}
		
		if(matches == null) {
			matches = new HashMap<Integer, Match>();
		}
	}

	public List<Team> getAllTeams() {
		return new ArrayList<Team>(teams.values());
	}

	public Team getTeam(int id) {
		return teams.get(id);
	}

	public void addTeam(Team team) {
		synchronized(this) {
			Integer lastId = teams.keySet().stream().sorted(Comparator.reverseOrder()).findFirst().orElse(0);
			team.setTeamKey(lastId + 1);
		}
		
		teams.put(team.getTeamKey(), team);
	}

	public void editTeam(int id, Team team) {
		team.setTeamKey(id);
		teams.put(id, team);
	}

	public void deleteTeam(int id) {
		teams.remove(id);
	}
	


	public List<Stadium> getAllStadiums() {
		return new ArrayList<Stadium>(stadiums.values());
	}

	public Stadium getStadium(int id) {
		return stadiums.get(id);
	}

	public void addStadium(Stadium stadium) {
		synchronized(this) {
			Integer lastId = stadiums.keySet().stream().sorted(Comparator.reverseOrder()).findFirst().orElse(0);
			stadium.setStadiumKey(lastId + 1);
		}
		
		stadiums.put(stadium.getStadiumKey(), stadium);
	}

	public void editStadium(int id, Stadium stadium) {
		stadium.setStadiumKey(id);
		stadiums.put(id, stadium);
	}

	public void deleteStadium(int id) {
		stadiums.remove(id);
	}
	


	public List<Match> getAllMatches() {
		return new ArrayList<Match>(matches.values());
	}

	public Match getMatch(int id) {
		return matches.get(id);
	}

	public void addMatch(Match match) {
		
		synchronized(this) {
			Integer lastId = matches.keySet().stream().sorted(Comparator.reverseOrder()).findFirst().orElse(0);
			match.setMatchKey(lastId + 1);
		}

		match.setStadium(stadiums.get(match.getStadiumKey()));
		match.setHomeTeam(teams.get(match.getHomeTeamKey()));
		match.setVisitorTeam(teams.get(match.getVisitorTeamKey()));
		
		matches.put(match.getMatchKey(), match);
	}

	public void editMatch(int id, Match match) {
		match.setMatchKey(id);
		matches.put(id, match);
	}

	public void deleteMatch(int id) {
		matches.remove(id);
	}

}
