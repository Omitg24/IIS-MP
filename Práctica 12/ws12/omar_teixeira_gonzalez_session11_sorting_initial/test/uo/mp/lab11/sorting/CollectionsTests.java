package uo.mp.lab11.sorting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import uo.mp.lab11.person.Person;
import uo.mp.lab11.person.PersonBySurnameNameComparator;

/**
 * Titulo: ColleciontsTests
 * 
 * @author Omitg
 * @version 22-04-2021
 */
public class CollectionsTests {

	/**
	 * 1- Test de Integers
	 * GIVEN Se añade una lista
	 * WHEN Se ordena la lista
	 * THEN Se comprueba que se ha ordenado
	 */
	@Test
	public void testIntegers() {
		List<Integer> list = new LinkedList<>();
		
		list.add( 2 );
		list.add( 3 );
		list.add( 1 );
		list.add( 4 );
		
		Collections.sort(list);

		assertTrue( "[1, 2, 3, 4]".equals( list.toString() ) );
	}

	/**
	 * 2- Test de String
	 * GIVEN Se añade una lista
	 * WHEN Se ordena la lista
	 * THEN Se comprueba que se ha ordenado
	 */
	@Test
	public void testSrings() {
		List<String> list = new LinkedList<>();
		
		list.add( "b" );
		list.add( "d" );
		list.add( "a" );
		list.add( "c" );
		
		Collections.sort(list);

		assertTrue( "[a, b, c, d]".equals( list.toString() ) );
	}
	
	/**
	 * 3- Test de Person
	 * GIVEN Se añade una lista
	 * WHEN Se ordena la lista
	 * THEN Se comprueba que se ha ordenado
	 */
	@Test
	public void testPersons() {
		Person p1 = new Person("Manuel", "Pérez", 12);
		Person p2 = new Person("Andrea", "Pérez", 14); 
		Person p3 = new Person("María", "Gómez", 10);
		Person p4 = new Person("Manuel", "García", 10);
		
		List<Person> list = new LinkedList<>();
		list.add( p1 );
		list.add( p2 );
		list.add( p3 );
		list.add( p4 );
		
		List<Person> expected = new LinkedList<>();
		expected.add( p4 );
		expected.add( p3 );
		expected.add( p1 );
		expected.add( p2 );

		Collections.sort(list);

		assertEquals( expected, list);
	}
	
	/**
	 * 4- Test de Person por apellido
	 * GIVEN Se añade una lista
	 * WHEN Se ordena la lista
	 * THEN Se comprueba que se ha ordenado
	 */
	@Test
	public void testPersonsOther() {
		Person p1 = new Person("Manuel", "Alvarez", 12);
		Person p2 = new Person("Andrea", "Alvarez", 14); 
		Person p3 = new Person("María", "Gómez", 10);
		Person p4 = new Person("Manuel", "García", 10);
		
		List<Person> list = new LinkedList<>();
		list.add( p1 );
		list.add( p2 );
		list.add( p3 );
		list.add( p4 );
		
		List<Person> expected = new LinkedList<>();
		expected.add( p2 );
		expected.add( p1 );
		expected.add( p4 );
		expected.add( p3 );

		Collections.sort(list, new PersonBySurnameNameComparator());

		assertEquals( expected, list);
	}
}
