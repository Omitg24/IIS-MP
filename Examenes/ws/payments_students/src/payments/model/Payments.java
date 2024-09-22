package payments.model;

/**
 * Titulo: Superclase Payments
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public abstract class Payments {
//Constantes:
	/**
	 * Constantes pago valido e invalido
	 */
	public static final boolean VALID_PAYMENT = true, INVALID_PAYMENT = false;
	
//Atributos:	
	/**
	 * Atributo ID de la Transación
	 */
	protected String transactionID;
	/**
	 * Atributo cantidad del pago
	 */	
	protected int amount;
	/**
	 * Atributo pago valido
	 */
	protected boolean isValid;
	
	/**
	 * Constructor con parámetros transactionID, amount y isValid
	 * 
	 * @param transactionID, ID de la Transacción
	 * @param amount, cantidad del pago
	 */
	public Payments(String transactionID, int amount) {
		super();
		setTransactionID(transactionID);
		setAmount(amount);
	}
	
	/**
	 * Método que devuelve el valor del atributo transactionID
	 * 
	 * @return  transactionID, id de la transacción
	 */
	public String getTransactionID() {
		return transactionID;
	}

	/**
	 * Método que modifica el valor del atributo transactionID
	 * 
	 * @return  transactionID, id de la transacción
	 */
	protected void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	/**
	 * Método que devuelve el valor del atributo amount
	 * 
	 * @return  amount, cantidad del pago
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * Método que modifica el valor del atributo amount
	 * 
	 * @return  amount, cantidad del pago
	 */
	protected void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * Método que devuelve el valor del atributo isValid
	 * 
	 * @return  isValid, pago valido
	 */
	public boolean isValid() {
		return isValid;
	}
	
	/**
	 * Método que modifica el valor del atributo isValid
	 * 
	 * @return  isValid, pago valido
	 */
	protected void setValid(boolean isValid) {
		this.isValid = isValid;
	}	
	
	/**
	 * Método que procesa el pago
	 */
	public abstract void process();
	
	/**
	 * Método que devuelve el valor de los atributos
	 *  
	 * @return valor de los atributos
	 */
	public abstract String toString();
}
