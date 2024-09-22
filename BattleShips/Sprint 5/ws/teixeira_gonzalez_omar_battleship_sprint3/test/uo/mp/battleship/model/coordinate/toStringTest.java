package uo.mp.battleship.model.coordinate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.battleship.board.Coordinate;

/**
 * Titulo: Clase toStringTest
 *  
 * @author Omitg
 * @version 24-03-2021
 */
public class toStringTest {
	
	/**
	 * Pruebas del método toString de la clase Coordinate:
	 * 1- Las coordenadas son x=1 e y=1 -> Devuelve "Coordenada [ x = 1, y = 1 ]"
	 * 2- Las coordenadas son x=3 e y=5 -> Devuelve "Coordenada [ x = 3, y = 5 ]"
	 * 3- Las coordenadas son x=5 e y=2 -> Devuelve "Coordenada [ x = 5, y = 2 ]"
	 * 4- Las coordenadas son x=7 e y=6 -> Devuelve "Coordenada [ x = 7, y = 6 ]"
	 * 5- Las coordenadas son x=8 e y=9 -> Devuelve "Coordenada [ x = 8, y = 9 ]"
	 */
	
	/**
	 * 1- Las coordenadas son x=1 e y=1 -> Devuelve "Coordenada [ x = 1, y = 1 ]"
	 * GIVEN Se crea un coodinador con las coordenadas como parámetro
	 * WHEN Se llama al método toString
	 * THEN Se comprueba que coinciden los resultados con el esperado
	 */
	@Test
	public void testToUserString1x1() {
		Coordinate coordinate = new Coordinate(1,1);
		assertEquals("Coordenada [ x = 1, y = 1 ]",coordinate.toString());
	}
	
	/**
	 * 2- Las coordenadas son x=3 e y=5 -> Devuelve "Coordenada [ x = 3, y = 5 ]"
	 * GIVEN Se crea un coodinador con las coordenadas como parámetro
	 * WHEN Se llama al método toString
	 * THEN Se comprueba que coinciden los resultados con el esperado
	 */
	@Test
	public void testToUserString3x5() {
		Coordinate coordinate = new Coordinate(3,5);
		assertEquals("Coordenada [ x = 3, y = 5 ]",coordinate.toString());
	}
	
	/**
	 * 3- Las coordenadas son x=5 e y=2 -> Devuelve "Coordenada [ x = 5, y = 2 ]"
	 * GIVEN Se crea un coodinador con las coordenadas como parámetro
	 * WHEN Se llama al método toString
	 * THEN Se comprueba que coinciden los resultados con el esperado
	 */
	@Test
	public void testToUserString5x2() {
		Coordinate coordinate = new Coordinate(5,2);
		assertEquals("Coordenada [ x = 5, y = 2 ]",coordinate.toString());
	}
	
	/**
	 * 4- Las coordenadas son x=7 e y=6 -> Devuelve "Coordenada [ x = 7, y = 6 ]"
	 * GIVEN Se crea un coodinador con las coordenadas como parámetro
	 * WHEN Se llama al método toString
	 * THEN Se comprueba que coinciden los resultados con el esperado
	 */
	@Test
	public void testToUserString7x6() {
		Coordinate coordinate = new Coordinate(7,6);
		assertEquals("Coordenada [ x = 7, y = 6 ]",coordinate.toString());
	}
	
	/**
	 * 5- Las coordenadas son x=8 e y=9 -> Devuelve "Coordenada [ x = 8, y = 9 ]"
	 * GIVEN Se crea un coodinador con las coordenadas como parámetro
	 * WHEN Se llama al método toString
	 * THEN Se comprueba que coinciden los resultados con el esperado
	 */
	@Test
	public void testToUserString8x9() {
		Coordinate coordinate = new Coordinate(8,9);
		assertEquals("Coordenada [ x = 8, y = 9 ]",coordinate.toString());
	}
}