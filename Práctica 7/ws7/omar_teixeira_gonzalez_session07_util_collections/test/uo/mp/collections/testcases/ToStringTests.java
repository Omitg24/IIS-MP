package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

/**
 * Titulo: Clase ToStringTests
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public class ToStringTests {
	/**
	 * Atributo lista
	 */
	private List list;
	
	/**
	 * Creación de la lista para su posterior uso
	 */
	@Before
	public void setUp(){
		list = Settings.factory.newList();
	}

	/**
	 * Given: lista vacia
	 * When: se invoca al toString()
	 * Then: return "[]"
	 */
	@Test
	public void empty() {
		assertEquals("[]", list.toString());
	}
	
	/**
	 * Given: lista con elemento A
	 * When: se invoca al toString()
	 * Then: return "[A]"
	 */
	@Test
	public void toStringA() {
		list.add("A");
		
		assertEquals("[A]", list.toString());
	}
	
	/**
	 * Given: lista con elemento A, B
	 * When: se invoca al toString()
	 * Then: return "[A, B]"
	 */
	@Test
	public void toStringAB() {
		list.add("A");
		list.add("B");
		
		assertEquals("[A, B]", list.toString());
	}

}
