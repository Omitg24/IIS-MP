package uo.mp.collections.impl.queue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.queue.AbstractQueue;
import uo.mp.collections.queue.ArrayListQueue;

/**
 * Titulo: Clase ArrayQueueIsEmptyTest
 * 
 * @author Omitg
 * @version 30-02-2021
 */
public class ArrayQueueIsEmptyTest {
	/**
	 * Atributo cola
	 */
	private AbstractQueue queue;
	
	/**
	 * Creación de objetos para su uso posterior
	 */
	@Before
	public void setUp() {
		queue = new ArrayListQueue();
		Object element = "Prueba";
		queue.enqueue(element);
	}
	
	/**
	 * Pruebas del método isEmpty de la clase AbstractQueue:
	 * 1- Sobre una cola nueva
	 * 2- Sobre una cola vacía
	 */
	
	/**
	 * 1- Sobre una cola nueva
	 * GIVEN Se crea una cola
	 * WHEN Se llama al método isEmpty
	 * THEN Se comprueba que devuelve true
	 */
	@Test
	public void newStack() {		
		assertTrue(new ArrayListQueue().isEmpty());
	}
	
	/**
	 * 2- Sobre una cola vacía
	 * GIVEN Se crea una cola
	 * WHEN Se llama al método isEmpty
	 * THEN Se comprueba que devuelve true
	 */
	@Test
	public void emptyStack() {		
		assertFalse(queue.isEmpty());
	}
}