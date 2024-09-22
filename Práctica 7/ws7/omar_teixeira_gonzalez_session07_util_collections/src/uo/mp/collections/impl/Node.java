package uo.mp.collections.impl;

/**
 * Titulo: Clase Node
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public class Node {
	/**
	 * Objeto value
	 */
	Object value;
	/**
	 * Siguiente nodo
	 */
	Node next;
	
	/**
	 * Constructor Node
	 * 
	 * @param value, objeto
	 * @param next, siguiente 
	 */
	Node (Object value, Node next) {
		this.value = value;
		this.next = next;
	}
}
