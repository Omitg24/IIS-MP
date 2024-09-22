package uo.mp2021.util.checks;

/**
 * Título: Clase ArgumentChecks
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
	 * Método que analiza si la condición se cumple, en caso contrario, lanza 
	 * la excepción
	 * 
	 * @param condition, condición a analizar
	 */
	public static void isTrue ( boolean condition ) {
		outputMessage = DEFAULT_MESSAGE;
		if (!condition) 
			throw new IllegalArgumentException(outputMessage);
	}
	
	/**
	 * Método que analiza si la condición se cumple, en caso contrario, lanza 
	 * la excepción personalizada
	 * 
	 * @param condition, condición a analizar
	 * @param message, mensaje que lanzara la excepción
	 */
	public static void isTrue ( boolean condition, String message ) {
		outputMessage = message;
		if (!condition) 
			throw new IllegalArgumentException(outputMessage);
	}
}
