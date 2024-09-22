package uo.mp.collections.setting;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;

/**
 * Titulo: Clase ArrayListFactory
 *  
 * @author Omitg
 * @version 30-03-2021
 * @param <T>, parámetro generico
 */
public class ArrayListFactory<T> implements ListFactory<T> {
	
	/**
	 * Creación de listas
	 * 
	 * @return ArrayList
	 */
	@Override
	public List<T> newList() {
		return new ArrayList<T>();
	}

}
