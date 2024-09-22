package uo.mp.s6.greenhouse.temperature;

/**
 * <p>Title: Door</p>
 * <p>Description: Clase que simula una puerta.</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Escuela de Ingenier�a Inform�tica</p>
 * <p>Metodolog�a de la Programaci�n</p>
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public class ManualDoor implements Doorable{
	/**
	 * Atributo abierta
	 */
	private boolean opened = false;
	/**
	 * Atributo id de la puerta
	 */
	private int id;
	
	/**
	 * Constructor que crea la puerta con su id
	 * 
	 * @param id, id de la puerta
	 */
	public ManualDoor(int id) {
		this.id = id;
	}

	/**
	 * M�todo que devuelve si una puerta est� abierta
	 */
	public boolean isOpened() {
		return this.opened;
	}
	
	/**
	 * M�todo que abre puertas
	 */
	public void open(){
		if ( ! opened) {
			showOpeningMessage();
			opened = true;
		}
	}

	/**
	 * M�todo que cierra puertas
	 */
	public void close(){
		if ( opened) {
			showClosingMessage();
			opened = false;
		}
	}

	/**
	 * M�todo que lanza un mensaje de entrada
	 */
	protected void showOpeningMessage() {
		System.out.println ("  Por favor, abra la puerta " + id);
	}
	
	/**
	 * M�todo que lanza un mensaje de salida
	 */
	protected void showClosingMessage() {
		System.out.println ("  Por favor, cierre la puerta " + id);
	}
}
