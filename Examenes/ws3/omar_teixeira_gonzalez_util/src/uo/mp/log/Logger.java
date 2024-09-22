package uo.mp.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Titulo: Clase Logger
 * 
 * A very basic implementation of a logger utility. For this the date are sent
 * to the System.err standard output. The format of every lines is: timestamp
 * message
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public class Logger {
	/**
	 * Constant LOG_FILE_NAME
	 */
	private static final String LOG_FILE_NAME = "shopper.log";
	/**
	 * Constant APPEND
	 */
	private static final boolean APPEND = true;

	/**
	 * Sends the string received as message to the log prefixing it with a timestamp
	 * 
	 * @param message, mensaje
	 */
	public static void log (String message) {
		appendToLog(new Date() + " " +  message);
	}	
	
	/**
	 * Sends the full stack trace of the exception received to the log prefixing it
	 * with a timestamp
	 * 
	 * @param t, the exception to be logged
	 */
	public static void log(Throwable t) {
		try {
			PrintWriter out = createPrintWriterForAppend();
			try {
				out.print(new Date() + " ");
				t.printStackTrace(out);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * Method that adds a message to the logger register
	 * 
	 * @param msg, message to write
	 */
	private static void appendToLog(String msg) {
		try {
			PrintWriter out = createPrintWriterForAppend();
			try {
				out.print(msg);				
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}		
	}	

	/**
	 * Method that will open the file in order to write in it with other methods
	 * 
	 * @return PrintWriter, file opening
	 * @throws IOException
	 */
	private static PrintWriter createPrintWriterForAppend() throws IOException{
		return new PrintWriter(new FileWriter(LOG_FILE_NAME, APPEND));
	}
}
