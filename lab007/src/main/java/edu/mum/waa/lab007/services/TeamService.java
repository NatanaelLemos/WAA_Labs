package edu.mum.waa.lab007.services;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.waa.lab007.data.MatchRepository;
import edu.mum.waa.lab007.models.*;

@Service
public class TeamService {
	@Autowired
	private MatchRepository repository;

	public List<Team> getAll() {
		return repository.getAllTeams();
	}

	public Team get(int id) {
		return repository.getTeam(id);
	}

	public void add(Team team) {
		repository.addTeam(team);
	}
	
	public void edit(int id, Team team) {
		repository.editTeam(id, team);
	}

	public void delete(int id) {
		repository.deleteTeam(id);
	}
}
