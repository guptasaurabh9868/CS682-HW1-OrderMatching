/**
 * 
 */
package orders;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * @author guptas
 *
 */
class Orders{
	
	String ord_ID;
	String type;
	String product;
	String pro_ID;
	int price;
	int qty;
	String cust_ID;
	
	public void read()
	{
		Scanner s = new Scanner(System.in);
		this.ord_ID = s.next();
		this.type = s.next();
		this.product = s.next();
		this.pro_ID  = s.next();
		this.price = s.nextInt();
		this.qty = s.nextInt();
		this.cust_ID = s.next();
	}
	public void show()
	{
		System.out.println("OrderID :" + this.ord_ID + "\n" );
		System.out.println("Type :" + this.type + "\n" );
		System.out.println("Product :" + this.product + "\n" );
		System.out.println("ProductID :" + this.pro_ID + "\n" );
		System.out.println("Price :" + this.price + "\n" );
		System.out.println("Quantity :" + this.qty + "\n" );
		System.out.println("CustomerID :" + this.cust_ID + "\n" );

	}
}
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Orders O1 = new Orders();
		System.out.println("Provide Order Details : \n [orderID : Type : Product : ProductID : Price : Quantity : CustID]\n");
		O1.read();
		System.out.println("These are details of your order: \n");
		O1.show();
		
	}

}
