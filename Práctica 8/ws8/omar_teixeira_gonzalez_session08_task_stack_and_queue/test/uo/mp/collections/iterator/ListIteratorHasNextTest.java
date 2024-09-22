package uo.mp.collections.iterator;

import static org.junit.Assert.assertFalse;

import java.util.Iterator;

import org.junit.Test;

import uo.mp.collections.List;

/**
 * Titulo: Clase ListIteratorHasNextTest
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class ListIteratorHasNextTest {
	
	/**
	 * Atributo lista
	 */
	protected List list;
	/**
	 * Atributo iterador
	 */
	protected Iterator<Object> listIterator;

	/**
	 * Constructor sin par�metros que crea la superclase
	 */
	public ListIteratorHasNextTest() {
		super();
	}

	/**
	 * Casos de prueba:
	 * 1- Lista vac�a
	 * 2- Lista con un elemento
	 * 3- Lista con varios elementos
	 * 4- Lista con varios elementos y ultima posici�n
	 */
	
	/**
	 * 1- Lista vac�a
	 * GIVEN Se crea una lista vac�a
	 * WHEN Se llama al m�todo hasNext
	 * THEN Se comprueba que devuelve false
	 */
	@Test
	public void emptyList() {		
		listIterator = list.iterator();
		assertFalse(listIterator.hasNext());
	}
}