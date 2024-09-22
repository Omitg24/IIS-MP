package uo.mp2021.util.log;

/**
 * Titulo: Interfaz SimpleLogger
 * 
 * Descripci�n: Interfaz que contiene el m�todo log para que se implemente en 
 * la clase ConsoleSimpleLogger
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public interface SimpleLogger {
	/**
	 * M�todo que muestra errores
	 * 
	 * @param ex, Excepci�n
	 */
	void log(Exception ex);
}
