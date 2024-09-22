package uo.mp.newsstand.service.exception;

/**
 * Titulo: Clase InvalidFileNameException
 * 
 * @author Omitg
 * @version 16-04-2021
 */
@SuppressWarnings("serial")
public class InvalidFileNameException extends NewsStandException {

	/**
	 * Constructor invalid
	 */
	public InvalidFileNameException() {
	}

	/**
	 * Método que lanza un mensaje
	 * 
	 * @param message, mensaje
	 */
	public InvalidFileNameException(String message) {
		super(message);
	}

	/**
	 * Método que lanza la causa
	 * 
	 * @param cause, causa
	 */
	public InvalidFileNameException(Throwable cause) {
		super(cause);

	}

	/**
	 * Método que lanza un mensaje y la causa
	 * 
	 * @param message, mensaje
	 * @param cause,   cause
	 */
	public InvalidFileNameException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Método que lanza un mensaje, la cause y los stack
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
