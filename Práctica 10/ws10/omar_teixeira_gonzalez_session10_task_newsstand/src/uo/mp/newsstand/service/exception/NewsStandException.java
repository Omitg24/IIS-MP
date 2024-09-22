package uo.mp.newsstand.service.exception;

/**
 * Titulo: Clase NewsStandException 
 * 
 * @author Omitg
 * @version 16-04-2021
 */
@SuppressWarnings("serial")
public class NewsStandException extends Exception {
	
	/**
	 * Constructor newsstand
	 */
	public NewsStandException() {
	}
	
	/**
	 * Método que lanza un mensaje
	 * 
	 * @param message, mensaje
	 */
	public NewsStandException(String message) {
		super(message);
	}

	/**
	 * Método que lanza la causa
	 * 
	 * @param cause, causa
	 */
	public NewsStandException(Throwable cause) {
		super(cause);
	}

	/**
	 * Método que lanza un mensaje y la causa
	 * 
	 * @param message, mensaje
	 * @param cause, cause
	 */
	public NewsStandException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Método que lanza un mensaje, la cause y los stack
	 * 
	 * @param message, mensaje
	 * @param cause, causa
	 * @param enableSuppression, supresion
	 * @param writableStackTrace, stack
	 */
	public NewsStandException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
