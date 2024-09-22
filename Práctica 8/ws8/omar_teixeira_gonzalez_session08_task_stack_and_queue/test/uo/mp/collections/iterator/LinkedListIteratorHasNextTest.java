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
public class LinkedListIteratorHasNextTest extends ListIteratorHasNextTest {

	/**
	 * Creaci�n de objetos para su posterios uso
	 */
	@Before
	public void setUp() {
		list = new LinkedList();		
	}
	
	/**
	 * Casos de prueba:
	 * 1- Lista vac�a
	 * 2- Lista con un elemento
	 * 3- Lista con varios elementos
	 * 4- Lista con varios elementos y ultima posici�n
	 */
	
	/**
	 * 2- Lista con un elemento
	 * GIVEN Se crea una lista con un elemento
	 * WHEN Se llama al m�todo hasNext
	 * THEN Se comprueba que devuelve true
	 */
	@Test
	public void oneElement() {		
		list.add("1");
		listIterator = list.iterator();	
		assertTrue(listIterator.hasNext());
	}	
	
	/**
	 * 3- Lista con varios elementos
	 * GIVEN Se crea una lista con varios elementos
	 * WHEN Se llama al m�todo hasNext
	 * THEN Se comprueba que devuelve true
	 */
	@Test
	public void variousElements() {			
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		listIterator = list.iterator();
		listIterator.next();
		assertTrue(listIterator.hasNext());
	}
	
	/**
	 * 4- Lista con varios elementos y ultima posici�n
	 * GIVEN Se crea una lista con varios elementos y en la ultima posici�n
	 * WHEN Se llama al m�todo hasNext
	 * THEN Se comprueba que devuelve false
	 */
	@Test
	public void variousElementsLastPosition() {			
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");		
		listIterator = list.iterator();
		listIterator.next();
		listIterator.next();
		listIterator.next();
		listIterator.next();
		listIterator.next();
		assertFalse(listIterator.hasNext());
	}	
}
