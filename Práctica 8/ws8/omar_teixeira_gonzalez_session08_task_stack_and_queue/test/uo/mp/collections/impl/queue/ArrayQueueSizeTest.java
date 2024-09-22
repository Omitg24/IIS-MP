package uo.mp.collections.impl.queue;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.queue.AbstractQueue;
import uo.mp.collections.queue.ArrayListQueue;

/**
 * Titulo: Clase ArrayQueueSizeTest
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class ArrayQueueSizeTest {
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
	}
	
	/**
	 * Pruebas del m�todo size de la clase AbstractQueue:
	 * 1- Sobre una cola nueva
	 * 2- Sobre una cola vac�a
	 */
	
	/**
	 * 1- Sobre una cola nueva
	 * GIVEN Se crea una cola
	 * WHEN Se llama al m�todo size
	 * THEN Se comprueba que devuelve 0
	 */
	@Test
	public void newStack() {		
		assertEquals(0,new ArrayListQueue().size());
	}
	
	/**
	 * 2- Sobre una cola vac�a
	 * GIVEN Se crea una cola
	 * WHEN Se llama al m�todo size
	 * THEN Se comprueba que devuelve 0
	 */
	@Test
	public void emptyStack() {
		assertEquals(0, queue.size());
	}
}