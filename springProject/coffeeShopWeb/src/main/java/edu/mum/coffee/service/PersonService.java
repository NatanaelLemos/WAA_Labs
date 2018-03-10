package edu.mum.coffee.service;

import org.springframework.stereotype.Service;
import edu.mum.coffee.domain.Person;

@Service
public class PersonService extends ServiceCommon<Person, Long> {
	public PersonService() {
		super("people", Person.class);
	}

	public Person login(String email, String password) {
		String url = getUri() + "login/";
		Person p = new Person();
		p.setEmail(email);
		p.setPassword(password);
		
		return getClient().postForObject(url, p, getTType());
	}
}
