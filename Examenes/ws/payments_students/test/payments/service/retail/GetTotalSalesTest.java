package payments.service.retail;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import payment.service.Retail;
import payments.model.Cash;
import payments.model.CreditCard;
import payments.model.Payments;
import payments.model.Paypal;

/**
 * Titulo: Clase GetTotalSalesTest
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public class GetTotalSalesTest {
	/**
	 * Atributo retailer
	 */
	private Retail retailer;
	/**
	 * Atributos pago
	 */
	private Payments p1, p2, p3, p4, p5;
	
	/**
	 * Creación de objetos para su uso posterior
	 */
	@Before
	public void setUp() {
		retailer = new Retail();
		
		p1 = new CreditCard("100", 100, "1111-1111-1111-1111-1111", 12, 2018);
		p2 = new Paypal("101", 100, "john@gmail.com", "@34abX!");
		p3 = new Cash("102",100);
		p4 = new CreditCard("100", 100, "1111-1111-1111-1111-", 6, 2014);
		p5 = new Paypal("101", 100, "omitg@uniovi.com", "@aew4abX!"); 
	}
	
	/**
	 * Pruebas del método getTotalSales de la clase Retail:
	 * 1- No tiene pagos validos, devuelve 0
	 * 2- No tiene pagos, devuelve 0
	 * 3- Tiene pagos validos, devuelve el total
	 */
	
	/**
	 * 1- No tiene pagos validos, devuelve 0
	 * GIVEN Se crea un retailer y varios pagos
	 * WHEN Se añaden pagos invalidos y se llama al método getTotalSales
	 * THEN Se comprueba que devuelve 0
	 */
	@Test
	public void testNoValidPayments() {
		retailer.addPayment(p4);
		retailer.addPayment(p5);		
		assertEquals(0.0, retailer.getTotalSales(), 0.1);
	}
	
	/**
	 * 2- No tiene pagos, devuelve 0
	 * GIVEN Se crea un retailer y varios pagos
	 * WHEN Se llama al método getTotalSales
	 * THEN Se comprueba que devuelve 0
	 */
	@Test
	public void testNoPayments() {				
		assertEquals(0.0, retailer.getTotalSales(), 0.1);
	}
	
	/**
	 * 3- Tiene pagos validos, devuelve el total
	 * GIVEN Se crea un retailer y varios pagos
	 * WHEN Se añaden pagos validos, se procesan y se llama al método getTotalSales
	 * THEN Se comprueba que devuelve el valor total
	 */
	@Test
	public void testValidPayments() {
		retailer.addPayment(p1);
		retailer.addPayment(p2);
		retailer.addPayment(p3);
		retailer.processAllPayments();
		assertEquals(300.0, retailer.getTotalSales(), 0.1);
	}
}
