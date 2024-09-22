package uo.mp.s6.greenhouse.temperature;

/**
 * Titulo: Interfaz Doorable
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public interface Doorable {
	/**
	 * M�todo que abre la puerta
	 */
	void open();
	/**
	 * M�todo que cierra la puerta
	 */
	void close();
	/**
	 * M�todo que devuelve si la puerta esta cerrada o abierta
	 * 
	 * @return true si esta abierta, y false en caso contrario
	 */
	boolean isOpened();
}
