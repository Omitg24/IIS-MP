package uo.mp.s2.seatmanager.model.seatmanager;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import  uo.mp.s2.seatmanager.model.SeatManager;

/**
 * <p>
 * Titulo: Clase SeatManagerTest
 *   
 * @author Omitg
 * @version 13/02/2021
 */

public class SeatManagerTest {
	/**
	 * Pruebas del constructor con par�metros de la clase SeatManager:
	 * Positivas (Pruebas de funcionalidad): 
	 * 1- Cumple los l�mites de las filas y las columnas -> Crea el array bidimensional
	 * 2- En el limite de las filas -> Crea el array bidimensional
	 * 3- En el l�mite de las columnas -> Crea el array bidimensional
	 * 4- En el l�mite de ambas -> Crea el array bidimensional
	 * 
	 * Negativas (Pruebas de robustez):
	 * 5- Superior al l�mite de las filas -> Lanza la excepci�n
	 * 6- Superior al l�mite de las columnas -> Lanza la excepci�n
	 * 7- Superior al l�mite de ambas -> Lanza la excepci�n
	 */
	
//Positivas (Pruebas de funcionalidad):
	/**
	 * 1- Cumple los l�mites de las filas y las columnas -> Crea el array bidimensional
	 * GIVEN seatManager recibe un numero de filas y columnas dentro de los l�mites
	 * WHEN llamada a lo m�todos getRows y getColumns
	 * THEN comparacion de que las filas y columnas son las introducidas en el constructor
	 */
	@Test
	public void testConstructorBothOk() {
		SeatManager seatManager = new SeatManager(8,3);
		int r=seatManager.getRows();
		int c=seatManager.getColumns();
		assertEquals(8,r);
		assertEquals(3,c);
	}
	
	/**
	 * 2- En el limite de las filas -> Crea el array bidimensional
	 * GIVEN seatManager recibe un numero de filas y columnas, con las filas en el l�mite
	 * WHEN llamada a lo m�todos getRows y getColumns
	 * THEN comparacion de que las filas y columnas son las introducidas en el constructor
	 */
	@Test
	public void testConstructorRowsInLimit() {
		SeatManager seatManager = new SeatManager(10,3);
		int r=seatManager.getRows();
		int c=seatManager.getColumns();
		assertEquals(10,r);
		assertEquals(3,c);
	}
	
	/**
	 * 3- En el l�mite de las columnas -> Crea el array bidimensional
	 * GIVEN seatManager recibe un numero de filas y columnas, con las columnas en el l�mite
	 * WHEN llamada a lo m�todos getRows y getColumns
	 * THEN comparacion de que las filas y columnas son las introducidas en el constructor
	 */
	@Test
	public void testConstructorColumnsInLimit() {
		SeatManager seatManager = new SeatManager(8,4);
		int r=seatManager.getRows();
		int c=seatManager.getColumns();
		assertEquals(8,r);
		assertEquals(4,c);
	}
	
	/**
	 * 4- En el l�mite de ambas -> Crea el array bidimensional
	 * GIVEN seatManager recibe un numero de filas y columnas, con ambas en el l�mites
	 * WHEN llamada a lo m�todos getRows y getColumns
	 * THEN comparacion de que las filas y columnas son las introducidas en el constructor
	 */
	@Test
	public void testConstructorBothInLimitg() {
		SeatManager seatManager = new SeatManager(10,4);
		int r=seatManager.getRows();
		int c=seatManager.getColumns();
		assertEquals(10,r);
		assertEquals(4,c);
	}
	
//Negativas (Pruebas de robustez):	
	/**
	 * 5- Superior al l�mite de las filas -> Lanza la excepci�n
	 * GIVEN seatManager recibe un numero de filas y columnas, las filas por encima del limite
	 * WHEN 
	 * THEN lanza la excepci�n
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testConstructorRowsOverLimit() {
		new SeatManager(12,3);		
	}
	
	/**
	 * 6- Superior al l�mite de las columnas -> Lanza la excepci�n
	 * GIVEN seatManager recibe un numero de filas y columnas, las columnas por encima del limite
	 * WHEN 
	 * THEN lanza la excepci�n
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testConstructorColumnsOverLimit() {
		new SeatManager(8,6);		
	}
	
	/**
	 * 7- Superior al l�mite de ambas -> Lanza la excepci�n
	 * GIVEN seatManager recibe un numero de filas y columnas, ambas por encima del l�mite
	 * WHEN 
	 * THEN lanza la excepci�n
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testConstructorBotgOverLimit() {
		new SeatManager(12,6);		
	}
}
