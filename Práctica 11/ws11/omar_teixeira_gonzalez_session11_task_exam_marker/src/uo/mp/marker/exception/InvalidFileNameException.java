package uo.mp.marker.exception;

/**
 * Titulo: Clase InvalidFileNameException
 * 
 * @author Omitg
 * @version 22-04-2021
 */
@SuppressWarnings("serial")
public class InvalidFileNameException extends MarkerException {

	/**
	 * Constructor invalid
	 */
	public InvalidFileNameException() {
	}

	/**
	 * M�todo que lanza un mensaje
	 * 
	 * @param message, mensaje
	 */
	public InvalidFileNameException(String message) {
		super(message);
	}

	/**
	 * M�todo que lanza la causa
	 * 
	 * @param cause, causa
	 */
	public InvalidFileNameException(Throwable cause) {
		super(cause);

	}

	/**
	 * M�todo que lanza un mensaje y la causa
	 * 
	 * @param message, mensaje
	 * @param cause,   cause
	 */
	public InvalidFileNameException(String message, Throwable cause) {
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
	public InvalidFileNameException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
