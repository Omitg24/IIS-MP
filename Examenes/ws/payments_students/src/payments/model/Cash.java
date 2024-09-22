package payments.model;

/**
 * Titulo: Clase Cash
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public class Cash extends Payments{
	
	/**
	 * Constructor con parámetros transactionID, amount e isValid que crea el subpago payment Cash
	 * 
	 * @param transactionID, ID de la transacción
	 * @param amount, cantidad del pago
	 */
	public Cash(String transactionID, int amount) {
		super(transactionID, amount);
	}

	/**
	 * Método que procesa el pago, en este caso siempre sera valido
	 */
	@Override
	public void process() {
		setValid(Payments.VALID_PAYMENT);
		System.out.println("Transacción correcta de: Cash");
		System.out.println(this.toString());
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
}
