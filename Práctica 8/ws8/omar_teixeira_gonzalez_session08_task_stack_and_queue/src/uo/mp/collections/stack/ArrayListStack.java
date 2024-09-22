package uo.mp.collections.stack;

import uo.mp.collections.impl.ArrayList;

/**
 * Titulo: Clase ArrayListStack
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class ArrayListStack extends AbstractStack{
	
	/**
	 * Constructor sin par�metros que crea un ArrayList
	 */
	public ArrayListStack() {
		list = new ArrayList();
	}
}
