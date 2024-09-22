package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.collections.impl.LinkedList;
import uo.mp.collections.setting.Settings;

/**
 * Titulo: Clase EqualsTests
 * 
 * @author Omitg
 * @version 30-03-2021
 */
public class EqualsTests {
	
	/**
	 * Atributo lista
	 */
	private List list;

	/**
	 * Atributos elementos
	 */
	private String element1, element2;

	/**
	 * Creaci�n de la lista para su posterior uso
	 */
	@Before
	public void setUp(){		
		element1 = "Elemento 1";
		element2 = "Elemento 2";
		list = Settings.factory.newList();
	}

	/**
	 * Escenarios: 
	 * 1- Dos listas vacias de tipo ArrayList son iguales
	 * 2- Dos listas vacias LinkedList son iguales
	 * 3- Dos listas vacias de ambos tipos son iguales
	 * 4- Dos listas de tipoArrayList con lis mismos elementos en la misma
	 * 		posicion son iguales
	 * 5- Dos listas de tipo LinledList con los mismos elementos en la misma
	 * 		posicion son iguales
	 * 6- Dos listas de ambos tipos con los mismos elementos en la misma posicion
	 * 		son iguales
	 * 7- Dos listas de tipo ArrayList con los mismos elementos en diferente
	 * 		posicion no son iguales
	 * 8- Dos listas de tipo LinekdList con los mismos elementos en diferentes posiciones
	 * 		no son iguales
	 * 9- Dos listas de ambos tipos con los mismos elementos en posiciones distintas no
	 * 		son iguales
	 * 10- Dos listas de tipo ArrayList con diferentes elementos no son iguales
	 * 11- Dos listas de tipo LinkedList con diferentes elementos no son iguales
	 * 12- Dos listas de ambos tipos con diferentes elementos no son iguales
	 */
	
	/**
	 * 1
	 * GIVEN
	 * WHEN compara dos objetos ArrayList vacios
	 * THEN return true
	 */
	@Test
	public void testArrayListEmpty() {
		assertEquals(list, new ArrayList());
	}
	
	/**
	 * 2
	 * GIVEN
	 * WHEN compara dos LinkedList vacias
	 * THEN return true
	 */
	@Test
	public void testLinkedListEmpty() {
		assertEquals(list, new LinkedList());
	}
	
	/**
	 * 3
	 * GIVEN
	 * WHEN compara dos listas vacias de ambos tipos
	 * THEN return true
	 */
	@Test
	public void testBothTypeEmpty() {
		assertEquals(list, new LinkedList());
	}
	
	/**
	 * 4
	 * GIVEN
	 * WHEN compara dos ArrayList con los mismos elementos en las mismas posiciones
	 * THEN return true
	 */
	@Test
	public void testTwoArrayListSameElementsSamePosition() {
		ArrayList ar1 = new ArrayList();
		ArrayList ar2 = new ArrayList();
		ar1.add(element1);ar2.add(element1);
		ar1.add(element2);ar2.add(element2);
		assertEquals(ar1, ar2);
	}
	
	/**
	 * 5
	 * GIVEN
	 * WHEN copara dos LinkedList con los mismos elementos en las mismas posiciones
	 * THEN
	 */
	@Test
	public void testTwoLinkedListSameElementsSamePosition() {
		list.add(1);
		LinkedList ll1 = new LinkedList();
		LinkedList ll2 = new LinkedList();
		ll1.add(element1);ll2.add(element1);
		ll1.add(element2);ll2.add(element2);
		assertEquals(ll1, ll2);
	}
	
	/**
	 * 6
	 * GIVEN
	 * WHEN copara dos listad de ambos tipos con los mismos elementos en las 
	 * 		mismas posiciones
	 * THEN return true
	 */
	@Test
	public void testBothTypeSameElementsSamePosition() {
		ArrayList ar1 = new ArrayList();
		LinkedList ll1 = new LinkedList();
		ll1.add(element1);ll1.add(element2);
		ar1.add(element1);ar1.add(element2);
		assertEquals(ar1, ll1);
	}
	
	/**
	 * 7
	 * GIVEN
	 * WHEN compara dos ArrayList con los mismos elementos en distintas posiciones 
	 * THEN return false
	 */
	@Test
	public void testTwoArrayListSameElementsDiferentPosition() {
		ArrayList ar1 = new ArrayList();
		ArrayList ar2 = new ArrayList();
		ar1.add(element1);ar2.add(element2);
		ar1.add(element2);ar2.add(element1);
		assertNotEquals(ar1, ar2);
	}
	
	/**
	 * 8
	 * GIVEN
	 * WHEN copara dos LinkedList con los mismos elementos distintas posiciones
	 * THEN return false
	 */
	@Test
	public void testTwoLinkedListSameElementsDiferentPosition() {
		LinkedList ll1 = new LinkedList();
		LinkedList ll2 = new LinkedList();
		ll1.add(element1);ll2.add(element2);
		ll1.add(element2);ll2.add(element1);
		assertNotEquals(ll1, ll2);
	}
	
	/**
	 * 9
	 * GIVEN
	 * WHEN copara dos listas de ambos tipos con los mismos elementos distintas
	 * 		posiciones
	 * THEN return false
	 */
	@Test
	public void testBothListTypeSameElementsDiferentPosition() {
		ArrayList ar1 = new ArrayList();
		LinkedList ll1 = new LinkedList();
		ll1.add(element1);ll1.add(element2);
		ar1.add(element2);ar1.add(element1);
		assertNotEquals(ar1, ll1);
	}
	
	/**
	 * 10
	 * GIVEN
	 * WHEN compara dos ArrayList con diferentes elementos
	 * THEN return false
	 */
	@Test
	public void testTwoArrayListDiferentElements() {
		ArrayList ar1 = new ArrayList();
		ArrayList ar2 = new ArrayList();
		ar1.add(element1);
		ar2.add(element2);
		assertNotEquals(ar1, ar2);
	}
	
	/**
	 * 11
	 * GIVEN
	 * WHEN compara dos LinkedList con diferentes elementos
	 * THEN return false
	 */
	@Test
	public void testTwoLinkedListDiferentElements() {
		LinkedList ll1 = new LinkedList();
		LinkedList ll2 = new LinkedList();
		ll1.add(element1);
		ll2.add(element2);
		assertEquals(ll2, ll2);
	}
	
	/**
	 * 12
	 * GIVEN
	 * WHEN compara dos listas de ambos tipos con diferentes elementos
	 * THEN return false
	 */
	@Test
	public void testBothListTypeDiferentElements() {
		ArrayList ar1 = new ArrayList();
		LinkedList ll1 = new LinkedList();
		ll1.add(element1);
		ar1.add(element2);
		assertNotEquals(ar1, ll1);
	}
}
