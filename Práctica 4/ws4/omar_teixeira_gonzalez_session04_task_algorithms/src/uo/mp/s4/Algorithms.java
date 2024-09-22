package uo.mp.s4;

import java.util.List;

import uo.mp.util.checks.ArgumentsCheck;

/**
 * Titulo: Clase Algorithms
 * 
 * @author Omitg
 * @version 26-02-2021
 */
public class Algorithms {
	
	/**
	 * Dada una lista  objetos, busca un objeto tambi�n recibido
	 * 
	 * @param objects, lista de objetos a buscar
	 * @param obj, objeto a buscar
	 * 
	 * @return pos, posici�n que ocupa en la lista
	 */
	public static int search(List<Object> objects, Object obj) {
		ArgumentsCheck.isTrue(objects!=null && obj!=null, "Los par�metros no pueden ser null");
		int pos = 0;
		for(Object o: objects) {
			if ( o.equals( obj )) {
				return pos;
			}
			pos++;
		}
		return -1;	
	}
}
