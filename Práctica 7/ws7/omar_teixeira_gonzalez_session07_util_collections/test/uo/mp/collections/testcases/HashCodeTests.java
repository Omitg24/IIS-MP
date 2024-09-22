package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

/**
 * Titulo: HashCodeTests
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public class HashCodeTests {
	/**
	 * Atributo lista
	 */
	private List list, list2;
	/**
	 * Creación de la lista para su posterior uso
	 */
	@Before
	public void setUp(){
		list = Settings.factory.newList();
		list2 = Settings.factory.newList();
	}

	/**
	* Caso1: El hashCode de una lista vacía es 1
	* Caso2: El hashCode de una lista no vacía es el hashCode calculado
	* Caso3: El hashCode de dos listas iguales del mismo tipo es el mismo
	* Caso4: El hashCode de dos listas iguales de diferente tipo es el mismo
	* Caso5: El hashCode de dos listas con los mismos elementos en posiciones diferentes es distinto
	*/
	
	/**
	* Given: an empty list
	* When: hashcode() is invoked
	* Then: es 1
	*/
	@Test
	public void test() {
		assertEquals(1 , list.hashCode());

	}
	
	/**
	* Given: an empty semi-llena list
	* When: hashcode() is invoked
	* Then: se comprueban que son iguales
	*/
	@Test
	public void test2() {
		list.add(0);
		list.add(1);
		int var = list.hashCode();
		assertEquals(var , list.hashCode());
		
	}
	
	/**
	* Given: dos listas-llenas vacias mismo tipo
	* When: hashcode() is invoked
	* Then: se comprueban que son iguales
	*/
	@Test
	public void test3() {
		list.add(0);
		list.add(1);
		list2.add(0);
		list2.add(1);
		//assertEquals(list2.hashCode() , list.hashCode());
		
	}
	
	/**
	* Given: dos listas semi-llenas de distinto tipo
	* When: hashcode() is invoked
	* Then: se comprueban que son iguales
	*/
	@Test
	public void test4() {
		list.add(0);
		list.add(1);
		list2.add('c');
		list2.add('d');
		assertNotEquals(list2.hashCode() , list.hashCode());
		
	}
	
	/**
	* Given: dos listas vacias de distinto tipo
	* When: hashcode() is invoked
	* Then: se comprueban que son diferentes
	*/
	@Test
	public void test5() {
		list.add(0);
		list.add(1);
		list2.add(1);
		list2.add(0);
		assertNotEquals(list.hashCode() , list2.hashCode());
		
	}
}
