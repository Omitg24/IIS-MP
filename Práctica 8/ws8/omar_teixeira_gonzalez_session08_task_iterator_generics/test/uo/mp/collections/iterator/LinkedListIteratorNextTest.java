package uo.mp.collections.iterator;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.impl.LinkedList;

/**
 * Titulo: Clase LinkedListIteratorNextTest
 * 
 * @author Omitg
 * @version 30-03-2021
 * @param <T>, parámetro generico
 */
public class LinkedListIteratorNextTest<T> extends ListIteratorNextTest<T> {
	
	/**
	 * Creación de objetos para su posterios uso
	 */
	@Before
	public void setUp() {
		list = new LinkedList<T>();		
	}
	
	/**
	 * Pruebas del método next:
	 * 1- Lista vacía
	 * 2- Lista con un solo elemento
	 * 3- Lista con varios elementos
	 * 4- Lista con varios elementos, estamos en la ultima posición
	 */
	
	/**
	 * 2- Lista con un elemento
	 * GIVEN Se crea una lista con un elemento
	 * WHEN Se llama al método next
	 * THEN Se comprueba que es igual al primer elemento
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void oneElement() {		
		list.add((T) "1");
		listIterator = list.iterator();	
		assertEquals("1",listIterator.next());
	}	
	
	/**
	 * 3- Lista con varios elementos
	 * GIVEN Se crea una lista con varios elementos
	 * WHEN Se llama al método next
	 * THEN Se comprueba que es igual al segundo elemento
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
		assertEquals("2",listIterator.next());
	}
	
	/**
	 * 4- Lista con varios elementos y ultima posición
	 * GIVEN Se crea una lista con varios elementos y en la ultima posición
	 * WHEN Se llama al método next
	 * THEN Se lanza la excepción
	 */
	@SuppressWarnings("unchecked")
	@Test
	(expected=NoSuchElementException.class)
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
		listIterator.next();
	}
}
