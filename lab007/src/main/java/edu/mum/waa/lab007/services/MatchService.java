
package edu.mum.waa.lab007.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.waa.lab007.data.MatchRepository;
import edu.mum.waa.lab007.models.*;

@Service
public class MatchService {

	@Autowired
	private MatchRepository repository;

	public List<Match> getAll() {
		return repository.getAllMatches();
	}

	public Match get(int id) {
		return repository.getMatch(id);
	}

	public void add(Match match) {
		
		repository.addMatch(match);
	}
	
	public void edit(int id, Match team) {
		repository.editMatch(id, team);
	}

	public void delete(int id) {
		repository.deleteMatch(id);
	}
}
