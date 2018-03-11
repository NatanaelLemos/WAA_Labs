package edu.mum.coffee.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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

	public Person getByEmail(String email) {
		try {
			String url = getUri() + "getByEmail";
			return getClient().postForObject(url, email, getTType());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Person add(Person obj) {
		if (obj.isAdmin()) {
			return getClient().postForObject(getUri() + "admin", obj, getTType());
		} else {
			return super.add(obj);
		}
	}
}
