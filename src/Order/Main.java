/**
 * 
 */
package Order;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * @author guptas
 *
 */

class Order {

	String ord_ID;
	String type;
	String product;
	String pro_ID;
	int price;
	int qty;
	String cust_ID;

	void read() {
		Scanner s = new Scanner(System.in);
		this.ord_ID = s.nextLine();
		this.type = s.next();
		this.product = s.next();
		this.price = s.nextInt();
		this.qty = s.nextInt();
		this.cust_ID = s.next();
	}

	void show() {
		System.out.println("OrderID :" + this.ord_ID);
		System.out.println("Type :" + this.type);
		System.out.println("Product :" + this.product);
		System.out.println("Price :" + this.price);
		System.out.println("Quantity :" + this.qty);
		System.out.println("CustomerID :" + this.cust_ID);

	}

	public void Process(ArrayList<Order> orders) {
		int lenth = orders.size();
		if("Sell".equalsIgnoreCase(this.type))
		{
			int i = 0;
			while(lenth-- > 0)
			{
				Order o = orders.get(i++);
				if( ("Buy".equalsIgnoreCase(o.type)) && (o.product.equalsIgnoreCase(this.product)) && (o.price >= this.price))
				{
					if(o.qty > this.qty)
					{
						o.qty -= this.qty;
						
//						orders.add(i-1, o);
						System.out.println("break");
						break;
					}
					else
					{
						this.qty -= o.qty;
//						orders.add(lenth, this);
						System.out.println("continue");
						continue;
					}
				}
			}
		}
		else if(this.type == "Buy" || this.type == "buy")
		{
			int i = 0;
			while(lenth-- > 0)
			{
				Order o = orders.get(i++);
				if( (o.type  == "Sell" || o.type == "sell") && (o.product.equals(this.product)) && (o.price <= this.price))
				{
					if(o.qty > this.qty)
					{
						o.qty -= this.qty;
//						orders.add(i-1, o);
						System.out.println("break");
						break;
					}
					else
					{
						this.qty -= o.qty;
//						orders.add(lenth, this);
						System.out.println("continue");
						continue;
					}
				}
			}
		}
	}

	public void pending(ArrayList<Order> orders) {
		// TODO Auto-generated method stub
		int lenth = orders.size();
		System.out.println("Number of orders left : " + lenth);
		int i=0;
		while(lenth-- > 0)
		{
			System.out.println("\nORDER #"+(i+1));
			Order o = orders.get(i++);
			o.show();
		}
	}
}

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char choice = 'n';
		int i = 0;
		ArrayList<Order> orders = new ArrayList<Order>();
		do {
			Order O1 = new Order();
			System.out.println(
					"Provide Order Details : \n [orderID : Type : Product : Price : Quantity : CustID]\n");
			O1.read();  								 ///Reading new orders
			orders.add(O1);								//Added in the list                           
			O1.Process(orders);								// Finding the match
			System.out.println("\nPending Orders till now are : ");
			O1.pending(orders);								//Pending orders.
			System.out.println("\nWant to add new order : [y/n] \n ");
			@SuppressWarnings("resource")
			Scanner s = new Scanner(System.in);
			choice = s.next().charAt(0);
		} while (choice == 'y');
	}

}
