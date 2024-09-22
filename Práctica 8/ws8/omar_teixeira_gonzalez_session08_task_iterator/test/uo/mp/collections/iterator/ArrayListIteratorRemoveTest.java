package uo.mp.collections.iterator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.impl.ArrayList;

/**
 * Titulo: Clase ArrayListIteratorRemoveTest
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class ArrayListIteratorRemoveTest extends ListIteratorRemoveTest{

	/**
	 * Creación de objetos para su posterios uso
	 */
	@Before
	public void setUp() {
		list = new ArrayList();		
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
	 * WHEN Se llama al método remove
	 * THEN Se lanza la excepción
	 */
	@Test
	(expected = IllegalStateException.class)
	public void oneElement() {		
		list.add("1");
		listIterator = list.iterator();	
		listIterator.remove();
	}	
	
	/**
	 * 3- Lista con varios elementos
	 * GIVEN Se crea una lista con varios elementos
	 * WHEN Se llama al método remove
	 * THEN Se comprueba que el tamaño es inferior
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
		listIterator.remove();
		assertEquals(4, list.size());
	}
	
	/**
	 * 4- Lista con varios elementos y ultima posición
	 * GIVEN Se crea una lista con varios elementos y en la ultima posición
	 * WHEN Se llama al método remove
	 * THEN Se comprueba que el tamaño es inferior
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
		listIterator.remove();
		assertEquals(4, list.size());
	}	
}
