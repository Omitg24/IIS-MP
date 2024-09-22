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
	 * Creaci�n de objetos para su uso posterior
	 */
	@Before
	public void setUp() {
		stack = new ArrayListStack();
		Object element = "Prueba";
		stack.push(element);
	}
	
	/**
	 * Pruebas del m�todo size de la clase AbstractStack:
	 * 1- size tras hacer la operaci�n push
	 * 2- isEmpty tras hacer la operaci�n push
	 * 3- get tras hacer la operaci�n push
	 */
	
	/**
	 * 1- size tras hacer la operaci�n push
	 * GIVEN Se crea una pila
	 * WHEN Se a�ade un elemento a la pila
	 * THEN Se comprueba que el tama�o es 1
	 */
	@Test
	public void pushSize() {		
		assertEquals(1,stack.size());
	}
	
	/**
	 * 2- isEmpty tras hacer la operaci�n push
	 * GIVEN Se crea una pila
	 * WHEN Se a�ade un elemento a la pila
	 * THEN Se comprueba que no est� vac�a
	 */
	@Test
	public void pushIsEmpty() {
		assertFalse(stack.isEmpty());
	}
	
	/**
	 * 3- get tras hacer la operaci�n push
	 * GIVEN Se crea una pila
	 * WHEN Se a�ade un elemento a la pila
	 * THEN Se comprueba que tiene al elemento almacenado
	 */
	@Test
	public void pushPeek() {
		assertEquals("Prueba", stack.peek());
	}
}
