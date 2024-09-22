package uo.mp.collections.ui;

import java.util.Iterator;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.collections.impl.LinkedList;

/**
 * Titulo: Clase Application
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class Application<T> {
	/**
	 * Método que lanza el programa
	 */
	@SuppressWarnings("unchecked")
	public void run() {
		System.out.println("--------------------------- Collections ---------------------------");
		System.out.println("~~~~~~~~~ LinkedList ~~~~~~~~~");
		List<T> l = new LinkedList<T>();
		l.add((T) "uno");
		l.add((T) "dos");
		l.add((T) "tres");
		
		System.out.println("Iterador: ");
		Iterator<T> it = l.iterator();
		while (it.hasNext()) {
			System.out.println(" " + it.next());
		}
		System.out.println("\nNormal: ");
		for (Object o : l) {
			System.out.println("-> " + o);
		}
		
		System.out.println("\n~~~~~~~~~ ArrayList ~~~~~~~~~");
		List<T> l2 = new ArrayList<T>();
		l2.add((T) "1");
		l2.add((T) "2");
		l2.add((T) "3");
		
		System.out.println("Iterador: ");
		Iterator<T> it2 = l2.iterator();
		while (it2.hasNext()) {
			System.out.println(" " + it2.next());
		}
		System.out.println("\nNormal: ");
		for (Object o : l2) {
			System.out.println("-> " + o);
		}
	}
}
