package uo.mp.s2.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s2.game.model.Game2048;

/**
 * <p>
 * Título: Clase Game2048WithBoardParamTest
 * <p>
 *  
 * @author Omar Teixeira González
 * @version 11/02/2021
 */

public class Game2048WithBoardParamTest {
	
	/**
	 * Pruebas del constructor con parámetro board de la clase Game2048: 
	 * Positivos:
	 * 1- La matriz cumple los requisitos -> Crea el tablero
	 * 
	 * Negativos (Pruebas de robustez):
	 * 2- La matriz es null -> Lanza la excepción
	 * 3- La matriz tiene una dimensión inferior al limite minimo -> Lanza la excepción
	 * 4- La matriz tiene una dimensión superior al límite máximo -> Lanza la excepción
	 * 5- Las filas de la matriz tienen distinto tamaño -> Lanza la excepción
	 */
	
	//Positivos:
	
	/**
	 * 1- La matriz cumple los requisitos -> Crea el tablero
	 * GIVEN Game recibe una matriz de ceros y se crea la matriz esperada de ceros
	 * WHEN 
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testConstructorWithBoardParamOk() {
		Game2048 game = new Game2048(new int[][]{{0,0,0},{0,0,0},{0,0,0}});
		int[][] expected = {{0,0,0},{0,0,0},{0,0,0}};
		assertArrayEquals(expected,game.getBoard());
	}
	
	//Negativos:
	
	/**
	 * 2- La matriz es null -> Lanza la excepción
	 * GIVEN Game recibe null
	 * WHEN 
	 * THEN Lanza la excepción
	 */
	@Test
	public void testConstructorWithBoardParamNull() {
		try {
			new Game2048(null);
			fail("Esperaba excepción");
		}catch(RuntimeException msg) {
			assertEquals("El tablero no cumple los requisitos", msg.getMessage());
		}
	}
	
	/**
	 * 3- La matriz tiene una dimensión inferior al limite minimo -> Lanza la excepción
	 * GIVEN Game recibe una matriz de ceros que no cumple el limite minimo
	 * WHEN 
	 * THEN Lanza la excepción
	 */
	@Test
	public void testConstructorWithBoardParamUnderLowerLimit() {
		try {
			new Game2048(new int[][] {{0,0},{0,0}});
			fail("Esperaba excepción");
		}catch(RuntimeException msg) {
			assertEquals("El tablero no cumple los requisitos", msg.getMessage());
		}
	}
	
	/**
	 * 4- La matriz tiene una dimensión superior al límite máximo -> Lanza la excepción
	 * GIVEN Game recibe una matriz de ceros que no cumple el limite maximo
	 * WHEN 
	 * THEN Lanza la excepción
	 */
	@Test
	public void testConstructorWithBoardParamOverUpperLimit() {
		try {
			new Game2048(new int[][] {{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0}});
			fail("Esperaba excepción");
		}catch(RuntimeException msg) {
			assertEquals("El tablero no cumple los requisitos", msg.getMessage());
		}
	}
	
	/**
	 * 5- Las filas de la matriz tienen distinto tamaño -> Lanza la excepción
	 * GIVEN Game recibe una matriz de ceros cuyo numero de filas es distinto al numero de columnas
	 * WHEN 
	 * THEN Lanza la excepción
	 */
	@Test
	public void testConstructorWithBoardParamDifRowColumns() {
		try {
			new Game2048(new int[][] {{0,0,0},{0,0,0},{0,0}});
			fail("Esperaba excepción");
		}catch(RuntimeException msg) {
			assertEquals("El tablero no cumple los requisitos", msg.getMessage());
		}
	}
}
