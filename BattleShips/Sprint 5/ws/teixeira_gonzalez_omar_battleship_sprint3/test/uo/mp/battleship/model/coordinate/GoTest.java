package uo.mp.battleship.model.coordinate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.battleship.board.Coordinate;

/**
 * Titulo: Clase GoTest
 * 
 * @author Omitg
 * @version 24-03-2021
 */
public class GoTest {	
	/**
	 * Pruebas del m�todo go de la clase Coordinate:
	 * 1- Coordinate en columna A, direcci�n Oeste
	 * 2- Coordinate en fila 0, direcci�n Norte
	 * 3- Coordinate en columna E y fila 5, direcci�n Norte
	 * 4- Coordinate en columna E y fila 5, direcci�n Este
	 * 5- Coordinate en columna E y fila 5, direcci�n Sur
	 * 6- Coordinate en columna E y fila 5, direcci�n Oeste 
	 */
	
	/**
	 * 1- Coordinate en columna A, direcci�n Oeste
	 * GIVEN Se crea un objeto coordenadas en la columna A
	 * WHEM Se llama al m�todo go al Oeste
	 * THEN Se devuelve la coordenada en la misma posici�n
	 */
	@Test
	public void testAColumn() {
		Coordinate coord = new Coordinate('A',0);		
		assertEquals("Coordenada [ x = 65, y = 0 ]",
				coord.go(Coordinate.W).toString());
	}
	
	/**
	 * 2- Coordinate en fila 0, direcci�n Norte
	 * GIVEN Se crea un objeto coordenadas en la fila 0
	 * WHEM Se llama al m�todo go al Norte
	 * THEN Se devuelve la coordenada en la misma posici�n
	 */
	@Test
	public void test0Row() {
		Coordinate coord = new Coordinate('E',0);		
		assertEquals("Coordenada [ x = 69, y = 0 ]",
				coord.go(Coordinate.N).toString());
	}
	
	/**
	 * 3- Coordinate en columna E y fila 5, direcci�n Norte
	 * GIVEN Se crea un objeto coordenadas en la columna E fila 5
	 * WHEM Se llama al m�todo go al Norte
	 * THEN Se devuelve la coordenada desplazada a arriba
	 */
	@Test
	public void testE5North() {
		Coordinate coord = new Coordinate('E',5);		
		assertEquals("Coordenada [ x = 69, y = 4 ]",
				coord.go(Coordinate.N).toString());
	}
	
	/**
	 * 4- Coordinate en columna E y fila 5, direcci�n Este
	 * GIVEN Se crea un objeto coordenadas en la columna E fila 5
	 * WHEM Se llama al m�todo go al Este
	 * THEN Se devuelve la coordenada desplazada a la derecha
	 */
	@Test
	public void testE5East() {
		Coordinate coord = new Coordinate('E',5);		
		assertEquals("Coordenada [ x = 70, y = 5 ]",
				coord.go(Coordinate.E).toString());
	}
	
	/**
	 * 5- Coordinate en columna E y fila 5, direcci�n Sur
	 * GIVEN Se crea un objeto coordenadas en la columna E fila 5
	 * WHEM Se llama al m�todo go al Sur
	 * THEN Se devuelve la coordenada desplazada a abajo
	 */
	@Test
	public void testE5South() {
		Coordinate coord = new Coordinate('E',5);		
		assertEquals("Coordenada [ x = 69, y = 6 ]",
				coord.go(Coordinate.S).toString());
	}
	
	/**
	 * 6- Coordinate en columna E y fila 5, direcci�n Oeste
	 * GIVEN Se crea un objeto coordenadas en la columna E fila 5
	 * WHEM Se llama al m�todo go al Oeste
	 * THEN Se devuelve la coordenada desplazada a la izquierda
	 */
	@Test
	public void testE5West() {
		Coordinate coord = new Coordinate('E',5);		
		assertEquals("Coordenada [ x = 68, y = 5 ]",
				coord.go(Coordinate.W).toString());
	}
}
