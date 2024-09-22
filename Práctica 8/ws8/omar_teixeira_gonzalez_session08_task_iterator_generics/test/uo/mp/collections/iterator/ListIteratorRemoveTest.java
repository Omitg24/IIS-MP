package uo.mp.collections.iterator;

import java.util.Iterator;

import org.junit.Test;

import uo.mp.collections.List;

/**
 * Titulo: Clase ListIteratorRemoveTest
 * 
 * @author Omitg
 * @version 30-03-2021
 * @param <T>, parámetro generico
 */
public class ListIteratorRemoveTest<T> {
	
	/**
	 * Atributo lista
	 */
	protected List<T> list;
	/**
	 * Atributo iterador
	 */
	protected Iterator<T> listIterator;

	/**
	 * Constructor sin parámetros que crea la superclase
	 */
	public ListIteratorRemoveTest() {
		super();
	}

	/**
	 * Casos de prueba:
	 * 1- Lista vacía
	 * 2- Lista con un elemento
	 * 3- Lista con varios elementos
	 * 4- Lista con varios elementos y ultima posición
	 */
	
	/**
	 * 1- Lista vacía
	 * GIVEN Se crea una lista vacía
	 * WHEN Se llama al método next
	 * THEN Se lanza la excepción
	 */
	@Test
	(expected=IllegalStateException.class)
	public void emptyList() {		
		listIterator = list.iterator();
		listIterator.remove();
	}
}