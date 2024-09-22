package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

/**
 * Titulo: Clase AddInPositionTests
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class AddInPositionTests {
	
	/**
	 * Lista
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
	 * Caso1: Add en la posici�n 0 de una lista vac�a a�ade el elemento			
	 * CAso2: Add en la posici�n 0 de una lista con varios elementos a�ade el elemento y mueve el resto una posici�n a la derecha
	 * Caso3: Add en una posici�n intermedia de una lista a�ade el elemento y mueve el resto una posici�n a la derecha
	 * Caso4: Add en la �ltima posici�n de una lista con elementos a�ade el elemento
	 * Caso5: Add en la posici�n despu�s del �ltimo de una lista con elementos a�ade el elemento	
	 * Caso6: Intentar a�adir  en una posici�n negativa, se lanza IndexOutOfBoundsException	
	 * Caso7: Intentar a�adir en una posic�n > size(), se lanza IndexOutOfBoundsException	
	 * Caso8: intentar a�adir un null, se lanza IllegalArgumentException	
	 */
	
	/**
	 * Given: an empty list
	 * When: se a�ade un numero
	 * Then: se comprueba que la pos 0 sea el numero
	 */
	@Test
	public void test1() {		
		list.add(0, 7);
		assertEquals(1, list.size());
	}
	
	/**
	 * Given: una lista con varios elementos
	 * When: se a�ade un numero en medio
	 * Then: se comprueba que la pos 0 sea el numero
	 */
	@Test
	public void test2() {
		list.add(0, 7);
		list.add(1, 6);
		list.add(2, 7);
		
		list.add(0, 2);
		
		assertEquals(2, list.get(0));
		assertEquals(4, list.size());
	}
	 
	/**
	 * Given: una lista con varios elementos
	 * When: se a�ade un numero en medio
	 * Then: se comprueba que la pos 1 sea el numero
	 */
	@Test
	public void test3() {
		list.add(0, 7);
		list.add(1, 6);
		list.add(2, 7);
		
		list.add(1, 2);
		
		assertEquals(2, list.get(1));
		assertEquals(4, list.size());
	}
	
	/**
	 * Given: una lista con varios elementos
	 * When: se a�ade un numero en medio
	 * Then: se comprueba que es el elemento
	 */
	@Test
	public void test4() {
		list.add(0, 7);
		list.add(1, 6);
		list.add(2, 7);
		
		list.add(2, 2);
		
		assertEquals(2, list.get(2));
		assertEquals(4, list.size());
	}
	
	/**
	 * Given: una lista con varios elementos
	 * When: se a�ade un numero en medio
	 * Then: se comprueba que es el elemento
	 */
	@Test
	public void test5() {
		list.add(0, 7);
		list.add(1, 6);
		list.add(2, 7);
		
		list.add(3, 2);
		
		assertEquals(2, list.get(3));
		assertEquals(4, list.size());
	}
	
	/**
	 * Given: an empty list
	 * When: se a�ade un numero
	 * Then: lanza excepcion
	 */
	@Test
	(expected = IndexOutOfBoundsException.class)
	public void test6() {
		list.add(-9, 7);
	}
	
	/**
	 * Given: an empty list
	 * When: se a�ade un numero
	 * Then: lanza excepcion
	 */
	@Test
	(expected = IndexOutOfBoundsException.class)
	public void test7() {
		list.add(list.size() + 5, 7);
	}
	
	/**
	 * Given: an empty list
	 * When: se a�ade un numero
	 * Then: lanza excepcion
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void test8() {
		list.add(0, null);
	}
}
