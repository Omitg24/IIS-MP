package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

/**
 * Titulo: Clase GetTests
 * 
 * @author Omitg
 * @version 30-03-2021
 */
@SuppressWarnings("unchecked")
public class GetTests {
	
	/**
	 * Atributo lista
	 */
	@SuppressWarnings("rawtypes")
	private List list;

	/**
	 * Creación de la lista para su posterior uso
	 */
	@Before
	public void setUp(){
		list = Settings.factory.newList();
	}

	/**
	 * Given: a list with several elements
	 * When: se invoca al get(a)
	 * Then: devuelve cada posicion
	 */
	@Test
	public void getAllElement() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
	}
	
	/**
	 * Given: lista vacia
	 * When: se invoca al get(a)
	 * Then: indexoutofbounds
	 */
	@Test
	(expected = IndexOutOfBoundsException.class)
	public void pos0EmptyList() {
			list.get(0);
	}
	
	/**
	 * Given: lista vacia pos negativa
	 * When: se invoca al get(a)
	 * Then: IndexOutOfBounds
	 */
	@Test
	(expected = IndexOutOfBoundsException.class)
	public void posless1EmptyList() {
		list.get(-1);
	}
	
	/**
	 * Given: lista con elementos pos negativa
	 * When: se invoca al get(a)
	 * Then: IndexOutOfBounds
	 */
	@Test
	(expected = IndexOutOfBoundsException.class)
	public void posless1() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.get(-1);
	}
	
	/**
	 * Given: lista con elementos
	 * When: se invoca al get(a)
	 * Then: IndexOutOfBounds
	 */
	@Test
	(expected = IndexOutOfBoundsException.class)
	public void posSize() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.get(list.size());
	}
	

}
