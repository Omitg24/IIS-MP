package payments.model;

import ruralvia.PaymentGateway;
import ruralvia.Transaction;

/**
 * Titulo: Clase CreditCard
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public class CreditCard extends Payments implements Transaction{
	/**
	 * Constante ID del merchant
	 */
	public static final String MERCHANT_ID= "1111-22";
	/**
	 * Atributo numero de tarjeta de credito
	 */
	private String creditCardNumber;
	/**
	 * Atributos month y year
	 */
	private int month, year;
	
	/**
	 * Constructor con parámetros transactionID, amount, isValid, creditCardNumber, 
	 * month y year
	 * 
	 * @param transactionID, ID de la transacción
	 * @param amount, cantidad del pago
	 * @param creditCardNumber, numero de la tarjeta
	 * @param month, mes en el que caduca la tarjeta
	 * @param year, año en el que caduca la tarjeta
	 */
	public CreditCard(String transactionID, int amount, 
			String creditCardNumber, int month, int year) {
		super(transactionID, amount);
		setCreditCardNumber(creditCardNumber);
		setMonth(month);
		setYear(year);
	}
	
	/**
	 * Método que procesa el pago, en este caso siempre sera valido
	 */
	@Override
	public void process() {
		PaymentGateway pg = new PaymentGateway();
		if (!pg.isValid(this)) {
			setValid(Payments.INVALID_PAYMENT);
		} else {
			setValid(Payments.VALID_PAYMENT);
			System.out.println("Transacción correcta de: CreditCard");
			System.out.println(this.toString());
		}
		
	}
	
	/**
	 * Método que devuelve el valor de los atributos de Cash
	 * 
	 * @return valor de los atributos de Cash
	 */
	@Override
	public String toString() {
		return "ID de la transacción: " + getTransactionID() + "; Cantidad: " + getAmount();
	}	
	
	/**
	 * Método que modifica el valor del atributo creditCardNumber
	 * 
	 * @param creditCardNumber, numero de la tarjeta
	 */
	private void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	/**
	 * Método que modifica el valor del atributo month
	 * 
	 * @param month, mes en el que caduca la  tarjeta
	 */
	private void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Método que modifica el valor del atributo year
	 * 
	 * @param year, año en el que caduca la  tarjeta
	 */
	private void setYear(int year) {
		this.year = year;
	}

	/**
	 * Método que devuelve el valor del atributo creditCardNumber
	 * 
	 * @return creditCardNumber, numero de la tarjeta
	 */
	@Override
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	/**
	 * Método que devuelve el valor del atributo month
	 * 
	 * @return month, mes en el que caduca la  tarjeta
	 */
	@Override
	public int getMonth() {
		return month;
	}

	/**
	 * Método que devuelve el valor del atributo year
	 * 
	 * @return year, año en el que caduca la  tarjeta
	 */
	@Override
	public int getYear() {
		return year;
	}
}
