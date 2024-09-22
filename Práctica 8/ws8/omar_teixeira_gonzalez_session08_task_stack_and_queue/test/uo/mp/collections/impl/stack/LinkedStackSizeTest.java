package uo.mp.collections.impl.stack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.stack.AbstractStack;
import uo.mp.collections.stack.LinkedListStack;

/**
 * Titulo: Clase LinkedStackSizeTest
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class LinkedStackSizeTest{
	/**
	 * Atributo pila
	 */
	private AbstractStack stack;
	
	/**
	 * Creación de objetos para su uso posterior
	 */
	@Before
	public void setUp() {
		stack = new LinkedListStack();
	}
	
	/**
	 * Pruebas del método size de la clase AbstractStack:
	 * 1- Sobre una pila nueva
	 * 2- Sobre una pila vacía
	 */
	
	/**
	 * 1- Sobre una pila nueva
	 * GIVEN Se crea una pila
	 * WHEN Se llama al método size
	 * THEN Se comprueba que devuelve 0
	 */
	@Test
	public void newStack() {		
		assertEquals(0,new LinkedListStack().size());
	}
	
	/**
	 * 2- Sobre una pila vacía
	 * GIVEN Se crea una pila
	 * WHEN Se llama al método size
	 * THEN Se comprueba que devuelve 0
	 */
	@Test
	public void emptyStack() {
		assertEquals(0, stack.size());
	}
}
