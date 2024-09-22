package uo.mp.collections.iterator;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.impl.ArrayList;

/**
 * Titulo: Clase ArrayListIteratorNextTest
 * 
 * @author Omitg
 * @version 30-02-2021
 */
public class ArrayListIteratorNextTest extends ListIteratorNextTest{

	/**
	 * Creaci�n de objetos para su posterios uso
	 */
	@Before
	public void setUp() {
		list = new ArrayList();		
	}
	
	/**
	 * Pruebas del m�todo next:
	 * 1- Lista vac�a
	 * 2- Lista con un solo elemento
	 * 3- Lista con varios elementos
	 * 4- Lista con varios elementos, estamos en la ultima posici�n
	 */
	
	/**
	 * 2- Lista con un elemento
	 * GIVEN Se crea una lista con un elemento
	 * WHEN Se llama al m�todo next
	 * THEN Se comprueba que es igual al primer elemento
	 */
	@Test
	public void oneElement() {		
		list.add("1");
		listIterator = list.iterator();	
		assertEquals("1",listIterator.next());
	}	
	
	/**
	 * 3- Lista con varios elementos
	 * GIVEN Se crea una lista con varios elementos
	 * WHEN Se llama al m�todo next
	 * THEN Se comprueba que es igual al segundo elemento
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
		assertEquals("2",listIterator.next());
	}
	
	/**
	 * 4- Lista con varios elementos y ultima posici�n
	 * GIVEN Se crea una lista con varios elementos y en la ultima posici�n
	 * WHEN Se llama al m�todo next
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected=NoSuchElementException.class)
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
		listIterator.next();
	}
}