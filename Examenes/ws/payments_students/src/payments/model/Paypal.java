package payments.model;

import paypal.PayPalAPI;

/**
 * Titulo: Clase Paypal
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public class Paypal extends Payments{
	/**
	 * Atributos usuario y contraseña
	 */
	private String username, password;
	
	/**
	 * Atribto api de Paypal
	 */
	private PayPalAPI api;
	
	/**
	 * Constructor con parámetros transactionID, amount, isValid, username y password
	 * 
	 * @param transactionID, ID de la transaccion
	 * @param amount, cantidad del pago	 * 
	 * @param username, nombre del usuario
	 * @param password, contraseña del usuario
	 */
	public Paypal(String transactionID, int amount, String username, String password) {
		super(transactionID, amount);
		setUsername(username);
		setPassword(password);
		api = new PayPalAPI();
	}	
	
	/**
	 * Método que devuelve el valor del atributo username
	 * 
	 * @return username, nombre del usuario
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Método que modifica el valor del atributo username
	 * 
	 * @param username, nombre del usuario
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Método que devuelve el valor del atributo password
	 * 
	 * @return password, contraseña del usuario
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Método que modifica el valor del atributo password
	 * 
	 * @param password, contraseña del usuario
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Método que procesa el pago
	 */
	@Override
	public void process() {
		String token = api.logIn(username,password);
		if (!api.checkout(token, transactionID, amount)) {
			setValid(Payments.INVALID_PAYMENT);
		} else {
			setValid(Payments.VALID_PAYMENT);
			System.out.println("Transacción correcta de: PayPal");
			System.out.println(this.toString());
		}
	}
	
	/**
	 * Método que devuelve el valor de los atributos
	 *  
	 * @return valor de los atributos
	 */
	@Override
	public String toString() {
		return "ID de la transacción: " + getTransactionID() + "; Cantidad: " + getAmount();
	}
}
