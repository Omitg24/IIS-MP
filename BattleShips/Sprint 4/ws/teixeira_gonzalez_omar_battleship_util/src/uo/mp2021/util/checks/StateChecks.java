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
	 * M�todo que analiza si la condici�n se cumple, en caso contrario, lanza 
	 * la excepci�n
	 * 
	 * @param condition, condici�n a analizar
	 */
	public static void isTrue(boolean condition) {
		if (condition == true) return;
		throwException( "Condition not met" );
	}
	
	/**
	 * M�todo que analiza si la condici�n se cumple, en caso contrario, lanza 
	 * la excepci�n personalizada
	 * 
	 * @param condition, condici�n a analizar
	 * @param msg, mensaje que lanzara la excepci�n
	 */	
	public static void isTrue(boolean condition, String msg) {
		if (condition == true) return;
		throwException(msg);
	}
	
	/**
	 * M�todo que lanza la excepci�n
	 * 
	 * @param msg, excepci�n a lanzar
	 */
	private static void throwException(String msg) {
		throw new IllegalStateException( msg );
	}

}
