/**
 * 
 */
package uo.mp.invoice;

import uo.mp.collections.List;

public class InvoiceManager {
	
	public String generateInvoice(List<Billable> list, double discount){
		String header = "Código\tDescripción\tPrecio final\n";
		String result = "";
		for (Billable b : list) {
			result = result + b.getCode() + "\t" + b.getDescription() + "\t" + b.getCost() + "\n";
		}		
		return header + result;
	}
}
