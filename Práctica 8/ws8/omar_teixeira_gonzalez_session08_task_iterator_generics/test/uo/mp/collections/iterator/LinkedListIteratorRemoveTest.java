package uo.mp.collections.iterator;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.impl.LinkedList;

/**
 * Titulo: Clase LinkedListIteratorRemoveTest
 * 
 * @author Omitg
 * @version 30-03-2021
 * @param <T>, par�metro generico
 */
public class LinkedListIteratorRemoveTest<T> extends ListIteratorRemoveTest<T>{
	
	/**
	 * Creaci�n de objetos para su posterios uso
	 */
	@Before
	public void setUp() {
		list = new LinkedList<T>();		
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
	 * WHEN Se llama al m�todo remove
	 * THEN Se lanza la excepci�n
	 */
	@SuppressWarnings("unchecked")
	@Test
	(expected = IllegalStateException.class)
	public void oneElement() {		
		list.add((T) "1");
		listIterator = list.iterator();	
		listIterator.remove();
	}	
	
	/**
	 * 3- Lista con varios elementos
	 * GIVEN Se crea una lista con varios elementos
	 * WHEN Se llama al m�todo remove
	 * THEN Se comprueba que el tama�o es inferior
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
		listIterator.remove();
		assertEquals(4, list.size());
	}
	
	/**
	 * 4- Lista con varios elementos y ultima posici�n
	 * GIVEN Se crea una lista con varios elementos y en la ultima posici�n
	 * WHEN Se llama al m�todo remove
	 * THEN Se comprueba que el tama�o es inferior
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
		listIterator.remove();
		assertEquals(4, list.size());
	}	
}