package uo.mp.s5.dome.model.book;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s5.dome.model.Book;

/**
 * Titulo: Clase ToStringTest
 * 
 * @author Omitg
 * @version 04-03-2021
 */
public class ToStringTest {
	/**
	 * Atributos libro
	 */
	private Book book1, book2, book3;
	
	/**
	 * Creacion de objetos para su uso posterior
	 */
	@Before
	public void setUp() {
		book1 = new Book("The Truth about the Harry Quebert Affair","Joël Dicker",
				"DEBOLSILLO", "978-8466332286", 10.95);
		book2 = new Book("The Fall of the Giants","Ken Follet", "DEBOLSILLO",
				"978-8499899800", 10.95);
		book3 = new Book("Batman The Killing Joke","Alan Moore & Brian Azzarello",
				"DC Comics", "978-0930289454", 19.95);
	}
	
	/**
	 * Pruebas del método toString de la calse Book:
	 * 1- toString a book1
	 * 2- toString a book2
	 * 3- toString a book3
	 */
	
	/**
	 * 1- toString a book1
	 * GIVEN Se crean varios Books
	 * WHEN Se llama al método toString
	 * THEN Se comprueba que la salida es correcta
	 */
	@Test
	public void test1() {
		String expected = "This is the superclass of the Items:\n"
				+ "Title: The Truth about the Harry Quebert Affair\n"
				+ "Base price: 10.95 $\n"
				+ "Final price: 15.329999999999998 $\n"
				+ "You dont own it\n"
				+ "Comment : No comment\n"
				+ "Author: Joël Dicker\n"
				+ "Editorial: DEBOLSILLO\n"
				+ "ISBN: 978-8466332286\n";				
		assertEquals(expected, book1.toString());
	}
	
	/**
	 * 2- toString a book2
	 * GIVEN Se crean varios Books
	 * WHEN Se llama al método toString
	 * THEN Se comprueba que la salida es correcta
	 */
	@Test
	public void test2() {
		String expected = "This is the superclass of the Items:\n"
				+ "Title: The Fall of the Giants\n"
				+ "Base price: 10.95 $\n"
				+ "Final price: 15.329999999999998 $\n"
				+ "You dont own it\n"
				+ "Comment : No comment\n"
				+ "Author: Ken Follet\n"
				+ "Editorial: DEBOLSILLO\n"
				+ "ISBN: 978-8499899800\n";	
		assertEquals(expected, book2.toString());
	}
	
	/**
	 * 3- toString a book3
	 * GIVEN Se crean varios Books
	 * WHEN Se llama al método toString
	 * THEN Se comprueba que la salida es correcta
	 */
	@Test
	public void test3() {
		String expected = "This is the superclass of the Items:\n"
				+ "Title: Batman The Killing Joke\n"
				+ "Base price: 19.95 $\n"
				+ "Final price: 27.93 $\n"
				+ "You dont own it\n"
				+ "Comment : No comment\n"
				+ "Author: Alan Moore & Brian Azzarello\n"
				+ "Editorial: DC Comics\n"
				+ "ISBN: 978-0930289454\n";	
		assertEquals(expected, book3.toString());
	}
}
