package uo.mp.exceptions;

/**
 * Titulo: Clase InvalidLineFormatException
 * 
 * @author Omitg
 * @version 07-05-2021
 */
@SuppressWarnings("serial")
public class InvalidLineFormatException extends Exception {
	/**
	 * Atributo numero de linea
	 */
	private int lineNumber;

	/**
	 * Constructor con parámetros ln, message
	 * 
	 * @param ln,      linea
	 * @param message, mensaje
	 */
	public InvalidLineFormatException(int ln, String message) {
		super(message);
		lineNumber = ln;
	}

	/**
	 * Método que devuelve el mensaje obtenido
	 * 
	 * @return message, mensaje
	 */
	@Override
	public String getMessage() {
		return "InvalidLineFormatException. Linea " + lineNumber + super.getMessage();
	}
}
