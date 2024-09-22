package uo.mp.collections.setting;

import uo.mp.collections.List;
import uo.mp.collections.impl.LinkedList;

/**
 * Titulo: Clase LinkedListFactory
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class LinkedListFactory implements ListFactory {
	
	/**
	 * Creación de listas
	 * 
	 * @return LinkedList
	 */
	@Override
	public List newList() {
		return new LinkedList();
	}

}
