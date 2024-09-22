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
	 * Creaci�n de objetos para su uso posterior
	 */
	@Before
	public void setUp() {
		stack = new ArrayListStack();		
		Object element = "Prueba";
		stack.push(element);
		stack.peek();
	}
	
	/**
	 * Pruebas del m�todo peek de la clase AbstractStack:
	 * 1- peek sobre una lista vac�a
	 * 2- size tras realizar peek sobre una pila no vac�a
	 * 3- isEmpty tras realizar peek sobre una pila no vac�a
	 * 4- peek tras realizar peek sobre una pila no vac�a
	 */
	
	/**
	 * 1- peek sobre una lista vac�a
	 * GIVEN Se crea una pila vac�a
	 * WHEN Se intenta obtener el elemento de la pila
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected=IllegalStateException.class)
	public void emptyList() {
		new ArrayListStack().peek();
	}
	
	/**
	 * 2- size tras realizar peek sobre una pila no vac�a
	 * GIVEN Se crea una pila y se a�ade un elemento
	 * WHEN Se obtiene el elemento de la pila
	 * THEN Se comprueba que el tama�o es 1
	 */
	@Test
	public void pushSize() {		
		assertEquals(1,stack.size());
	}
	
	/**
	 * 3- isEmpty tras realizar peek sobre una pila no vac�a
	 * GIVEN Se crea una pila y se a�ade un elemento
	 * WHEN Se obtiene el elemento de la pila
	 * THEN Se comprueba que no est� vac�a
	 */
	@Test
	public void pushIsEmpty() {
		assertFalse(stack.isEmpty());
	}
	
	/**
	 * 4- peek tras realizar peek sobre una pila no vac�a
	 * GIVEN Se crea una pila y se a�ade un elemento
	 * WHEN Se obtiene el elemento de la pila
	 * THEN Se lanza la excepci�h
	 */
	@Test
	public void pushPeek() {
		stack.peek();
	}
}
