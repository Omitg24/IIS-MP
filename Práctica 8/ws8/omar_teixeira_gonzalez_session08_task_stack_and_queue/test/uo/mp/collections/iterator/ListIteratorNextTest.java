package uo.mp.collections.iterator;


import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import uo.mp.collections.List;

/**
 * Titulo: Clase ListIteratorNextTest
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class ListIteratorNextTest {
	
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
	public ListIteratorNextTest() {
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
	 * WHEN Se llama al m�todo next
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected=NoSuchElementException.class)
	public void emptyList() {		
		listIterator = list.iterator();
		listIterator.next();
	}
}
