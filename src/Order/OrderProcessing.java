package Order;

import java.util.ArrayList;

public class OrderProcessing {
	private ArrayList<Order> orderQueue = new ArrayList<Order>();

	public ArrayList<Order> Process( Order order) {
		int lenth = orderQueue.size();
		ArrayList<Order> matched = new ArrayList<Order>();
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
		} else {
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

	public ArrayList<Order> getOrderQueue() {
		return orderQueue;

	}
	public void pending(ArrayList<Order> matched) {
		// TODO Auto-generated method stub
		for(int i=0;i<orderQueue.size();)
		{
			Order order = orderQueue.get(i);
			if(order.qty != 0) 
				{
				System.out.println("Order #"+i++);
				order.show();
				}
			else
			{
				orderQueue.remove(order);
			}
		}
	}

	public void matched(ArrayList<Order> matched) {
		// TODO Auto-generated method stub
		for(int i=0;i<matched.size();i++)
			matched.get(i).show();
	}
}
