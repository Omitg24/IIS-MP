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
public class Application {
	/**
	 * Método que lanza el programa
	 */
	public void run() {
		System.out.println("--------------------------- Collections ---------------------------");
		System.out.println("~~~~~~~~~ LinkedList ~~~~~~~~~");
		List l = new LinkedList();
		l.add("uno");
		l.add("dos");
		l.add("tres");
		
		System.out.println("Iterador: ");
		Iterator<Object> it = l.iterator();
		while (it.hasNext()) {
			System.out.println(" " + it.next());
		}
		System.out.println("\nNormal: ");
		for (Object o : l) {
			System.out.println("-> " + o);
		}
		
		System.out.println("\n~~~~~~~~~ ArrayList ~~~~~~~~~");
		List l2 = new ArrayList();
		l2.add("1");
		l2.add("2");
		l2.add("3");
		
		System.out.println("Iterador: ");
		Iterator<Object> it2 = l2.iterator();
		while (it2.hasNext()) {
			System.out.println(" " + it2.next());
		}
		System.out.println("\nNormal: ");
		for (Object o : l2) {
			System.out.println("-> " + o);
		}
	}
}
