package uo.mp.newsstand.service.exception;

/**
 * Titulo: Clase AlreadyExistsException 
 * 
 * @author Omitg
 * @version 16-04-2021
 */
@SuppressWarnings("serial")
public class AlreadyExistsException extends NewsStandException {
	
	/**
	 * Constructor already
	 */
	public AlreadyExistsException() {
	}
	
	/**
	 * M�todo que lanza un mensaje
	 * 
	 * @param message, mensaje
	 */
	public AlreadyExistsException(String message) {
		super(message);
	}
	
	/**
	 * M�todo que lanza la causa
	 * 
	 * @param cause, causa
	 */
	public AlreadyExistsException(Throwable cause) {
		super(cause);
	}

	/**
	 * M�todo que lanza un mensaje y la causa
	 * 
	 * @param message, mensaje
	 * @param cause, cause
	 */
	public AlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * M�todo que lanza un mensaje, la cause y los stack
	 * 
	 * @param message, mensaje
	 * @param cause, causa
	 * @param enableSuppression, supresion
	 * @param writableStackTrace, stack
	 */
	public AlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
