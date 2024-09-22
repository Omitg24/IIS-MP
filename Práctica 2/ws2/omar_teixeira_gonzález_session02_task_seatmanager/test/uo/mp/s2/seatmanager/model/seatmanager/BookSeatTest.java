package uo.mp.s2.seatmanager.model.seatmanager;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import org.junit.Before;

import uo.mp.s2.seatmanager.model.Person;
import  uo.mp.s2.seatmanager.model.SeatManager;

/**
 * <p>
 * Titulo: Clase BookSeatTest
 *   
 * @author Omitg
 * @version 13/02/2021
 */

public class BookSeatTest {
	
	/**
	 * Atributo seatManager
	 */
	private SeatManager sm1;
	
	/**
	 * Ni�o 1
	 */
	private Person child1;
	
	/**
	 * Adulto 1
	 */
	private Person adult1;
	
	/**
	 * Jubilado 1
	 */
	private Person retired1;
	
	/**
	 * Ni�o 2
	 */
	private Person child2;
	
	/**
	 * Adulto 2
	 */
	private Person adult2;
	
	/**
	 * Jubilado 2
	 */
	private Person retired2;
	
	/**
	 * Ni�o a sentar
	 */
	private Person childToSeat;
	
	/**
	 * Adulto a sentar
	 */
	private Person adultToSeat;
	
	/**
	 * Jubilado a sentar
	 */
	private Person retiredToSeat;	
	
	/**
	 * Objetos a ejecutar previo a los tests
	 */
	@Before
    public void setUp(){
        sm1= new SeatManager(SeatManager.MAX_ROWS, SeatManager.MAX_COLUMNS);
        child1 = new Person ("Mar�a", 2);
		adult1 = new Person ("Marta", 24);
		retired1 = new Person ("Jose", 78);
		child2 = new Person ("Pablo", 7);
		adult2 = new Person ("Andres", 20);
		retired2 = new Person ("Juan", 65);
		childToSeat = new Person ("Ines", 12);
		adultToSeat = new Person ("Elsa", 22);
		retiredToSeat = new Person ("Ramon", 82);
    }
	
	/**
	 * Pruebas del m�todo bookSeat de la clase SeatManager:
	 * Positivas (Pruebas de funcionalidad):
	 * 1- El asiento est� vac�o -> Sienta a la persona y devuelve true
	 * 2- El asiento est� ocupado por una persona adulta no jubilada -> Sienta a la persona y devuelve true
	 * 3- El asiento est� ocupado por una persona no adulta -> No sienta a la persona y devuelve false
	 * 4- El asiento est� ocupado pro una persona adulta jubilada -> No sienta a la persona y devuelve false
	 * 
	 * Negativas (Pruebas de robustez):
	 * 5- Se introduce un pasajero null -> Lanza la excepci�n 
	 * 6- La fila introducida es menor a 0 -> Lanza la excepci�n
	 * 7- La fila introducida es mayor que el numero de filas -> Lanza la excepci�n
	 * 8- La columna introducida es menor a 0 -> Lanza la excepci�n
	 * 9- La columna introducida es mayor que el numero de columnas -> Lanza la excepci�n
	 * 10- La fila y la columna introducidas son inferiores a 0 -> Lanza la excepci�n
	 * 11- La fila y la columna introducidas son mayores que el numero de filas y columnas -> Lanza la excepci�n
	 */

//Positivas (Pruebas de funcionalidad):
	/**
	 * 1- El asiento est� vac�o -> Sienta a la persona y devuelve true
	 * GIVEN Se crea un seatManager y varias personas a sentar
	 * WHEN Se sienta una persona con el m�todo bookSeat
	 * THEN Se comprueba que el m�todo devuelve True
	 */
	@Test
	public void testBookSeatEmpty() {
		assertTrue(sm1.bookSeat(child1, 2,2));
	}
	
