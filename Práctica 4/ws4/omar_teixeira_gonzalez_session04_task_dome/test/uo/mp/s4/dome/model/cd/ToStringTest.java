package uo.mp.s4.dome.model.cd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s4.dome.model.Cd;

/**
 * Titulo: Clase ToStringTest
 * 
 * @author Omitg
 * @version 26-02-2021
 */
public class ToStringTest {
	/**
	 * Atributos cd
	 */
	private Cd cd1, cd2, cd3;
		
	/**
	 * Creación de atributos para su posterior uso
	 */
	@Before
	public void setUp() {		
		cd1 = new Cd("TIM", "Avicii", 12, 38, 19.99);
		cd2 = new Cd("The Dark Knight SoundTrack", "Hans Zimmer & James Newton Howard", 
				28, 146, 39.99); 
		cd3 = new Cd("Meteora (Bonus Edition)", "Linkin Park", 16, 46, 14.99);		
	}
	
	/**
	 * Pruebas del método toString de la calse Cd:
	 * 1- toString a cd1
	 * 2- toString a cd2
	 * 3- toString a cd3
	 */
	
	/**
	 * 1- toString a cd1
	 * GIVEN Se crean varios Cds
	 * WHEN Se llama al método toString
	 * THEN Se comprueba que la salida es correcta
	 */
	@Test
	public void test1() {
		String expected = "This is the superclass of the Items:\n"
				+ "Title: TIM\n"
				+ "Base price: 19.99 $\n"
				+ "You own it\n"
				+ "Comment : No comment\n"
				+ "CD: (38 mins)\n"
				+ "Artist: Avicii\n"
				+ "Tracks: 12\n";
		assertEquals(expected, cd1.toString());
	}
	
	/**
	 * 2- toString a cd2
	 * GIVEN Se crean varios Cds
	 * WHEN Se llama al método toString
	 * THEN Se comprueba que la salida es correcta
	 */
	@Test
	public void test2() {
		String expected = "This is the superclass of the Items:\n"
				+ "Title: The Dark Knight SoundTrack\n"
				+ "Base price: 39.99 $\n"
				+ "You own it\n"
				+ "Comment : No comment\n"
				+ "CD: (146 mins)\n"
				+ "Artist: Hans Zimmer & James Newton Howard\n"
				+ "Tracks: 28\n";
		assertEquals(expected, cd2.toString());
	}
	
	/**
	 * 3- toString a cd3
	 * GIVEN Se crean varios Cds
	 * WHEN Se llama al método toString
	 * THEN Se comprueba que la salida es correcta
	 */
	@Test
	public void test3() {
		String expected = "This is the superclass of the Items:\n"
				+ "Title: Meteora (Bonus Edition)\n"
				+ "Base price: 14.99 $\n"
				+ "You own it\n"
				+ "Comment : No comment\n"
				+ "CD: (46 mins)\n"
				+ "Artist: Linkin Park\n"
				+ "Tracks: 16\n";
		assertEquals(expected, cd3.toString());
	}
}
