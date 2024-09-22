package uo.mp.console;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Titulo: Clase Console
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public class Console {
	/**
	 * Atributo out
	 */
	private static PrintStream out = System.out;
	/**
	 * Atributo in
	 */
	private static InputStream in = System.in;
	/**
	 * Atributo keyboard
	 */
	private static Scanner keyboard = new Scanner (in);
	
	/**
	 * Método que setea el flujo de salida
	 * 
	 * @param out, salida
	 */
	public static void setOut(PrintStream out) {
		Console.out = out;
	}
	
	/**
	 * Método que setea el flujo de entrada
	 * 
	 * @param in
	 */
	public static void setIn(InputStream in) {
		Console.in = in;
	}
	
	/**
	 * Método que lee un String
	 * 
	 * @param msg, mensaje previo
	 * @return res, string que se ha leido
	 */
	public static String readString(String msg) {
		out.println(msg + "; ");
		keyboard.useDelimiter(System.lineSeparator());
		String res = keyboard.next();
		keyboard.reset();
		return res;
	}
	
	/**
	 * Método que lee un int
	 * 
	 * @param msg, mensaje previo
	 * @return res, int que se ha leido
	 */
	public static int readInteger(String msg) {
		out.println(msg + "; ");
		return keyboard.nextInt();
	}
	
	/**
	 * Método que imprime por pantalla
	 * 
	 * @param msg, mensaje a imprimir
	 */
	public static void println(String msg) {
		out.println(msg);
	}
	
	/**
	 * Método que imprime por pantalla
	 * 
	 * @param fmt, mensaje a imprimir
	 * @param params, parametros
	 */
	public static void printf(String fmt, Object...params) {
		out.printf(fmt, params);
	}	
}
