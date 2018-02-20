package main;

import java.util.ArrayList;
import java.util.Scanner;

import Order.Order;
import Order.OrderProcessing;

public class Main {

	/**
	 * @param args
	 *///Main Function
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char choice = 'n';
		int i = 0;
		OrderProcessing orderProcessing = new OrderProcessing();
		do {
			Order O1 = new Order();
			
			//Reading new order
			System.out.println(
					"Provide Order Details : \n [orderID : Type : Product : Price : Quantity : CustID]\n");
			O1.read();  
			
			
			// Finding the match
			ArrayList<Order> matched = orderProcessing.Process(O1);										
			
			// Producing the Matched Orders 
			System.out.println("Matched Orders are : ");
			orderProcessing.matched(matched);
			
			//Producing the Pending Orders
			System.out.println("\nPending Orders till now are : ");
			orderProcessing.pending();
			
			//Asking for New Orders 
			System.out.println("\nWant to add new order : [y/n] \n ");
			@SuppressWarnings("resource")
			Scanner s = new Scanner(System.in);
			choice = s.next().charAt(0);
		} while (choice == 'y');
	}

}
