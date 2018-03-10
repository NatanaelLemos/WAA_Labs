package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.mum.coffee.domain.*;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ServiceAdapter;

@RestController
@RequestMapping("/people")
public class PeopleController extends ControllerCommon<Person, Long> {
	
	private PersonService service;
	
	public PeopleController(PersonService service) {
		super(new ServiceAdapter<Person, Long>()
				.getAll(() -> service.getAllPeople())
				.getById((Long id) -> service.findById(id))
				.add((Person p) -> { 
					service.savePerson(p);
					return p;
				})
				.edit((Person p, Long id) -> {
					p.setId(id);
					service.savePerson(p);
					return p;
				})
				.delete((Long id) -> {
					Person p = service.findById(id);
					service.removePerson(p);
				})
		);
		
		this.service = service;
	}
	
	@PostMapping({"/login"})
	public Person login(@RequestBody Person user) {
		List<Person> personDb = service.findByEmail(user.getEmail());
		return personDb.stream().filter(p -> p.getPassword().equals(user.getPassword())).findFirst().orElse(null);
	}
}
