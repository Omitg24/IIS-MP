package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

/**
 * Titulo: Clase SetTests
 * 
 * @author Omitg
 * @version 30-03-2021
 */
@SuppressWarnings("unchecked")
public class SetTests {
	/**
	 * Atributo lista
	 */
	@SuppressWarnings("rawtypes")
	private List list;
	
	/**
	 * Creaci�n de la lista para su posterior uso
	 */
	@Before
	public void setUp(){
		list = Settings.factory.newList();
	}
	/**
	 * Escenarios:
	 * 1-Set en la posici�n 0 de una lista con un elemento cambia el valor y devuelve el valor anterior de esa posici�n 
	 * 2-Set en la posici�n n de una lista con varios elementos, cambia el valor de la posici�n n y devuelve el valor anterior de esa posici�n
     * 3-Intentar realizar set en la posici�n 0 de una lista vac�a, lanza IndexOutOfBoundsException 
     * 4-Intentar realizar set en la posici�n -1 de una lista vac�a, lanza IndexOutOfBoundsException
     * 5-Intentar realizar set en la posici�n size() de una lista vac�a, lanza IndexOutOfBoundsException
     * 6-Intentar realizar set en la posici�n -1 de una lista con elementos, lanza IndexOutOfBoundsException
     * 7-Intentar realizar set en la posici�n size() de una lista con elementos, lanza  IndexOutOfBoundsException
	 */
	
	/**
	 * 1
	 * GIVEN lista con un elemento
	 * WHEN se cambia el valor de la posicion 0
	 * THEN se devuelve el anterior valor de la posicion 0
	 */
	@Test
	public void test1() 
	{
		list.add(1);
		assertEquals(1,list.set(0, 2));
	}
	
	/**
	 * 2
	 * GIVEN lista con varios elementos
	 * WHEN se cambia el valor de la posicion n
	 * THEN se devuelve el anterior valor de la posicion n
	 */
	@Test
	public void test2() 
	{
		for(int i = 0; i < 10; i++)
		{
			list.add(i);
		}
		assertEquals(6,list.set(6, 2));
	}
	
	/**
	 * 3
	 * GIVEN lista vac�a
	 * WHEN se cambia el valor de la posicion 0
	 * THEN lanza excepcion
	 */
	@Test
	(expected = IndexOutOfBoundsException.class)
	public void test3() 
	{
		list.set(0,1);
		fail("Deber�a haber lanzado una excepci�n");
	}
	
	/**
	 * 4
	 * GIVEN lista vac�a
	 * WHEN se cambia el valor de la posicion -1
	 * THEN lanza excepcion
	 */
	@Test
	(expected = IndexOutOfBoundsException.class)
	public void test4() 
	{
		list.set(-1,1);
		fail("Deber�a haber lanzado una excepci�n");
	}

	/**
	 * 5
	 * GIVEN lista vac�a
	 * WHEN se cambia el valor de la posicion size
	 * THEN lanza excepcion
	 */
	@Test
	(expected = IndexOutOfBoundsException.class)
	public void test5() 
	{
		list.set(list.size(),1);
		fail("Deber�a haber lanzado una excepci�n");
	}
	
	/**
	 * 6
	 * GIVEN lista con elementos
	 * WHEN se cambia el valor de la posicion -1
	 * THEN lanza excepcion
	 */
	@Test
	(expected = IndexOutOfBoundsException.class)
	public void test6() 
	{
		for(int i = 0; i < 10; i++)
		{
			list.add(i);
		}
		list.set(-1,1);
		fail("Deber�a haber lanzado una excepci�n");
	}
	
	/**
	 * 6
	 * GIVEN lista con elementos
	 * WHEN se cambia el valor de la posicion size
	 * THEN lanza excepcion
	 */
	@Test
	(expected = IndexOutOfBoundsException.class)
	public void test7() 
	{
		for(int i = 0; i < 10; i++)
		{
			list.add(i);
		}
		list.set(list.size(),1);
		fail("Deber�a haber lanzado una excepci�n");
	}
}
