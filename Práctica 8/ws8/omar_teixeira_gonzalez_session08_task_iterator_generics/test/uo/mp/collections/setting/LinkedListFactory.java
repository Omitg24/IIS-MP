package uo.mp.collections.setting;

import uo.mp.collections.List;
import uo.mp.collections.impl.LinkedList;

/**
 * Titulo: Clase LinkedListFactory
 * 
 * @author Omitg
 * @version 30-03-2021
 * @param <T>, par�metro generico
 */
public class LinkedListFactory<T> implements ListFactory<T> {
	
	/**
	 * Creaci�n de listas
	 * 
	 * @return LinkedList
	 */
	@Override
	public List<T> newList() {
		return new LinkedList<T>();
	}

}
