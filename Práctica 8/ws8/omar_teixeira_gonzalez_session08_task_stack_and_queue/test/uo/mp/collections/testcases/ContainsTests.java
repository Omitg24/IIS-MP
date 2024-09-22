package uo.mp.collections.testcases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

/**
 * Titulo: Clase ContainsTests
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class ContainsTests {
	/**
	 * Atributo lista
	 */
	private List list;
	
	/**
	 * Escenarios:
	 * 1- Una lista vacía no contiene un elemento arbitrario.
	 * 2- Una lista con varios elementos no contiene al elemento.
	 * 3- Una lista con un elemento contiene al elemento.
	 * 4- Una lista con varios elemento contiene al elemento
	 * 5- Una lista vacía no contienen null.
	 * 6- Una lista con elementos no contiene null.
	 * @throws Exception
	 */

	/**
	 * Creación de la lista para su posterior uso
	 */
	@Before
	public void setUp(){
		list = Settings.factory.newList();
	}

	/**
	 * 1
	 * GIVEN: le pasamos un elemento arbitrario a una lista vacia.
	 * WHEN: llamamos al metodo.
	 * THEN: devuelve false.
	 */
	@Test
	public void listEmpty() {
		assertFalse( list.contains( "A" ));
	}
	
	/**
	 * 2
	 * GIVEN: una lista con varios elementos no contiene al elemento.
	 * WHEN: llamamos al metodo.
	 * THEN: devuelve false.
	 */
	@Test
	public void listVariousElementsNoContains() {
		list.add("B");
		list.add("C");
		list.add("D");
		assertFalse( list.contains( "A" ));
	}
	
	/**
	 * 3
	 * GIVEN: una lista con un elemento contiene al elemento.
	 * WHEN: llamamos al metodo.
	 * THEN: devuelve true.
	 */
	@Test
	public void listOneElementContains() {
		list.add("A");
		assertTrue( list.contains( "A" ));
	}
	
	/**
	 * 4
	 * GIVEN: una lista con un elemento contiene al elemento.
	 * WHEN: llamamos al metodo.
	 * THEN: devuelve true.
	 */
	@Test
	public void listVariousElementsContains() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		assertTrue( list.contains( "A" ));
	}
	
	/**
	 * 5
	 * GIVEN: una lista vacia no contiene null.
	 * WHEN: llamamos al metodo.
	 * THEN: devuelve false.
	 */
	@Test
	public void listEmptyNoContainsNull() {
		assertFalse(list.contains(null));
	}
	
	/**
	 * 6
	 * GIVEN: una lista con elementos no contiene null.
	 * WHEN: llamamos al metodo.
	 * THEN: devuelve false.
	 */
	@Test
	public void listVariousElementsNoContainsNull() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		assertFalse(list.contains(null));
	}

}
