package uo.mp2021.util.checks;

/**
 * T�tulo: Clase ArgumentChecks
 * 
 * @author Omitg
 * @version 16-04-2021
 */
public class ArgumentChecks {
	/**
	 * Mensaje por defecto
	 */
	private static String DEFAULT_MESSAGE = "Something went wrong ... ";
	
	/**
	 * Mensaje para la salida
	 */
	private static String outputMessage = null;
	
	/**
	 * M�todo que analiza si la condici�n se cumple, en caso contrario, lanza 
	 * la excepci�n
	 * 
	 * @param condition, condici�n a analizar
	 */
	public static void isTrue ( boolean condition ) {
		outputMessage = DEFAULT_MESSAGE;
		if (!condition) 
			throw new IllegalArgumentException(outputMessage);
	}
	
	/**
	 * M�todo que analiza si la condici�n se cumple, en caso contrario, lanza 
	 * la excepci�n personalizada
	 * 
	 * @param condition, condici�n a analizar
	 * @param message, mensaje que lanzara la excepci�n
	 */
	public static void isTrue ( boolean condition, String message ) {
		outputMessage = message;
		if (!condition) 
			throw new IllegalArgumentException(outputMessage);
	}
}
