package Order;

import java.util.ArrayList;

public class OrderProcessing {
	private ArrayList<Order> orderQueue = new ArrayList<Order>();

	public void Process( Order order) {
		int lenth = orderQueue.size();
		if ("Sell".equalsIgnoreCase(order.type)) {
			int i = 0;
			while (lenth-- > 0) {
				Order o = orderQueue.get(i++);
				if (("Buy".equalsIgnoreCase(o.type)) && (o.product.equalsIgnoreCase(order.product))
						&& (o.price >= order.price)) {
					if (o.qty > order.qty) {
						o.qty -= order.qty;
						order.qty = 0;
						break;
					} else {
						order.qty -= o.qty;
						o.qty = 0;
						continue;
					}
				}
			}
		} else {
			System.out.println("HERE");
			int i = 0;
			while (lenth-- > 0) {
				Order o = orderQueue.get(i++);
				if ("Sell".equalsIgnoreCase(o.type) && (o.product.equalsIgnoreCase(order.product))
						&& (o.price <= order.price)) {
					if (o.qty >= order.qty) {
						o.qty -= order.qty;
						order.qty = 0;
						break;
					} else {
						order.qty -= o.qty;
						o.qty = 0;
						continue;
					}
				}
			}
		}
		orderQueue.add(order);
		System.out.println(orderQueue);
	}

	public ArrayList<Order> getOrderQueue() {
		return orderQueue;

	}
	public void pending() {
		// TODO Auto-generated method stub
		int lenth = orderQueue.size();
		System.out.println("Number of orders left : " + lenth);
		int i=0;
		while(lenth-- > 0)
		{
			System.out.println("\nORDER #"+(i+1));
			Order order = orderQueue.get(i++);
			if(order.qty != 0) order.show();
		}
	}
}
