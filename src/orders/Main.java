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
	
	public void read(Orders O)
	{
		Scanner s = new Scanner(System.in);
		this.ord_ID = s.next();
		this.type = s.next();
		this.product = s.nextLine();
		this.pro_ID  = s.nextLine();
		this.price = s.nextInt();
		this.qty = s.nextInt();
		this.cust_ID = s.nextLine();
	}
}
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Orders O1;
		
	}

}
