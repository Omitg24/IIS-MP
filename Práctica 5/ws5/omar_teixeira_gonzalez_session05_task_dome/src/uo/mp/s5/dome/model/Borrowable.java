package uo.mp.s5.dome.model;

/**
 * Titulo: Interfaz Borrowable
 * 
 * @author Omitg
 * @version 04-03-2021
 */
public interface Borrowable {
	/**
	 * M�todo booleano que comprueba si un item esta disponible
	 * 
	 * @return true o false si lo esta o no
	 */
	boolean isAvailable();
	
	/**
	 * M�todo que presta un objeto
	 */
	void borrow();
	
	/**
	 * M�todo que devuelve un objeto
	 */
	void giveBack();
	
}
