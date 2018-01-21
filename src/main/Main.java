package main;

import java.util.ArrayList;
import java.util.Scanner;

import Order.Order;
import Order.OrderProcessing;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char choice = 'n';
		int i = 0;
		OrderProcessing orderProcessing = new OrderProcessing();
		do {
			Order O1 = new Order();
			System.out.println(
					"Provide Order Details : \n [orderID : Type : Product : Price : Quantity : CustID]\n");
			O1.read();  								 ///Reading new orders
//			orders.add(O1);							//Added in the list                           
			orderProcessing.Process(O1);								// Finding the match
			System.out.println("\nPending Orders till now are : ");
			
			orderProcessing.pending();								//Pending orders.
			System.out.println("\nWant to add new order : [y/n] \n ");
			@SuppressWarnings("resource")
			Scanner s = new Scanner(System.in);
			choice = s.next().charAt(0);
		} while (choice == 'y');
	}

}
