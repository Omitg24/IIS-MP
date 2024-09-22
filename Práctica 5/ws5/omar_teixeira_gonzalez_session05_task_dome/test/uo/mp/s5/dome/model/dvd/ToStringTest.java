package uo.mp.s5.dome.model.dvd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s5.dome.model.Dvd;

/**
 * Titulo: Clase ToStringTest
 * 
 * @author Omitg
 * @version 26-02-2021
 */
public class ToStringTest {
	/**
	 * Atributos game
	 */
	private Dvd dvd1, dvd2, dvd3;
		
	/**
	 * Creación de atributos para su posterior uso
	 */
	@Before
	public void setUp() {		
		dvd1 = new Dvd("Inception","Christopher Nolan", 162, 19.99);
		dvd2 = new Dvd("Gladiator","Ridley Scott", 171, 35.0);
		dvd3 = new Dvd("Vikings: Full Series", "Michael Hirst", 4005, 119.99);		
	}
	
	/**
	 * Pruebas del método toString de la calse Cd:
	 * 1- toString a dvd1
	 * 2- toString a dvd2
	 * 3- toString a dvd3
	 */
	
	/**
	 * 1- toString a dvd1
	 * GIVEN Se crean varios Dvds
	 * WHEN Se llama al método toString
	 * THEN Se comprueba que la salida es correcta
	 */
	@Test
	public void test1() {
		String expected = "This is the superclass of the Items:\n"
				+ "Title: Inception\n"
				+ "Base price: 19.99 $\n"
				+ "Final price: 19.99 $\n"
				+ "You dont own it\n"
				+ "Comment : No comment\n"
				+ "DVD: (162 mins)\n"
				+ "Director: Christopher Nolan\n";				
		assertEquals(expected, dvd1.toString());
	}
	
	/**
	 * 2- toString a dvd2
	 * GIVEN Se crean varios Dvds
	 * WHEN Se llama al método toString
	 * THEN Se comprueba que la salida es correcta
	 */
	@Test
	public void test2() {
		String expected = "This is the superclass of the Items:\n"
				+ "Title: Gladiator\n"
				+ "Base price: 35.0 $\n"
				+ "Final price: 35.0 $\n"
				+ "You dont own it\n"
				+ "Comment : No comment\n"
				+ "DVD: (171 mins)\n"
				+ "Director: Ridley Scott\n";
		assertEquals(expected, dvd2.toString());
	}
	
	/**
	 * 3- toString a dvd3
	 * GIVEN Se crean varios Dvds
	 * WHEN Se llama al método toString
	 * THEN Se comprueba que la salida es correcta
	 */
	@Test
	public void test3() {
		String expected = "This is the superclass of the Items:\n"
				+ "Title: Vikings: Full Series\n"
				+ "Base price: 119.99 $\n"
				+ "Final price: 119.99 $\n"
				+ "You dont own it\n"
				+ "Comment : No comment\n"
				+ "DVD: (4005 mins)\n"
				+ "Director: Michael Hirst\n";
		assertEquals(expected, dvd3.toString());
	}
}
