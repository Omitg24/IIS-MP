package uo.mp.collections.queue;

import uo.mp.collections.impl.LinkedList;

/**
 * Titulo: Clase LinkedListQueue
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class LinkedListQueue extends AbstractQueue{
	
	/**
	 * Constructor sin parámetros que crea un LinkedList
	 */
	public LinkedListQueue() {
		list = new LinkedList();
	}
}
