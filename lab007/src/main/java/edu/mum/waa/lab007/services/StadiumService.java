package edu.mum.waa.lab007.services;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.waa.lab007.data.MatchRepository;
import edu.mum.waa.lab007.models.*;

@Service
public class StadiumService {
	@Autowired
	private MatchRepository repository;

	public List<Stadium> getAll() {
		return repository.getAllStadiums();
	}

	public Stadium get(int id) {
		return repository.getStadium(id);
	}

	public void add(Stadium team) {
		repository.addStadium(team);
	}
	
	public void edit(int id, Stadium team) {
		repository.editStadium(id, team);
	}

	public void delete(int id) {
		repository.deleteStadium(id);
	}
}
