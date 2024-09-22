package uo.mp.collections.iterator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.impl.LinkedList;

/**
 * Titulo: Clase LinkedListIteratorHasNextTest
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class LinkedListIteratorHasNextTest<T> extends ListIteratorHasNextTest<T> {

	/**
	 * Creación de objetos para su posterios uso
	 */
	@Before
	public void setUp() {
		list = new LinkedList<T>();		
	}
	
	/**
	 * Casos de prueba:
	 * 1- Lista vacía
	 * 2- Lista con un elemento
	 * 3- Lista con varios elementos
	 * 4- Lista con varios elementos y ultima posición
	 */
	
	/**
	 * 2- Lista con un elemento
	 * GIVEN Se crea una lista con un elemento
	 * WHEN Se llama al método hasNext
	 * THEN Se comprueba que devuelve true
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void oneElement() {		
		list.add((T) "1");
		listIterator = list.iterator();	
		assertTrue(listIterator.hasNext());
	}	
	
	/**
	 * 3- Lista con varios elementos
	 * GIVEN Se crea una lista con varios elementos
	 * WHEN Se llama al método hasNext
	 * THEN Se comprueba que devuelve true
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void variousElements() {			
		list.add((T) "1");
		list.add((T) "2");
		list.add((T) "3");
		list.add((T) "4");
		list.add((T) "5");
		listIterator = list.iterator();
		listIterator.next();
		assertTrue(listIterator.hasNext());
	}
	
	/**
	 * 4- Lista con varios elementos y ultima posición
	 * GIVEN Se crea una lista con varios elementos y en la ultima posición
	 * WHEN Se llama al método hasNext
	 * THEN Se comprueba que devuelve false
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void variousElementsLastPosition() {			
		list.add((T) "1");
		list.add((T) "2");
		list.add((T) "3");
		list.add((T) "4");
		list.add((T) "5");		
		listIterator = list.iterator();
		listIterator.next();
		listIterator.next();
		listIterator.next();
		listIterator.next();
		listIterator.next();
		assertFalse(listIterator.hasNext());
	}	
}
