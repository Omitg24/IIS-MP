package uo.mp.battleship.model.coordinate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.battleship.board.Coordinate;

/**
 * Titulo: Clase toUserStringTest
 *  
 * @author Omitg
 * @version 12-02-2021
 */
public class toUserStringTest {
	
	/**
	 * Pruebas del método toUserString de la clase Coordinate:
	 * 1- Las coordenadas son x=1 e y=1 -> Devuelve "A-1"
	 * 2- Las coordenadas son x=3 e y=5 -> Devuelve "C-5"
	 * 3- Las coordenadas son x=5 e y=2 -> Devuelve "E-2"
	 * 4- Las coordenadas son x=7 e y=6 -> Devuelve "G-6"
	 * 5- Las coordenadas son x=8 e y=9 -> Devuelve "H-9"
	 */
	
	/**
	 * 1- Las coordenadas son x=1 e y=1 -> Devuelve "A-1"
	 * GIVEN Se crea un coodinador con las coordenadas como parámetro
	 * WHEN Se llama al método toUserString
	 * THEN Se comprueba que coinciden los resultados con el esperado
	 */
	@Test
	public void testToUserString1x1() {
		Coordinate coordinate = new Coordinate(1,1);
		assertEquals("A-1",coordinate.toUserString());
	}
	
	/**
	 * 2- Las coordenadas son x=3 e y=5 -> Devuelve "C-5"
	 * GIVEN Se crea un coodinador con las coordenadas como parámetro
	 * WHEN Se llama al método toUserString
	 * THEN Se comprueba que coinciden los resultados con el esperado
	 */
	@Test
	public void testToUserString3x5() {
		Coordinate coordinate = new Coordinate(3,5);
		assertEquals("C-5",coordinate.toUserString());
	}
	
	/**
	 * 3- Las coordenadas son x=5 e y=2 -> Devuelve "E-2"
	 * GIVEN Se crea un coodinador con las coordenadas como parámetro
	 * WHEN Se llama al método toUserString
	 * THEN Se comprueba que coinciden los resultados con el esperado
	 */
	@Test
	public void testToUserString5x2() {
		Coordinate coordinate = new Coordinate(5,2);
		assertEquals("E-2",coordinate.toUserString());
	}
	
	/**
	 * 4- Las coordenadas son x=7 e y=6 -> Devuelve "G-6"
	 * GIVEN Se crea un coodinador con las coordenadas como parámetro
	 * WHEN Se llama al método toUserString
	 * THEN Se comprueba que coinciden los resultados con el esperado
	 */
	@Test
	public void testToUserString7x6() {
		Coordinate coordinate = new Coordinate(7,6);
		assertEquals("G-6",coordinate.toUserString());
	}
	
	/**
	 * 5- Las coordenadas son x=8 e y=9 -> Devuelve "H-9"
	 * GIVEN Se crea un coodinador con las coordenadas como parámetro
	 * WHEN Se llama al método toUserString
	 * THEN Se comprueba que coinciden los resultados con el esperado
	 */
	@Test
	public void testToUserString8x9() {
		Coordinate coordinate = new Coordinate(8,9);
		assertEquals("H-9",coordinate.toUserString());
	}
}