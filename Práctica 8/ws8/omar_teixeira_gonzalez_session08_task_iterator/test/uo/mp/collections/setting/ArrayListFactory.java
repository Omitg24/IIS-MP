package uo.mp.collections.setting;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;

/**
 * Titulo: Clase ArrayListFactory
 *  
 * @author Omitg
 * @version 30-03-2021
 */
public class ArrayListFactory implements ListFactory {
	
	/**
	 * Creación de listas
	 * 
	 * @return ArrayList
	 */
	@Override
	public List newList() {
		return new ArrayList();
	}

}
