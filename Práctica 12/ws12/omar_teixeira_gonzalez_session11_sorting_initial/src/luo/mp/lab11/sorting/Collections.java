package luo.mp.lab11.sorting;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Titulo: Clase Collections
 * 
 * @author Omitg
 * @version 22-04-2021
 */
public class Collections {
	
	/**
	 * M�todo que ordena la lista
	 * @param <T>, generico
	 * 
	 * @param list, lista a ordenar
	 */
	public static <T> void sort(List<T> list) {
		List<T> sortedList = new LinkedList<T>();
		for (T element : list) {
			int position = findPositionElement(element, sortedList);
			sortedList.add(position, element);
		}
		makeCopy(sortedList, list);
	}	
	
	/**
	 * M�todo que hace una copia de una lista a otra lista
	 * @param <T>
	 * 
	 * @param sortedList, lista a copiar
	 * @param list, lista donde se copiara
	 */
	private static <T> void makeCopy(List<T> sortedList, List<T> list) {
		list.clear();
		for (T element : sortedList) {
			list.add(element);
		}
	}

	/**
	 * M�todo que busca la posicion en la que a�adir el elemento
	 * @param <T>
	 * 
	 * @param element, elemento a a�adir
	 * @param sortedList, lista en la que a�adir
	 * @return i, posicion donde a�adir
	 */
	@SuppressWarnings("unchecked")
	private static <T> int findPositionElement(T element, List<T> sortedList) {
		int i = 0;
		for (T elementInSorted : sortedList) {
			if (((Comparable<T>) elementInSorted).compareTo(element)>0) {
				return i;
			}
			i++;
		}		
		return sortedList.size();
	}
	
	/**
	 * M�todo que ordena la lista
	 * 
	 * @param <T>, tipo generico
	 * @param list, lista que ordenar
	 * @param comparator, comparador
	 */
	public static <T> void sort(List<T> list, Comparator<T> comparator) {
		List<T> sortedList = new LinkedList<T>();
		for (T element : list) {
			int position = findPositionElement(element, sortedList, comparator);
			sortedList.add(position, element);
		}
		makeCopy(sortedList, list);
	}
	
	/**
	 * M�todo que busca la posicion en la que a�adir el elemento
	 * 
	 * @param <T>, tipo generico
	 * @param element, elemento
	 * @param sortedList, lista en la que a�adir
	 * @param comparator, comparador
	 * @return i, posicion donde a�adir
	 */
	private static <T> int findPositionElement(T element, List<T> sortedList, Comparator<T> comparator) {
		int i = 0;
		for (T elementInSorted : sortedList) {
			if (comparator.compare(elementInSorted, element)>0) {
				return i;
			}
			i++;
		}		
		return sortedList.size();
	}
}
