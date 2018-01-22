package Order;

import java.util.ArrayList;

//Class for Processing the Orders 
public class OrderProcessing {
	
	//OrderQueue in which all Orders are added and removed if they got a match.
	private ArrayList<Order> orderQueue = new ArrayList<Order>();

	//Processing Logic
	public ArrayList<Order> Process( Order order) {
		int lenth = orderQueue.size();
		
		//Matched Queue for storing the matched orders at that time only i.e. why i have declared locally so that it will persist for more than one orders.
		ArrayList<Order> matched = new ArrayList<Order>();
		
		//if current order is sell type order
		if ("Sell".equalsIgnoreCase(order.type)) {
			int i = 0;
			while (lenth-- > 0) {
				Order o = orderQueue.get(i++);
				if (("Buy".equalsIgnoreCase(o.type)) && (o.product.equalsIgnoreCase(order.product))
						&& (o.price >= order.price)) {
					Order o1 = new Order(o);
					matched.add(o1);
					if (o.qty >= order.qty) {
						o.qty -= order.qty;
						o1.qty = order.qty;
						order.qty = 0;
						break;
					} else {
						order.qty -= o.qty;
						o.qty = 0;
						o1.qty = 0;
						continue;
					}
				}
			}
		}
		//if current order is buy type order 
		else {
			int i = 0;
			while (lenth-- > 0) {
				Order o = orderQueue.get(i++);
				if ("Sell".equalsIgnoreCase(o.type) && (o.product.equalsIgnoreCase(order.product))
						&& (o.price <= order.price)) {
					Order o1 = new Order(o);
					matched.add(o1);
					if (o.qty >= order.qty) {
						o.qty -= order.qty;
						o1.qty = order.qty;
						order.qty = 0;
						break;
					} else {
						order.qty -= o.qty;
						o.qty = 0;
						o1.qty = 0;
						continue;
					}
				}
			}
		}
		orderQueue.add(order);
		System.out.println(orderQueue);
		return matched;
	}

	//getting the Current OrderQueue
	public ArrayList<Order> getOrderQueue() {
		return orderQueue;

	}
	
	//Function for pending orders
	public ArrayList<Order> pending() {
		// TODO Auto-generated method stub
		for(int i=0;i<orderQueue.size();)
		{
			Order order = orderQueue.get(i);
			if(order.qty != 0) 
				{
				//prints only non-zero quantity orders
				System.out.println("Order #"+i++);
				order.show();
				}
			else
			{ 
				//remove the zero quantity orders
				orderQueue.remove(order);
			}
		}
		return orderQueue;
	}

	//Function for returning matched orders
	public void matched(ArrayList<Order> matched) {
		// TODO Auto-generated method stub
		for(int i=0;i<matched.size();i++)
			matched.get(i).show();
	}
}
