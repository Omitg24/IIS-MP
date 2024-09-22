package uo.mp.collections.impl.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.queue.AbstractQueue;
import uo.mp.collections.queue.ArrayListQueue;

/**
 * Titulo: CLase ArrayQueueDequeueTest
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class ArrayQueueDequeueTest {
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
		queue.dequeue();
	}
	
	/**
	 * Pruebas del método dequeue de la clase AbstractQueue:
	 * 1- Dequeue sobre lista vacía
	 * 2- size tras realizar dequeue sobre lista no vacía
	 * 3- isEmpty tras realizar dequeue sobre lista no vacía
	 * 4- peek tras realizad dequeue sobre una lista no vacía
	 */
	
	/**
	 * 1- Dequeue sobre lista vacía
	 * GIVEN Se crea una lista vacía
	 * WHEN Se llama al método dequeue
	 * THEN Se lanza la excepción
	 */
	@Test
	(expected=IllegalStateException.class)
	public void emptyList() {
		new ArrayListQueue().dequeue();
	}
	
	/**
	 * 2- size tras realizar dequeue sobre lista no vacía
	 * GIVEN Se crea una lista con un elemento
	 * WHEN Se elimina ese elemento, se llama al método size
	 * THEN Se comprueba que el tamaño es 0
	 */
	@Test
	public void dequeueSize() {
		assertEquals(0, queue.size());
	}

	/**
	 * 3- isEmpty tras realizar dequeue sobre lista no vacía
	 * GIVEN Se crea una lista con un elemento
	 * WHEN Se elimina ese elemento, se llama al método isEmpty
	 * THEN Se comprueba que esta vacía
	 */
	@Test
	public void dequeueIsEmtpy() {
		assertTrue(queue.isEmpty());
	}
	
	/**
	 * 4- peek tras realizad dequeue sobre una lista no vacía
	 * GIVEN Se crea una lista con un elemento
	 * WHEN Se elimina ese elemento, se llama al método peek
	 * THEN Se lanza la excepción
	 */
	@Test
	(expected=IllegalStateException.class)
	public void dequeuePeek() {
		queue.peek();
	}
}
