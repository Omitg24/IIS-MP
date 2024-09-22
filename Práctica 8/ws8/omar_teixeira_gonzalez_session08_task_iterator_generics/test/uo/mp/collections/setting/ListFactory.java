package uo.mp.collections.setting;

import uo.mp.collections.List;

/**
 * Titulo: Interfaz ListFactory
 * 
 * @author Omitg
 * @version 30-03-2021
 * @param <T>, parámetro generico
 */
public interface ListFactory<T> {
	/**
	 * Factoria de listas
	 * 
	 * @return List, listas 
	 */
	List<T> newList();

}
