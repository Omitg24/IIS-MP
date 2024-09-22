package uo.mp;

import uo.mp.newsstand.ui.UserInterface;

/**
 * Titulo: Clase Main
 *  
 * @author Omitg
 * @version 07-04-2021
 */
public class Main {
	
	/**
	 * M�todo que lanza el programa con el m�todo run
	 *  
	 * @param args, argumento a analizar
	 */
	public static void main(String[] args) {
		new Main().run();
	}
	
	/**
	 * M�todo que lanza el programa
	 */
	private void run() {
		new UserInterface().show();
	}

}
