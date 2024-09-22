package uo.mp.collections.impl.stack;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.stack.AbstractStack;
import uo.mp.collections.stack.ArrayListStack;

/**
 * Titulo: Clase ArrayStackIsEmptyTest
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class ArrayStackIsEmptyTest {
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
	}
	
	/**
	 * Pruebas del método isEmpty de la clase AbstractStack:
	 * 1- Sobre una pila nueva
	 * 2- Sobre una pila vacía
	 */
	
	/**
	 * 1- Sobre una pila nueva
	 * GIVEN Se crea una pila
	 * WHEN Se llama al método isEmpty
	 * THEN Se comprueba que devuelve true
	 */
	@Test
	public void newStack() {		
		assertTrue(new ArrayListStack().isEmpty());
	}
	
	/**
	 * 2- Sobre una pila vacía
	 * GIVEN Se crea una pila
	 * WHEN Se llama al método isEmpty
	 * THEN Se comprueba que devuelve true
	 */
	@Test
	public void emptyStack() {
		assertTrue(stack.isEmpty());
	}
}
