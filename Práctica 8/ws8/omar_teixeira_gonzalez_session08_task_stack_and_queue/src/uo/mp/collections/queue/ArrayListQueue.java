package uo.mp.collections.queue;

import uo.mp.collections.impl.ArrayList;

/**
 * Titulo: Clase ArrayListQueue
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class ArrayListQueue extends AbstractQueue{
	
	/**
	 * Constructor sin parámetros que crea un ArrayList
	 */
	public ArrayListQueue() {
		list = new ArrayList();
	}
}
