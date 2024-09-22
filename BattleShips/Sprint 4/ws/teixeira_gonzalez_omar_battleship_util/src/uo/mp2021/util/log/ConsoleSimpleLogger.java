package uo.mp2021.util.log;

/**
 * Titulo: Clase ConsoleSimpleLogger
 * 
 * Descripción: Clase que implementa el método log de la interfaz SimpleLogger
 * 
 * @author Omitg
 * @version 16-04-2021
 */
public class ConsoleSimpleLogger implements SimpleLogger {
	
	/**
	 * Método que muestra errores
	 */
	@Override
	public void log(Exception ex) {
		System.err.println( "This is a fake implementation of a simple logger" );
		System.err.println( "This information should go to a more sofisticated log system" );
		ex.printStackTrace();	}

}
