package uo.mp2021.util.log;

/**
 * Titulo: Interfaz SimpleLogger
 * 
 * Descripción: Interfaz que contiene el método log para que se implemente en 
 * la clase ConsoleSimpleLogger
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public interface SimpleLogger {
	/**
	 * Método que muestra errores
	 * 
	 * @param ex, Excepción
	 */
	void log(Exception ex);
}
