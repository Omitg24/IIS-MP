package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

/**
 * Titulo: RemoveFromPositionTests
 * 
 * @author Omitg
 * @version 18-03-2021
 */
public class RemoveFromPositionTests {
	
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
	 * Pruebas del m�todo removeFromPosition de la clase test:
	 * Pruebas de funcionalidad:
	 * 1- Remove de la posici�n 0 de una lista con un elemento devuelve el elemento eliminado y la lista queda vac�a
	 * 2- Remove de la posici�n 0 de una lista no vac�a devuelve el elemento eliminado y quita el elemento de la lista
	 * 3- Remove de la posici�n 0 de una lista no vac�a, mueve el resto de elementos una posici�n a la izquierda
	 * 4- Remove de una posici�n existente, devuelve el elemento borrado y se quita el elemento de la lista
	 * 5- Remove de una posici�n existente, mueve los elementos de la derecha una posici�n a la izquierda
	 * 6- Remove de la �ltima posici�n, devuelve el elemento borrado y quita el lemento de la lista
	 * 
	 * Pruebas de robustez:
	 * 7- Intentar realizar remove en la posici�n -1 lanza IndexOutOfBoundsException
	 * 8- Intentar realizar remove en la posici�n 0 de una lista vac�a, lanza IndexOutOfBoundsException
	 * 9- Intentar realizar remove en la posici�n size() de una lista vac�a, lanza IndexOutOfBoundsException
	 * 10- Intentar realizar remove en la posici�n size() de una lista no vac�a, lanza IndexOutOfBoundsException
	 */
	
	/**
	 * 1- Remove de la posici�n 0 de una lista con un elemento devuelve el elemento eliminado y la lista queda vac�a
	 * GIVEN Lista vac�a
	 * WHEN Se a�aden objetos a la lista
	 * THEN Se elimina un objeto y se comprrueba que esta vac�a
	 */
	 @Test
	 public void testOneObject() {
		 list.add("Objeto");
		 assertEquals("Objeto", list.remove(0));
		 assertTrue(list.isEmpty());
	 }
	 
	 /**
	  * 2- Remove de la posici�n 0 de una lista no vac�a devuelve el elemento eliminado y quita el elemento de la lista
	 * GIVEN Lista vac�a
	 * WHEN Se a�aden objetos a la lista
	 * THEN Se elimina un objeto y se comprrueba que no esta vac�a
	 */
	 @Test
	 public void testVariousObject() {
		 list.add("Objeto1");
		 list.add("Objeto2");
		 list.add("Objeto3");
		 assertEquals("Objeto1", list.remove(0));
		 assertFalse(list.isEmpty());
	 }
	 
	 /**
	  * 3- Remove de la posici�n 0 de una lista no vac�a, mueve el resto de elementos una posici�n a la izquierda
	 * GIVEN Lista vac�a
	 * WHEN Se a�aden objetos a la lista
	 * THEN Se elimina un objeto y se comprrueba que no esta vac�a y el resto se han desplazado
	 */
	 @Test
	 public void testVariousObjectMove() {
		 list.add("Objeto1");
		 list.add("Objeto2");
		 list.add("Objeto3");
		 assertEquals("Objeto1", list.remove(0));
		 assertFalse(list.isEmpty());
		 assertEquals("Objeto2",list.get(0));
		 assertEquals("Objeto3",list.get(1));
	 }
	 
	 /**
	  * 4- Remove de una posici�n existente, devuelve el elemento borrado y se quita el elemento de la lista
	 * GIVEN Lista vac�a
	 * WHEN Se a�aden objetos a la lista
	 * THEN Se elimina un objeto y se comprrueba que no esta vac�a
	 */
	 @Test
	 public void testVariousObjectNotInitial() {
		 list.add("Objeto1");
		 list.add("Objeto2");
		 list.add("Objeto3");
		 assertEquals("Objeto2", list.remove(1));
		 assertFalse(list.isEmpty());		 
	 }
	 
	 /**
	  * 5- Remove de una posici�n existente, mueve los elementos de la derecha una posici�n a la izquierda
	 * GIVEN Lista vac�a
	 * WHEN Se a�aden objetos a la lista
	 * THEN Se elimina un objeto y se comprrueba que no esta vac�a y el resto se han desplazado
	 */
	 @Test
	 public void testVariousObjectNotInitialMove() {
		 list.add("Objeto1");
		 list.add("Objeto2");
		 list.add("Objeto3");
		 assertEquals("Objeto2", list.remove(1));
		 assertFalse(list.isEmpty());
		 assertEquals("Objeto1",list.get(0));
		 assertEquals("Objeto3",list.get(1));
	 }
	 
	 /**
	  * 6- Remove de la �ltima posici�n, devuelve el elemento borrado y quita el lemento de la lista
	 * GIVEN Lista vac�a
	 * WHEN Se a�aden objetos a la lista
	 * THEN Se elimina un objeto y se comprrueba que esta no vac�a
	 */
	 @Test
	 public void testVariousObjectLast() {
		 list.add("Objeto1");
		 list.add("Objeto2");
		 list.add("Objeto3");
		 assertEquals("Objeto3", list.remove(2));
		 assertFalse(list.isEmpty());		 
	 }
	 
	 /**
	  * 7- Intentar realizar remove en la posici�n -1 lanza IndexOutOfBoundsException
	 * GIVEN Lista vac�a
	 * WHEN Se a�aden objetos a la lista, se pasa -1
	 * THEN Se lanza la excepci�n
	 */
	 @Test
	 (expected = IndexOutOfBoundsException.class)
	 public void testVariousObjectMinus1() {
		 list.remove(-1);
	 }
	 
	 /**
	  * 8- Intentar realizar remove en la posici�n 0 de una lista vac�a, lanza IndexOutOfBoundsException
	 * GIVEN Lista vac�a
	 * WHEN Se a�aden objetos a la lista, se pasa 0
	 * THEN Se lanza la excepci�n
	 */
	 @Test
	 (expected = IndexOutOfBoundsException.class)
	 public void testVariousObject0() {
		 list.remove(0);
	 }
	 
	 /**
	  * 9- Intentar realizar remove en la posici�n size() de una lista vac�a, lanza IndexOutOfBoundsException
	 * GIVEN Lista vac�a
	 * WHEN Se a�aden objetos a la lista, se pasa size
	 * THEN Se lanza la excepci�n
	 */
	 @Test
	 (expected = IndexOutOfBoundsException.class)
	 public void testVariousObjectSizeEmpty() {
		 list.remove(list.size());
	 }
	 
	 /**
	  * 10- Intentar realizar remove en la posici�n size() de una lista no vac�a, lanza IndexOutOfBoundsException
	 * GIVEN Lista vac�a
	 * WHEN Se a�aden objetos a la lista, se pasa size
	 * THEN Se lanza la excepci�n
	 */
	 @Test
	 (expected = IndexOutOfBoundsException.class)
	 public void testVariousObjectSizeNotEmpty() {
		 list.add("Objeto1");
		 list.add("Objeto2");
		 list.add("Objeto3");
		 list.remove(list.size());
	 }
}