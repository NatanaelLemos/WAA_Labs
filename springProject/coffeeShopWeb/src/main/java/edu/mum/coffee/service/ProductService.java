package edu.mum.coffee.service;

import org.springframework.stereotype.Service;
import edu.mum.coffee.domain.Product;

@Service
public class ProductService extends ServiceCommon<Product, Integer>  {
	public ProductService() {
		super("products", Product.class);
	}
}
