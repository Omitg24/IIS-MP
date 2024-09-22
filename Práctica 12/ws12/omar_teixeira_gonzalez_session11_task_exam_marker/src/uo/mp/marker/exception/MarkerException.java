package uo.mp.marker.exception;

/**
 * Titulo: Clase NewsStandException
 * 
 * @author Omitg
 * @version 29-04-2021
 */
@SuppressWarnings("serial")
public class MarkerException extends Exception {

	/**
	 * Constructor MarkerException
	 */
	public MarkerException() {
	}

	/**
	 * M�todo que lanza un mensaje
	 * 
	 * @param message, mensaje
	 */
	public MarkerException(String message) {
		super(message);
	}

	/**
	 * M�todo que lanza la causa
	 * 
	 * @param cause, causa
	 */
	public MarkerException(Throwable cause) {
		super(cause);
	}

	/**
	 * M�todo que lanza un mensaje y la causa
	 * 
	 * @param message, mensaje
	 * @param cause,   cause
	 */
	public MarkerException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * M�todo que lanza un mensaje, la cause y los stack
	 * 
	 * @param message,            mensaje
	 * @param cause,              causa
	 * @param enableSuppression,  supresion
	 * @param writableStackTrace, stack
	 */
	public MarkerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
