package uo.mp.collections.impl.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.queue.AbstractQueue;
import uo.mp.collections.queue.LinkedListQueue;

/**
 * Titulo: LinkedQueueEnqueueTest
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class LinkedQueueEnqueueTest {
	/**
	 * Atributo cola
	 */
	private AbstractQueue queue;
	
	/**
	 * Creación de objetos para su uso posterior
	 */
	@Before
	public void setUp() {
		queue = new LinkedListQueue();
		Object element = "Prueba";
		queue.enqueue(element);
	}
	
	/**
	 * Pruebas del método enqueue de la clase AbstractQueue:
	 * 1- size tras realizar enqueue
	 * 2- isEmpty tras realizar enqueue 
	 * 3- peek tras realizar enqueue
	 * 4- enqueue tras realizar enqueue
	 */
	
	/**
	 * 1- size tras realizar enqueue
	 * GIVEN Se crea una cola y se añade un elemento
	 * WHEN Se llama al método size
	 * THEN Se comprueba que es 1
	 */
	@Test
	public void enqueueSize() {
		assertEquals(1, queue.size());
	}
	
	/**
	 * 2- isEmpty tras realizar enqueue
	 * GIVEN Se crea una cola y se añade un elemento
	 * WHEN Se llama al método isEmpty
	 * THEN Se comprueba que es false
	 */
	@Test
	public void enqueueIsEmpty() {
		assertFalse(queue.isEmpty());	
	}
	
	/**
	 * 3- peek tras realizar enqueue
	 * GIVEN Se crea una cola y se añade un elemento
	 * WHEN Se llama al método peek
	 * THEN Se comprueba que se obtiene el elemento
	 */
	@Test
	public void enqueuePeek() {
		assertEquals("Prueba", queue.peek());
	}
	
	/**
	 * 4- enqueue tras realizar enqueue
	 * GIVEN Se crea una cola y se añaden dos elemento
	 * WHEN Se llama al método size
	 * THEN Se comprueba que es 2
	 */
	@Test
	public void enqueueEnqueue() {
		Object element2 = "Correcto";
		queue.enqueue(element2);
		assertEquals(2, queue.size());
	}
}
