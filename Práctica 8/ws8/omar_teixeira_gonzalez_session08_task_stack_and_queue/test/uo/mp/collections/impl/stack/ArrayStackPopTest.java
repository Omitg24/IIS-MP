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
	 * Creaci�n de objetos para su uso posterior
	 */
	@Before
	public void setUp() {
		stack = new ArrayListStack();		
		Object element = "Prueba";
		stack.push(element);
		stack.pop();
	}
	
	/**
	 * Pruebas del m�todo pop de la clase AbstractStack:
	 * 1- Pop sobre una lista vac�a
	 * 2- size tras realizar pop sobre una pila no vac�a
	 * 3- isEmpty tras realizar pop sobre una pila no vac�a
	 * 4- peek tras realizar pop sobre una pila no vac�a
	 */
	
	/**
	 * 1- Pop sobre una lista vac�a
	 * GIVEN Se crea una pila vac�a
	 * WHEN Se intenta eliminar un elemento a la pila
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected=IllegalStateException.class)
	public void emptyList() {
		new ArrayListStack().pop();
	}
	
	/**
	 * 2- size tras realizar pop sobre una pila no vac�a
	 * GIVEN Se crea una pila y se a�ade un elemento
	 * WHEN Se elimina un elemento a la pila
	 * THEN Se comprueba que el tama�o es 0
	 */
	@Test
	public void pushSize() {		
		assertEquals(0,stack.size());
	}
	
	/**
	 * 3- isEmpty tras realizar pop sobre una pila no vac�a
	 * GIVEN Se crea una pila y se a�ade un elemento
	 * WHEN Se elimina un elemento a la pila
	 * THEN Se comprueba que est� vac�a
	 */
	@Test
	public void pushIsEmpty() {
		assertTrue(stack.isEmpty());
	}
	
	/**
	 * 4- peek tras realizar pop sobre una pila no vac�a
	 * GIVEN Se crea una pila y se a�ade un elemento
	 * WHEN Se elimina el elemento a la pila y se intenta obtener el elemento
	 * THEN Se lanza la excepci�h
	 */
	@Test
	(expected = IllegalStateException.class)
	public void pushPeek() {
		stack.peek();
	}
}