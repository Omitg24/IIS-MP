package uo.mp.collections.impl.stack;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.stack.AbstractStack;
import uo.mp.collections.stack.LinkedListStack;

/**
 * Titulo: Clase LinkedStackIsEmptyTest
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class LinkedStackIsEmptyTest {
	/**
	 * Atributo pila
	 */
	private AbstractStack stack;
	
	/**
	 * Creaci�n de objetos para su uso posterior
	 */
	@Before
	public void setUp() {
		stack = new LinkedListStack();
	}
	
	/**
	 * Pruebas del m�todo isEmpty de la clase AbstractStack:
	 * 1- Sobre una pila nueva
	 * 2- Sobre una pila vac�a
	 */
	
	/**
	 * 1- Sobre una pila nueva
	 * GIVEN Se crea una pila
	 * WHEN Se llama al m�todo isEmpty
	 * THEN Se comprueba que devuelve true
	 */
	@Test
	public void newStack() {		
		assertTrue(new LinkedListStack().isEmpty());
	}
	
	/**
	 * 2- Sobre una pila vac�a
	 * GIVEN Se crea una pila
	 * WHEN Se llama al m�todo isEmpty
	 * THEN Se comprueba que devuelve true
	 */
	@Test
	public void emptyStack() {
		assertTrue(stack.isEmpty());
	}
}