package ruralvia;

/**
 * Titulo: Clase PaymentGateway
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public class PaymentGateway {
	/**
	 * Constantes numero, mes y año
	 */
	private static final int NUMBER = 0, MONTH = 1, YEAR = 2;

	/**
	 * Método validCreditCards
	 */
	private Object[][] validCreditCards = { 
			{ "1111-1111-1111-1111-1111", 12, 2018 }, 
			{ "2222-2222-2222-2222-2222", 12, 2018 },
			{ "1111-1111-1111-1111-4444", 1, 2019 }, 
			{ "3333-3333-3333-3333-3333", 7, 2017 } 
		};
	
	/**
	 * Método que analiza si un pago es valido dada una transacción
	 * 
	 * @param transaction, transacción de pago con tarjeta
	 * @return true o false si el pago es valido
	 */
	public boolean isValid(Transaction transaction) {
		for (Object[] row : validCreditCards) {
			String pan = (String) row[NUMBER]; 
			if ( pan.equals(transaction.getCreditCardNumber()) ) {
				return row[MONTH].equals(transaction.getMonth()) 
						&& row[YEAR].equals(transaction.getYear());
			}
		}
		return false;
	}
}
