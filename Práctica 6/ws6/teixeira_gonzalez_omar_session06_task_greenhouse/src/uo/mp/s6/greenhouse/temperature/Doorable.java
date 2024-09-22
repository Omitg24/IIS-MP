package uo.mp.s6.greenhouse.temperature;

/**
 * Titulo: Interfaz Doorable
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public interface Doorable {
	/**
	 * Método que abre la puerta
	 */
	void open();
	/**
	 * Método que cierra la puerta
	 */
	void close();
	/**
	 * Método que devuelve si la puerta esta cerrada o abierta
	 * 
	 * @return true si esta abierta, y false en caso contrario
	 */
	boolean isOpened();
}
