package payment.service;



import payments.model.Payments;
import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;

/**
 * Titulo: Clase Retail
 *  
 * @author Omitg
 * @version 18-03-2021
 */
public class Retail {
	
	/**
	 * Lista de pagos
	 */
	private List<Payments> payments = new ArrayList<Payments>();
	
	/**
	 * Método que añade pagos a la lista
	 * 
	 * @param p, pago a añadir a la lista
	 */
	public void addPayment (Payments p) {
		payments.add(p);
	}
	
	/**
	 * Método que procesa todos los pagos de la lista
	 */
	public void processAllPayments() {
		for (Payments p : payments) {
			p.process();
		}
	}
	
	/**
	 * Método que devuelve el valor total de los pagos realizados
	 * 
	 * @return amount, total del pago
	 */
	public double getTotalSales() {
		double amount = 0;
		for (Payments p : payments) {
			if (p.isValid()) {
				amount+=p.getAmount();
			}			
		}
		return amount;
	}
}
