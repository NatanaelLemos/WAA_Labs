package edu.mum.cs545;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import edu.mum.cs545.model.Order;
import edu.mum.cs545.model.Pizza;

@Named
@ApplicationScoped
public class PizzaOrderHelper {

		
	public List<String> getPizzaList() {
		List<String> pizzaList = new ArrayList<String>();
		pizzaList.add("NY Cheese Pizza");
		pizzaList.add("Indian Spicy Pizza");
		pizzaList.add("Italian Special Pizza");

		return pizzaList;
	}

	public void addPizza(Order order, Pizza pizza) {
		Pizza p = new Pizza(pizza);
		pizza.setName(null);
		pizza.setQuantity(1);
		order.addPizza(p);
	}


	public boolean hasComplementaryDrinks(Order order) {
		boolean found=false;
		for (Pizza pizza : order.getPizzaList()) {
			if ("Indian Spicy Pizza".equals(pizza.getName())) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public String submitOrder(Order order){
		
		System.out.println(String.format("***==> Customer: fist=[%s] last=[%s] email=[%s]",
				order.getCustomer().getFirstName(), 
				order.getCustomer().getLastName(), 
				order.getCustomer().getEmailAddress() ));
		
		StringBuilder items = new StringBuilder();
		items.append("***==> Order: ");
		for(Pizza p : order.getPizzaList()) {
			items.append(p.getQuantity()+" "+p.getName()+"|");
		}
		if (order.isComplimentaryDrink()) {
			items.append("Complementary Drink");			
		}
		System.out.println(items.toString());

		return "success";
	}

}
