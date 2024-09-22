package uo.mp.s2.seatmanager.model.seatmanager;


import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.Before;

import uo.mp.s2.seatmanager.model.Person;
import  uo.mp.s2.seatmanager.model.SeatManager;

/**
 * <p>
 * Titulo: Clase FindPassengersByAgeTest
 *   
 * @author Omitg
 * @version 13/02/2021
 */

public class FindPassengersByAgeTest {
	
	/**
	 * Atributo seatManager 1
	 */
	private SeatManager sm1;
	
	/**
	 * Atributo seatManager 2
	 */
	private SeatManager sm2;
	
	/**
	 * Niño 1
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
	 * Niño 2
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
	 * Niño a sentar
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
        sm2= new SeatManager(SeatManager.MAX_ROWS, SeatManager.MAX_COLUMNS);
        child1 = new Person ("María", 2);
		adult1 = new Person ("Marta", 24);
		retired1 = new Person ("Jose", 78);
		child2 = new Person ("Pablo", 7);
		adult2 = new Person ("Andres", 20);
		retired2 = new Person ("Juan", 65);
		childToSeat = new Person ("Ines", 12);
		adultToSeat = new Person ("Elsa", 22);
		retiredToSeat = new Person ("Ramon", 82);
		sm1.bookSeat(child1,0,1);
		sm1.bookSeat(adult1,1,3);
		sm1.bookSeat(retired1,6,0);
		sm1.bookSeat(child2,5,3);
		sm1.bookSeat(adult2,4,2);
		sm1.bookSeat(retired2,9,3);		
    }
	
	/**
	 * Pruebas del método findPassengersByAge de la clase SeatManager:
	 * Positivas (Pruebas de funcionalidad):
	 * 1- Edades dentro de los límites -> Devuelve las personas sentadas en filas pares en el rango de edades 
	 * 2- Edades cubren todos los límites -> Devuelve las personas sentadas en filas pares
	 * 3- No hay nadie sentado en el array -> Devuelve un array vacío
	 * 4- No hay nadie sentado en filas pares -> Devuelve un array vacío
	 * 5- Hay gente sentada en las filas pares -> Devuelve un array con las personas dentro 
	 * 
	 * Negativas (Pruebas de robustez):
	 * 6- Edad mínima inferior a la edad minima posible -> Lanza la excepción
	 * 7- Edad máxima superior a la edad máxima posible -> Lanza la excepción
	 * 8- Los parámetros no son posibles (limite minimo mayor que el máximo) -> Lanza la excepción
	 */

//Positivas (Pruebas de funcionalidad):
	/**
	 * 1- Edades dentro de los límites -> Devuelve las personas sentadas en filas pares en el rango de edades 
	 * GIVEN Se crea un SeatManager y varias personas que se sientan mediante el bookSeat
	 * WHEN Se llama al método findPassengersByAge con un rango de edades determinado, que crea una lista con los que cumplen los requisitos
	 * THEN Se comprueba que esa lista contiene a ciertas personas 
	 */
	@Test
	public void testFindPassengersByAgeAgeInLimits() {		
		ArrayList<Person> list = sm1.findPassengersByAge(10, 80);
		assertNotNull(sm1.findPassengersByAge(10, 80));
		assertTrue(list.contains(retired1));
		assertTrue(list.contains(adult2));
	}
	
	/**
	 * 2- Edades cubren todos los límites -> Devuelve las personas sentadas en filas pares
	 * GIVEN Se crea un SeatManager y varias personas que se sientan mediante el bookSeat
	 * WHEN Se llama al método findPassengersByAge con todo el rango de edades, que crea una lista con los que cumplen los requisitos
	 * THEN Se comprueba que esa lista contiene a ciertas personas 
	 */
	@Test
	public void testFindPassengersByAgeAllAges() {		
		ArrayList<Person> list = sm1.findPassengersByAge(Person.MIN_AGE, Person.MAX_AGE);
		assertNotNull(sm1.findPassengersByAge(Person.MIN_AGE, Person.MAX_AGE));
		assertTrue(list.contains(child1));
		assertTrue(list.contains(retired1));
		assertTrue(list.contains(adult2));
	}
	
