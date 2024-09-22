package payments.ui;

import payment.service.Retail;
import payments.model.Cash;
import payments.model.CreditCard;
import payments.model.Payments;
import payments.model.Paypal;

/**
 * Titulo: Clase PlayApp
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public class PayApp {
	
	/**
	 * Método run que lanza el programa
	 */
	public static void run() {
		Retail retailer = new Retail();
		
		Payments p1 = new CreditCard("100", 100, "1111-1111-1111-1111-1111", 12, 2018);
		Payments p2 = new Paypal("101", 100, "john@gmail.com", "@34abX!");
		Payments p3 = new Cash("102",100);
		
		retailer.addPayment(p1);
		retailer.addPayment(p2);
		retailer.addPayment(p3);
		
		System.out.println("------------------------ PayApp ------------------------");
		System.out.println();
		retailer.processAllPayments();
		System.out.println();
		
		System.out.println("---------------------- Total Value ----------------------");
		System.out.println("\nThe total amount of sales is: "+retailer.getTotalSales());
		
		
	}
}
