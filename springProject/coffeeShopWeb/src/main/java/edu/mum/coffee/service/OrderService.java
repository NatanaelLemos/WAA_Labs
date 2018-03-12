package edu.mum.coffee.service;

import java.util.List;

import org.springframework.stereotype.Service;
import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Person;

@Service
public class OrderService extends ServiceCommon<Order, Integer> {

	public OrderService() {
		super("orders", Order.class);
	}

	public List<Order> findByPerson(Person p) {
		String url = getUri() + "getByPerson/" + Long.toString(p.getId());
		return fixedList(getClient().getForObject(url, List.class));
	}
}