	/**
	 * 3- No hay nadie sentado en el array -> Devuelve un array vacío
	 * GIVEN Se crea un SeatManager y no se sienta a nadie
	 * WHEN Se llama al método findPassengersByAge, que crea una lista vacía, porque no hay nadie sentado
	 * THEN Se comprueba que esa lista esta vacía
	 */
	@Test
	public void testFindPassengersByAgeEmpty() {		
		ArrayList<Person> list = sm2.findPassengersByAge(Person.MIN_AGE, Person.MAX_AGE);
		assertNotNull(sm2.findPassengersByAge(Person.MIN_AGE, Person.MAX_AGE));
		assertTrue(list.isEmpty());
	}
	
	/**
	 * 4- No hay nadie sentado en filas pares -> Devuelve un array vacío
	 * GIVEN Se crea un SeatManager y varias personas que se sientan mediante el bookSeat, pero ninguna en filas pares
	 * WHEN Se llama al método findPassengersByAge, que crea una lista vacía, porque no hay nadie sentado en filas pares
	 * THEN Se comprueba que esa lista está vacía al no estar ninguno sentado en filas pares
	 */
	@Test
	public void testFindPassengersByAgeOnlyInOdds() {		
		sm2.bookSeat(childToSeat, 1, 3);
		sm2.bookSeat(adultToSeat, 5, 2);
		sm2.bookSeat(retiredToSeat, 7, 0);
		ArrayList<Person> list = sm2.findPassengersByAge(Person.MIN_AGE, Person.MAX_AGE);
		assertNotNull(sm2.findPassengersByAge(Person.MIN_AGE, Person.MAX_AGE));
		assertTrue(list.isEmpty());
	}	
	
	/**
	 * 5- Hay gente sentada en las filas pares -> Devuelve un array con las personas dentro
	 * GIVEN Se crea un SeatManager y varias personas que se sientan mediante el bookSeat
	 * WHEN Se llama al método findPassengersByAge, que crea una lista con los que cumplen los requisitos
	 * THEN Se comprueba que esa lista contiene a ciertas personas 
	 */
	@Test
	public void testFindPassengersByAgeInPair() {		
		sm1.bookSeat(childToSeat, 2, 3);
		sm1.bookSeat(adultToSeat, 8, 2);
		sm1.bookSeat(retiredToSeat, 4, 0);
		ArrayList<Person> list = sm1.findPassengersByAge(Person.MIN_AGE, Person.MAX_AGE);
		assertNotNull(sm1.findPassengersByAge(Person.MIN_AGE, Person.MAX_AGE));
		assertTrue(list.contains(child1));
		assertTrue(list.contains(retired1));
		assertTrue(list.contains(adult2));
		assertTrue(list.contains(childToSeat));
		assertTrue(list.contains(adultToSeat));
		assertTrue(list.contains(retiredToSeat));	
	}
//Negativas (Pruebas de robustez):
	/**
	 * 6- Edad mínima inferior a la edad minima posible -> Lanza la excepción
	 * GIVEN Se crea un SeatManager y varias personas que se sientan mediante el bookSeat
	 * WHEN Se llama al método findPassengersByAge con el limite de edad inferior no valido
	 * THEN Se lanza la excepción
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testFindPassengersByAgeMinAgeUnderMinLimit() {
		sm1.findPassengersByAge(-5, 70);
	}
	
	/**
	 * 7- Edad máxima superior a la edad máxima posible -> Lanza la excepción
	 * GIVEN Se crea un SeatManager y varias personas que se sientan mediante el bookSeat
	 * WHEN Se llama al método findPassengersByAge con el limite de edad  superior no valido
	 * THEN Se lanza la excepción
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testFindPassengersByAgeMaxAgeOverMaxLimit() {
		sm1.findPassengersByAge(10, 130);
	}
	
	/**
	 * 8- Los parámetros no son posibles (limite minimo mayor que el máximo) -> Lanza la excepción
	 * GIVEN Se crea un SeatManager y varias personas que se sientan mediante el bookSeat
	 * WHEN Se llama al método findPassengersByAge en el que el limite de edad inferior es mayor al superior
	 * THEN Se lanza la excepción
	 */
	@Test
	(expected=IllegalArgumentException.class)
	public void testFindPassengersByAgeMinAgeOverMaxLimit() {
		sm1.findPassengersByAge(90, 50);
	}	
}
