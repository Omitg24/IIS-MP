package uo.mp.collections.impl.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.stack.AbstractStack;
import uo.mp.collections.stack.ArrayListStack;

/**
 * Titulo: Clase ArrayStackPeekTest
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class ArrayStackPeekTest {	

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
		stack.peek();
	}
	
	/**
	 * Pruebas del método peek de la clase AbstractStack:
	 * 1- peek sobre una lista vacía
	 * 2- size tras realizar peek sobre una pila no vacía
	 * 3- isEmpty tras realizar peek sobre una pila no vacía
	 * 4- peek tras realizar peek sobre una pila no vacía
	 */
	
	/**
	 * 1- peek sobre una lista vacía
	 * GIVEN Se crea una pila vacía
	 * WHEN Se intenta obtener el elemento de la pila
	 * THEN Se lanza la excepción
	 */
	@Test
	(expected=IllegalStateException.class)
	public void emptyList() {
		new ArrayListStack().peek();
	}
	
	/**
	 * 2- size tras realizar peek sobre una pila no vacía
	 * GIVEN Se crea una pila y se añade un elemento
	 * WHEN Se obtiene el elemento de la pila
	 * THEN Se comprueba que el tamaño es 1
	 */
	@Test
	public void pushSize() {		
		assertEquals(1,stack.size());
	}
	
	/**
	 * 3- isEmpty tras realizar peek sobre una pila no vacía
	 * GIVEN Se crea una pila y se añade un elemento
	 * WHEN Se obtiene el elemento de la pila
	 * THEN Se comprueba que no está vacía
	 */
	@Test
	public void pushIsEmpty() {
		assertFalse(stack.isEmpty());
	}
	
	/**
	 * 4- peek tras realizar peek sobre una pila no vacía
	 * GIVEN Se crea una pila y se añade un elemento
	 * WHEN Se obtiene el elemento de la pila
	 * THEN Se lanza la excepcióh
	 */
	@Test
	public void pushPeek() {
		stack.peek();
	}
}
