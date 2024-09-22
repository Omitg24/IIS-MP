package uo.mp.s2.game;

import uo.mp.s2.game.ui.GameApp;

/**
 * <p>
 * T�tulo: Clase Main
 * </p>
 * <p>
 * Descripci�n: Clase que ejecuta el contenido y metodos en GameApp que,
 * a su vez ejecuta el contenido y metodos de la clase Game2048
 *  
 * Empresa: Escuela de Ingenier�a Inform�tica - Universidad de Oviedo
 * </p>
 * 
 * @author Omar Teixeira Gonz�lez
 * @version 11/02/2021
 */

public class Main {
	
	/**
	 * M�todo que ejecuta el juego
	 * 
	 * @param args, argumento a analizar
	 */
	public static void main(String[] args) {
		new GameApp().run();
	}
}
