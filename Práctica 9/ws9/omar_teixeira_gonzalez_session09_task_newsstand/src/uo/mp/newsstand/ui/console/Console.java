
package uo.mp.newsstand.ui.console;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Titulo: Clase Console
 * 
 * Offers utility methods for user-console interaction
 * 
 * @author Omitg
 * @version 07-04-2021
 */
public class Console {
	/**
	 * Constante out	
	 */
	private static PrintStream out = System.out;
	/**
	 * Constante teclado
	 */
	private static Scanner keyboard = new Scanner( System.in );

	/**
	 * Método que lee un string introducido por pantalla
	 * 
	 * @param msg, mensaje a leer
	 * @return res, string introducido
	 */
	public static String readString(String msg) {
		out.println( msg + ": ");
		keyboard.useDelimiter( System.lineSeparator() );
		String res = keyboard.next();
		keyboard.reset();
		return res;
	}
	
	/**
	 * Método que lee un entero por pantalla
	 * 
	 * @param msg, entero a leer
	 * @return nextInt, siguiente numero del teclado
	 */
	public static int readInteger(String msg) {
		out.println( msg + ": ");
		return keyboard.nextInt();
	}
	
	/**
	 * Método que imprime por pantalla en una nueva linea un texto
	 * 
	 * @param msg, mensaje a imprimir
	 */
	public static void println(String msg) {
		out.println( msg );
	}

	/**
	 * Método que imprime lo introducido por parámetros
	 * 
	 * @param fmt, string
	 * @param params, object
	 */
	public static void printf(String fmt, Object... params) {
		out.printf( fmt, params );
	}
}
