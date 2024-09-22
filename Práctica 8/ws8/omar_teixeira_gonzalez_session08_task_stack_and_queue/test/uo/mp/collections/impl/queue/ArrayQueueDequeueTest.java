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
	 * Creaci�n de objetos para su uso posterior
	 */
	@Before
	public void setUp() {
		queue = new ArrayListQueue();
		Object element = "Prueba";
		queue.enqueue(element);
		queue.dequeue();
	}
	
	/**
	 * Pruebas del m�todo dequeue de la clase AbstractQueue:
	 * 1- Dequeue sobre lista vac�a
	 * 2- size tras realizar dequeue sobre lista no vac�a
	 * 3- isEmpty tras realizar dequeue sobre lista no vac�a
	 * 4- peek tras realizad dequeue sobre una lista no vac�a
	 */
	
	/**
	 * 1- Dequeue sobre lista vac�a
	 * GIVEN Se crea una lista vac�a
	 * WHEN Se llama al m�todo dequeue
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected=IllegalStateException.class)
	public void emptyList() {
		new ArrayListQueue().dequeue();
	}
	
	/**
	 * 2- size tras realizar dequeue sobre lista no vac�a
	 * GIVEN Se crea una lista con un elemento
	 * WHEN Se elimina ese elemento, se llama al m�todo size
	 * THEN Se comprueba que el tama�o es 0
	 */
	@Test
	public void dequeueSize() {
		assertEquals(0, queue.size());
	}

	/**
	 * 3- isEmpty tras realizar dequeue sobre lista no vac�a
	 * GIVEN Se crea una lista con un elemento
	 * WHEN Se elimina ese elemento, se llama al m�todo isEmpty
	 * THEN Se comprueba que esta vac�a
	 */
	@Test
	public void dequeueIsEmtpy() {
		assertTrue(queue.isEmpty());
	}
	
	/**
	 * 4- peek tras realizad dequeue sobre una lista no vac�a
	 * GIVEN Se crea una lista con un elemento
	 * WHEN Se elimina ese elemento, se llama al m�todo peek
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected=IllegalStateException.class)
	public void dequeuePeek() {
		queue.peek();
	}
}
