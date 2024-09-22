package uo.mp2021.util.checks;

/**
 * Titulo: Clase StateChecks
 * 
 * @author Omitg
 * @version 16-04-2021
 */
public class StateChecks {
	
	/**
	 * 
	 * Método que analiza si la condición se cumple, en caso contrario, lanza 
	 * la excepción
	 * 
	 * @param condition, condición a analizar
	 */
	public static void isTrue(boolean condition) {
		if (condition == true) return;
		throwException( "Condition not met" );
	}
	
	/**
	 * Método que analiza si la condición se cumple, en caso contrario, lanza 
	 * la excepción personalizada
	 * 
	 * @param condition, condición a analizar
	 * @param msg, mensaje que lanzara la excepción
	 */	
	public static void isTrue(boolean condition, String msg) {
		if (condition == true) return;
		throwException(msg);
	}
	
	/**
	 * Método que lanza la excepción
	 * 
	 * @param msg, excepción a lanzar
	 */
	private static void throwException(String msg) {
		throw new IllegalStateException( msg );
	}

}
