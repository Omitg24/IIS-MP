package ruralvia;

/**
 * Titulo: Interfaz Transaction
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public interface Transaction {
	
	/**
	 * Método que devuelve el valor del atributo creditCardNumber
	 * 
	 * @return creditCardNumber, numero de la tarjeta
	 */
	String getCreditCardNumber();
	
	/**
	 * Método que devuelve el valor del atributo month
	 * 
	 * @return month, mes en el que caduca la tarjeta
	 */
	int getMonth();
	
	/**
	 * Método que devuelve el valor del atributo year
	 * 
	 * @return year, año en el que caduca la tarjeta
	 */
	int getYear();
}
