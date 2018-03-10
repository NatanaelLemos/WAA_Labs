package edu.mum.coffee.service;

import org.springframework.stereotype.Service;
import edu.mum.coffee.domain.Order;

@Service
public class OrderService extends ServiceCommon<Order, Integer> {

	public OrderService() {
		super("orders", Order.class);
	}

}