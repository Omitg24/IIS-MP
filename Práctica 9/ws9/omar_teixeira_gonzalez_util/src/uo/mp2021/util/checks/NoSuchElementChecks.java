package uo.mp2021.util.checks;

import java.util.NoSuchElementException;

/**
 * Titulo: Clase NoSuchElementChecks
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class NoSuchElementChecks {
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
	 * N�todo estatico que analiza el argumento
	 * 
	 * @param condition, condici�n a analizar
	 */
	public static void isTrue (boolean condition) {
		outputMessage = DEFAULT_MESSAGE;
		if(!condition) {
			throw new NoSuchElementException(outputMessage);
		}
	}
	
	/**
	 * N�todo estatico que analiza el argumento
	 * 
	 * @param condition, condici�n a analizar
	 * @param msg, mensaje a lanzar
	 */
	public static void isTrue (boolean condition, String msg) {
		outputMessage = DEFAULT_MESSAGE;
		if(!condition) {
			throw new NoSuchElementException(msg);
		}
	}
}
