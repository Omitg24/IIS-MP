package uo.mp.checks;

/**
 * Titulo: Clase ArgumentChecks
 * 
 * @author Omitg
 * @version 07-05-2021
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
	 * Método estatico que analiza el argumento
	 * 
	 * @param condition, condicion a analizar
	 */
	public static void isTrue ( boolean condition ) {
		outputMessage = DEFAULT_MESSAGE;
		if (!condition) 
			throw new IllegalArgumentException(outputMessage);
	}
	
	/**
	 * Método estatico que analiza el argumento y lanza la excepción
	 * 
	 * @param condition, condición a analizar
	 * @param message, mensaje a analizar
	 */
	public static void isTrue ( boolean condition, String message ) {
		outputMessage = message;
		if (!condition) 
			throw new IllegalArgumentException(outputMessage);
	}
	
	/**
	 * Método estatico que comprueba que un objeto no es null
	 * 
	 * @param obj, objeto a analizar
	 */
	public static void isNotNull(Object obj) {
		isTrue(obj!=null, "No puede ser null");		
	}
	
	/**
	 * Método estatico que comprueba que un string no es null ni vacío
	 * 
	 * @param inFileName, string a analizar
	 */
	public static void isNotEmpty(String inFileName) {
		isTrue(inFileName != null && !inFileName.isBlank());		
	}
}
