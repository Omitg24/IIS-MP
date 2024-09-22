package uo.mp2021.util.checks;

/**
 * Titulo: Clase ArgumentChecks
 * 
 * @author Omitg
 * @version 04-03-2021
 */
public class ArgumentChecks {
//Constantes:	
	/**
	 * Constante mensaje por defecto
	 */
	private static String DEFAULT_MESSAGE = "Something went wrong ... ";
	/**
	 * Constante mensaje output
	 */
	private static String outputMessage = null;
	
	/**
	 * M�todo estatico que analiza el argumento
	 * 
	 * @param condition, condicion a analizar
	 */
	public static void isTrue ( boolean condition ) {
		outputMessage = DEFAULT_MESSAGE;
		if (!condition) 
			throw new IllegalArgumentException(outputMessage);
	}
	
	/**
	 * M�todo estatico que analiza el argumento y lanza la excepci�n
	 * 
	 * @param condition, condici�n a analizar
	 * @param message, mensaje a analizar
	 */
	public static void isTrue ( boolean condition, String message ) {
		outputMessage = message;
		if (!condition) 
			throw new IllegalArgumentException(outputMessage);
	}
}
