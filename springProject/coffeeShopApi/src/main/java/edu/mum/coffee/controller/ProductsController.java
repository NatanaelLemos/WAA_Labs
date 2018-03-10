package edu.mum.coffee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.mum.coffee.domain.*;
import edu.mum.coffee.service.ProductService;
import edu.mum.coffee.service.ServiceAdapter;

@RestController
@RequestMapping("/products")
public class ProductsController extends ControllerCommon<Product, Integer> {
	
	public ProductsController(ProductService service) {
		super(new ServiceAdapter<Product, Integer>()
				.getAll(() -> service.getAllProduct())
				.getById((Integer id) -> service.getProduct(id))
				.add((Product p) -> { 
					service.save(p);
					return p;
				})
				.edit((Product p, Integer id) -> {
					p.setId(id);
					service.save(p);
					return p;
				})
				.delete((Integer id) -> {
					Product p = service.getProduct(id);
					service.delete(p);
				})
		);
	}
}
