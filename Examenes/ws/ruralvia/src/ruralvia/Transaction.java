package ruralvia;

/**
 * Titulo: Interfaz Transaction
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public interface Transaction {
	
	/**
	 * M�todo que devuelve el valor del atributo creditCardNumber
	 * 
	 * @return creditCardNumber, numero de la tarjeta
	 */
	String getCreditCardNumber();
	
	/**
	 * M�todo que devuelve el valor del atributo month
	 * 
	 * @return month, mes en el que caduca la tarjeta
	 */
	int getMonth();
	
	/**
	 * M�todo que devuelve el valor del atributo year
	 * 
	 * @return year, a�o en el que caduca la tarjeta
	 */
	int getYear();
}
