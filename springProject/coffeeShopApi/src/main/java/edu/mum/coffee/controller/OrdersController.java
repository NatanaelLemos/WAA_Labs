package edu.mum.coffee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.mum.coffee.domain.*;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.ServiceAdapter;

@RestController
@RequestMapping("/orders")
public class OrdersController extends ControllerCommon<Order, Integer> {
	
	public OrdersController(OrderService service) {
		super(new ServiceAdapter<Order, Integer>()
				.getAll(() -> service.findAll())
				.getById((Integer id) -> service.findById(id))
				.add((Order p) -> { 
					service.save(p);
					return p;
				})
				.edit((Order p, Integer id) -> {
					p.setId(id);
					service.save(p);
					return p;
				})
				.delete((Integer id) -> {
					Order o = service.findById(id);
					service.delete(o);
				})
		);
	}
}
