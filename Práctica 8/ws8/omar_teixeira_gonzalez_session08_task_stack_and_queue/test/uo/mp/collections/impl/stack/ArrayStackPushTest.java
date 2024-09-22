package uo.mp.collections.impl.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.stack.AbstractStack;
import uo.mp.collections.stack.ArrayListStack;

/**
 * Titulo: Clase ArratStackPushTest
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class ArrayStackPushTest {
	
	/**
	 * Atributo pila
	 */
	private AbstractStack stack;
	
	/**
	 * Creación de objetos para su uso posterior
	 */
	@Before
	public void setUp() {
		stack = new ArrayListStack();
		Object element = "Prueba";
		stack.push(element);
	}
	
	/**
	 * Pruebas del método size de la clase AbstractStack:
	 * 1- size tras hacer la operación push
	 * 2- isEmpty tras hacer la operación push
	 * 3- get tras hacer la operación push
	 */
	
	/**
	 * 1- size tras hacer la operación push
	 * GIVEN Se crea una pila
	 * WHEN Se añade un elemento a la pila
	 * THEN Se comprueba que el tamaño es 1
	 */
	@Test
	public void pushSize() {		
		assertEquals(1,stack.size());
	}
	
	/**
	 * 2- isEmpty tras hacer la operación push
	 * GIVEN Se crea una pila
	 * WHEN Se añade un elemento a la pila
	 * THEN Se comprueba que no está vacía
	 */
	@Test
	public void pushIsEmpty() {
		assertFalse(stack.isEmpty());
	}
	
	/**
	 * 3- get tras hacer la operación push
	 * GIVEN Se crea una pila
	 * WHEN Se añade un elemento a la pila
	 * THEN Se comprueba que tiene al elemento almacenado
	 */
	@Test
	public void pushPeek() {
		assertEquals("Prueba", stack.peek());
	}
}
