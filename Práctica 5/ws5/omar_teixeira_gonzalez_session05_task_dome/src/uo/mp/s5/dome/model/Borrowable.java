package uo.mp.s5.dome.model;

/**
 * Titulo: Interfaz Borrowable
 * 
 * @author Omitg
 * @version 04-03-2021
 */
public interface Borrowable {
	/**
	 * Método booleano que comprueba si un item esta disponible
	 * 
	 * @return true o false si lo esta o no
	 */
	boolean isAvailable();
	
	/**
	 * Método que presta un objeto
	 */
	void borrow();
	
	/**
	 * Método que devuelve un objeto
	 */
	void giveBack();
	
}
