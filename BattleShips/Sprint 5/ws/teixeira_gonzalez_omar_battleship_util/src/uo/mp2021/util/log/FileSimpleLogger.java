package uo.mp2021.util.log;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Titulo: Clase FileSimpleLogger 
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public class FileSimpleLogger implements SimpleLogger {
	/**
	 * Constante FOR_APPENDING
	 */
	public static final boolean FOR_APPENDING = true;
	
	/**
	 * Atributo logFile
	 */
	private String logFile;
	
	/**
	 * Constructor con parámetro logFile
	 * 
	 * @param logFile, fichero donde escribir
	 */
	public FileSimpleLogger(String logFile) {
		this.logFile=logFile;
	}

	/**
	 * Método que escribe en el fichero cada vez que se le llama
	 */
	@Override
	public void log(Exception ex) {
		Date d = new Date();
		String date = new SimpleDateFormat("dd/MM/yy").format(d);
		String time = new SimpleDateFormat("HH:mm:ss").format(d);		
		String text = "[" + date + " - " + time + "] : Error de " + ex.getClass() + ". " + ex.getMessage() + "\n";
		try {
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(logFile, FOR_APPENDING)));
			writer.write(text);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
