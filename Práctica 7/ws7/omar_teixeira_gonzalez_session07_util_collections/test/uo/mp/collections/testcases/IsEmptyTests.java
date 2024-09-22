package uo.mp.collections.testcases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

/**
 * Titulo: Clase IsEmptyTests
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public class IsEmptyTests {
	/**
	 * Atributo lista
	 */
	private List list;
	
	/**
	 * Escenarios:
	 * 1- Una lista recien creada esta vacía.
	 * 2- Una lista queda vacía después de la operación clear.
	 * 3- Una lista con un elemento no está vacía.
	 * 4- Una lista con más de un elemento no esta vacía.
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
	* GIVEN: una lista vacia.
	* WHEN: llamamos al metodo.
	* THEN: retornará true pues está vacia.
	*/
	@Test
	public void testIsEmptyCreatedList() {
	assertTrue(list.isEmpty());
	}

	/**
	* 2
	* GIVEN: una lista queda vacia despues de llamar a clear().
	* WHEN: llamamos al metodo.
	* THEN: retornará true pues está vacia.
	*/
	@Test
	public void testIsEmptyClearList() {
	list.add("Eyou");
	list.add("Como dice");
	list.clear();

	assertTrue(list.isEmpty());
	}


	/**
	* 3
	* GIVEN: una lista con un elemento.
	* WHEN: llamamos al metodo.
	* THEN: retornará false al no estar vacia.
	*/
	@Test
	public void testIsEmptyOneElement() {
	list.add("Eyou");

	assertFalse(list.isEmpty());
	}

	/**
	* 4
	* GIVEN: Una lista con mas de un elemento.
	* WHEN: llamamos al metodo.
	* THEN: retornará false al no estar vacia
	*/
	@Test
	public void testIsEmptyManyElements() {
	list.add("Eyou");
	list.add("Como dice");
	list.add("Asi");

	assertFalse(list.isEmpty());
	}

}
