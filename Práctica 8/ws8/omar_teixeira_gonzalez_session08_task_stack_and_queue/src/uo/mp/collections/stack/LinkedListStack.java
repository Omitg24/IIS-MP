package uo.mp.collections.stack;

import uo.mp.collections.impl.LinkedList;

/**
 * Titulo: Clase LinkedListStack
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class LinkedListStack extends AbstractStack{
	
	/**
	 * Constructor sin par�metros que crea un LinkedList
	 */
	public LinkedListStack() {
		list = new LinkedList();
	}
}
