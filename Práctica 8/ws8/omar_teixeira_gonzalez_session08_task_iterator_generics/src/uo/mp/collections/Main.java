package uo.mp.collections;

import uo.mp.collections.ui.Application;

/**
 * Titulo: Clase Main
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class Main {
	
	/**
	 * Método estatico que lanza el programa
	 * @param <T>, parámetro generico
	 * 
	 * @param args, argumento a analizar
	 */
	public static <T> void main(String[] args) {
		new Application<T>().run();
	}
}
