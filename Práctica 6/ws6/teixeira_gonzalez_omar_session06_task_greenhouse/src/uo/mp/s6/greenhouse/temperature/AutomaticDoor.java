package uo.mp.s6.greenhouse.temperature;

import java.util.Random;

import uo.mp.s6.greenhouse.scanner.Checkable;

/**
 * Titulo: Clase AutomaticDoor
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public class AutomaticDoor implements Doorable, Checkable{
	/**
	 * Atributo abierto
	 */
	private boolean opened = false;
	/**
	 * Atributo id de la puerta
	 */
	private int id;
	
	/**
	 * Constructor que crea la puerta
	 * 
	 * @param id, id de la puerta
	 */
	public AutomaticDoor(int id) {
		this.id = id;
	}
	
	/**
	 * M�todo que devuelve si la puerta esta abierta
	 */
	public boolean isOpened() {
		return this.opened;
	}
	
	/**
	 * M�todo que abre la puerta
	 */
	public void open(){
		if ( ! opened) {
			showOpeningMessage();
			opened = true;
		}
	}
	
	/**
	 * M�todo que cierra la puerta
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
		System.out.println ("  -> La puerta automatica " + id + " se esta abriendo");
	}
	
	/**
	 * M�todo que lanza un mensaje de salida
	 */
	protected void showClosingMessage() {
		System.out.println ("  -> La puerta automatica " + id + " se esta cerando");
	}
	
	/**
	 * M�todo que imprime los datos de la puerta
	 */
	public String toString() {
		return "AutomaticDoor [id=" + id + "]";
	}

	/**
	 * M�todo que checkea el estado de la puerta
	 * 
	 * @return true o false si la puerta esta estropeada
	 */
	@Override
	public boolean check() {
		int probability = new Random().nextInt(100);
		if (probability<=5) {
			return false;
		} else {
			return true;
		}
	}
}