/**
 * 
 */
package Order;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * @author guptas
 *
 */
public class Order {

	String ord_ID;
	String type;
	String product;
	String pro_ID;
	int price;
	int qty;
	String cust_ID;

	public void read() {
		Scanner s = new Scanner(System.in);
		this.ord_ID = s.nextLine();
		this.type = s.next();
		this.product = s.next();
		this.price = s.nextInt();
		this.qty = s.nextInt();
		this.cust_ID = s.next();
	}

	public void show() {
		System.out.println("OrderID :" + this.ord_ID);
		System.out.println("Type :" + this.type);
		System.out.println("Product :" + this.product);
		System.out.println("Price :" + this.price);
		System.out.println("Quantity :" + this.qty);
		System.out.println("CustomerID :" + this.cust_ID);

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ord_ID+","+type+","+product+","+price+","+qty+","+cust_ID;
	}
}


