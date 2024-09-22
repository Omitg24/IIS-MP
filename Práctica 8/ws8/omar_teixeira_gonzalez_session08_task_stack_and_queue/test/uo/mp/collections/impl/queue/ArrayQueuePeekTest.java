package uo.mp.collections.impl.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.queue.AbstractQueue;
import uo.mp.collections.queue.ArrayListQueue;

/**
 * Titulo: Clase ArrayQueuePeekTest
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class ArrayQueuePeekTest {
	
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
	 * Pruebas del método peek de la clase AbstractQueue:
	 * 1- peek sobre una lista vacía
	 * 2- size tras realizar peek sobre una cola no vacía
	 * 3- isEmpty tras realizar peek sobre una cola no vacía
	 * 4- peek tras realizar peek sobre una cola no vacía
	 */
	
	/**
	 * 1- peek sobre una lista vacía
	 * GIVEN Se crea una cola vacía
	 * WHEN Se intenta obtener el elemento de la pila
	 * THEN Se lanza la excepción
	 */
	@Test
	(expected=IllegalStateException.class)
	public void emptyList() {
		new ArrayListQueue().peek();
	}
	
	/**
	 * 2- size tras realizar peek sobre una cola no vacía
	 * GIVEN Se crea una cola y se añade un elemento
	 * WHEN Se obtiene el elemento de la cola
	 * THEN Se comprueba que el tamaño es 1
	 */
	@Test
	public void pushSize() {		
		assertEquals(1,queue.size());
	}
	
	/**
	 * 3- isEmpty tras realizar peek sobre una cola no vacía
	 * GIVEN Se crea una cola y se añade un elemento
	 * WHEN Se obtiene el elemento de la cola
	 * THEN Se comprueba que no está vacía
	 */
	@Test
	public void pushIsEmpty() {
		assertFalse(queue.isEmpty());
	}
	
	/**
	 * 4- peek tras realizar peek sobre una cola no vacía
	 * GIVEN Se crea una cola y se añade un elemento
	 * WHEN Se obtiene el elemento de la cola
	 * THEN Se lanza la excepcióh
	 */
	@Test
	public void pushPeek() {
		queue.peek();
	}
}
