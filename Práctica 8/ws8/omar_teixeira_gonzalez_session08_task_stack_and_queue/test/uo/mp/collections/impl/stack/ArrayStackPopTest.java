package uo.mp.collections.impl.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.stack.AbstractStack;
import uo.mp.collections.stack.ArrayListStack;

/**
 * Titulo: ArrayStackPopTest
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class ArrayStackPopTest {
	
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
		stack.pop();
	}
	
	/**
	 * Pruebas del método pop de la clase AbstractStack:
	 * 1- Pop sobre una lista vacía
	 * 2- size tras realizar pop sobre una pila no vacía
	 * 3- isEmpty tras realizar pop sobre una pila no vacía
	 * 4- peek tras realizar pop sobre una pila no vacía
	 */
	
	/**
	 * 1- Pop sobre una lista vacía
	 * GIVEN Se crea una pila vacía
	 * WHEN Se intenta eliminar un elemento a la pila
	 * THEN Se lanza la excepción
	 */
	@Test
	(expected=IllegalStateException.class)
	public void emptyList() {
		new ArrayListStack().pop();
	}
	
	/**
	 * 2- size tras realizar pop sobre una pila no vacía
	 * GIVEN Se crea una pila y se añade un elemento
	 * WHEN Se elimina un elemento a la pila
	 * THEN Se comprueba que el tamaño es 0
	 */
	@Test
	public void pushSize() {		
		assertEquals(0,stack.size());
	}
	
	/**
	 * 3- isEmpty tras realizar pop sobre una pila no vacía
	 * GIVEN Se crea una pila y se añade un elemento
	 * WHEN Se elimina un elemento a la pila
	 * THEN Se comprueba que está vacía
	 */
	@Test
	public void pushIsEmpty() {
		assertTrue(stack.isEmpty());
	}
	
	/**
	 * 4- peek tras realizar pop sobre una pila no vacía
	 * GIVEN Se crea una pila y se añade un elemento
	 * WHEN Se elimina el elemento a la pila y se intenta obtener el elemento
	 * THEN Se lanza la excepcióh
	 */
	@Test
	(expected = IllegalStateException.class)
	public void pushPeek() {
		stack.peek();
	}
}