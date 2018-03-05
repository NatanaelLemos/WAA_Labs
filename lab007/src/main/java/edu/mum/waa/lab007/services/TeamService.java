package edu.mum.waa.lab007.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.waa.lab007.data.MatchRepository;

@Service
public class TeamService {
	@Autowired
	private MatchRepository repository;
}
