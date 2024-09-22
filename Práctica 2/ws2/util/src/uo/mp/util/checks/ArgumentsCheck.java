package uo.mp.util.checks;

/**
 * <p>
 * Título: Clase ArgumentsChecks
 * </p>
 * Descripción: Clase auxiliar usada para ser llamada a traves 
 * de otras clase y usar el control de parámetros
 * 
 * 
 * @author Omitg
 * @version 12/02/2021
 */
public class ArgumentsCheck {

	/**
	 * Comprueba que la condición sea verdadera y en caso de no serlo lanza IllegalArgumentException
	 * 
	 * @param condition, condición a evaluar
	 * @param msg, mensaje
	 */
	public static void isTrue (boolean condition, String msg) {
		if (!condition) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	/**
	 * Comprueba que la condición sea verdadera y en caso de no serlo lanza IllegalArgumentException
	 * 
	 * @param condition, condición a evaluar
	 */
	public static void isTrue (boolean condition) {
		if (!condition) {
			throw new IllegalArgumentException();
		}
	}

}
