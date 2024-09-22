package uo.mp2021.log;

import java.io.PrintStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import uo.mp2021.file.FileUtil;

/**
 * Titulo: Clase Logger
 * 
 * A very basic implementation of a logger utility. For this the date are sent
 * to the System.err standard output. The format of every lines is: timestamp
 * message
 * 
 * @author Omitg
 * @version 07-04-2021
 */
public class Logger {
	/**
	 * Atributo out
	 */
	private static PrintStream out = System.err;
	/**
	 * Atributo fileUtil
	 */
	private static FileUtil fu = new FileUtil();

	/**
	 * Sends the string received as message to the log prefixing it with a timestamp
	 * 
	 * @param message, mensaje
	 */
	public static void log(String message) {
		out.print(new Date() + " ");
		out.println(message);
		logWrite();
	}

	/**
	 * Sends the full stack trace of the exception received to the log prefixing it
	 * with a timestamp
	 * 
	 * @param t, the exception to be logged
	 */
	public static void log(Throwable t) {
		out.print(new Date() + " ");
		t.printStackTrace(out);
		logWrite();
	}

	/**
	 * Método que escribe una nueva linea en el fichero
	 */
	public static void logWrite() {
		List<String> list = new LinkedList<>();
		list.add("New call");
		fu.writeLines("logFile", list);
	}
}
