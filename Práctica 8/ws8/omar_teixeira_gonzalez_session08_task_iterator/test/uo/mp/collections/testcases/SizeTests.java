package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

/**
 * Titulo: Clase SizeTests
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class SizeTests {
	/**
	 * Atributo lista
	 */
	private List list;
	
	/**
	 * Creaci�n de la lista para su posterior uso
	 */
	@Before
	public void setUp(){
		list = Settings.factory.newList();
	}

	/**
	 * Given: lista vacia
	 * When: se invoca al size()
	 * Then: return 0
	 */
	@Test
	public void size0() {
		assertEquals(0, list.size());
	}
	
	/**
	 * Given: lista con un elemento
	 * When: se invoca al size()
	 * Then: return 1
	 */
	@Test
	public void size1() {
		list.add("A");
		
		assertEquals(1, list.size());
	}
	
	/**
	 * Given: lista con varios elementos
	 * When: se invoca al size()
	 * Then: return 3
	 */
	@Test
	public void size3() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		assertEquals(3, list.size());
	}
	
	/**
	 * Given: lista con varios elementos se incrementa al a�adir otro
	 * When: se invoca al size()
	 * Then: size aumenta en una unidad
	 */
	@Test
	public void moreSize() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		assertEquals(3, list.size());
		
		list.add("D");
		
		assertEquals(4, list.size());
	}
	
	/**
	 * Given: lista con varios elementos se decrementa al eliminar uno
	 * When: se invoca al size()
	 * Then: size decrementa en una unidad
	 */
	@Test
	public void lessSize() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		assertEquals(3, list.size());
		
		list.remove(2);
		
		assertEquals(2, list.size());
	}

}
