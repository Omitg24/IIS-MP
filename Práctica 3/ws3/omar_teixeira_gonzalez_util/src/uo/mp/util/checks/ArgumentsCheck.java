package uo.mp.util.checks;

/**
 * <p>
 * T�tulo: Clase ArgumentsChecks
 * </p>
 * Descripci�n: Clase auxiliar usada para ser llamada a traves 
 * de otras clase y usar el control de par�metros
 * 
 * 
 * @author Omitg
 * @version 12/02/2021
 */
public class ArgumentsCheck {

	/**
	 * Comprueba que la condici�n sea verdadera y en caso de no serlo lanza IllegalArgumentException
	 * 
	 * @param condition, condici�n a evaluar
	 * @param msg, mensaje
	 */
	public static void isTrue (boolean condition, String msg) {
		if (!condition) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	/**
	 * Comprueba que la condici�n sea verdadera y en caso de no serlo lanza IllegalArgumentException
	 * 
	 * @param condition, condici�n a evaluar
	 */
	public static void isTrue (boolean condition) {
		if (!condition) {
			throw new IllegalArgumentException();
		}
	}

}
