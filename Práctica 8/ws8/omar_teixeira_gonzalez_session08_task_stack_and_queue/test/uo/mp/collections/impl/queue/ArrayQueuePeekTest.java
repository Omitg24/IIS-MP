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
	 * Creaci�n de objetos para su uso posterior
	 */
	@Before
	public void setUp() {
		queue = new ArrayListQueue();
		Object element = "Prueba";
		queue.enqueue(element);
	}
	
	/**
	 * Pruebas del m�todo peek de la clase AbstractQueue:
	 * 1- peek sobre una lista vac�a
	 * 2- size tras realizar peek sobre una cola no vac�a
	 * 3- isEmpty tras realizar peek sobre una cola no vac�a
	 * 4- peek tras realizar peek sobre una cola no vac�a
	 */
	
	/**
	 * 1- peek sobre una lista vac�a
	 * GIVEN Se crea una cola vac�a
	 * WHEN Se intenta obtener el elemento de la pila
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected=IllegalStateException.class)
	public void emptyList() {
		new ArrayListQueue().peek();
	}
	
	/**
	 * 2- size tras realizar peek sobre una cola no vac�a
	 * GIVEN Se crea una cola y se a�ade un elemento
	 * WHEN Se obtiene el elemento de la cola
	 * THEN Se comprueba que el tama�o es 1
	 */
	@Test
	public void pushSize() {		
		assertEquals(1,queue.size());
	}
	
	/**
	 * 3- isEmpty tras realizar peek sobre una cola no vac�a
	 * GIVEN Se crea una cola y se a�ade un elemento
	 * WHEN Se obtiene el elemento de la cola
	 * THEN Se comprueba que no est� vac�a
	 */
	@Test
	public void pushIsEmpty() {
		assertFalse(queue.isEmpty());
	}
	
	/**
	 * 4- peek tras realizar peek sobre una cola no vac�a
	 * GIVEN Se crea una cola y se a�ade un elemento
	 * WHEN Se obtiene el elemento de la cola
	 * THEN Se lanza la excepci�h
	 */
	@Test
	public void pushPeek() {
		queue.peek();
	}
}