	/**
	 * 2- El asiento est� ocupado por una persona adulta no jubilada -> Sienta a la persona y devuelve true
	 * GIVEN Se crea un seatManager y varias personas a sentar
	 * WHEN Se sienta una persona adulta no jubilada y a otra persona en ese asiento con el m�todo bookSeat 
	 * THEN Se comprueba que el m�todo devuelve True
	 */
	@Test
	public void testBookSeatWithAnAdult() {
		sm1.bookSeat(adult1,6,3);
		assertTrue(sm1.bookSeat(child2,6,3));
	}
	
	/**
	 * 3- El asiento est� ocupado por una persona no adulta -> No sienta a la persona y devuelve false
	 * GIVEN Se crea un seatManager y varias personas a sentar
	 * WHEN Se sienta una persona no adulta y no se sienta a otra persona en ese asiento con el m�todo bookSeat 
	 * THEN Se comprueba que el m�todo devuelve False
	 */
	@Test
	public void testBookSeatWithAChild() {
		sm1.bookSeat(child1, 5, 2);
		assertFalse(sm1.bookSeat(adult2, 5,2));
	}
	
	/**
	 * 4- El asiento est� ocupado pro una persona adulta jubilada -> No sienta a la persona y devuelve false
	 * GIVEN Se crea un seatManager y varias personas a sentar
	 * WHEN Se sienta una persona adulta jubilada y no se sienta a otra persona en ese asiento con el m�todo bookSeat 
	 * THEN Se comprueba que el m�todo devuelve False
	 */
	@Test
	public void testBookSeatWithARetired() {
		sm1.bookSeat(retired1, 0,0);
		assertFalse(sm1.bookSeat(adult2, 0,0));
	}
	
//Negativas (Pruebas de robustez):
	/**
	 * 5- Se introduce un pasajero null -> Lanza la excepci�n
	 * GIVEN Se crea un seatManager y varias personas a sentar
	 * WHEN Se pasa como par�metro null 
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testBookSeatNullPassenger() {
		sm1.bookSeat(null, 2, 3);
	}
	
	/**
	 * 6- La fila introducida es menor a 0 -> Lanza la excepci�n
	 * GIVEN Se crea un seatManager y varias personas a sentar
	 * WHEN Se pasa como par�metro una persona y una fila no valida 
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testBookSeatNegativeRow() {
		sm1.bookSeat(retired2, -2, 3);
	}
	
	/**
	 * 7- La fila introducida es mayor que el numero de filas -> Lanza la excepci�n
	 * GIVEN Se crea un seatManager y varias personas a sentar
	 * WHEN Se pasa como par�metro una persona y una fila no valida
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testBookSeatOverRows() {
		sm1.bookSeat(childToSeat, 14, 3);
	}
	
	/**
	 * 8- La columna introducida es menor a 0 -> Lanza la excepci�n
	 * GIVEN Se crea un seatManager y varias personas a sentar
	 * WHEN Se pasa como par�metro una persona y una columna no valida 
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testBookSeatNegativeColumn() {
		sm1.bookSeat(adultToSeat, 5, -2);
	}
	
	/**
	 * 9- La columna introducida es mayor que el numero de columnas -> Lanza la excepci�n
	 * GIVEN Se crea un seatManager y varias personas a sentar
	 * WHEN Se pasa como par�metro una persona y una columna no valida 
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testBookSeatOverColumns() {
		sm1.bookSeat(retiredToSeat, 5, 6);
	}
	
	/**
	 * 10- La fila y la columna introducidas son inferiores a 0 -> Lanza la excepci�n
	 * GIVEN Se crea un seatManager y varias personas a sentar
	 * WHEN Se pasa como par�metro una persona y la fila y la columna no son validas 
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testBookSeatBothNegative() {
		sm1.bookSeat(adult1, -2, -2);
	}
	
	/**
	 * 11- La fila y la columna introducidas son mayores que el numero de filas y columnas -> Lanza la excepci�n
	 * GIVEN Se crea un seatManager y varias personas a sentar
	 * WHEN Se pasa como par�metro una persona y la fila y la columna no son validas 
	 * THEN Se lanza la excepci�n
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testBookSeatBothOverRowsColumns() {
		sm1.bookSeat(adult2, 14, 6);
	}
}