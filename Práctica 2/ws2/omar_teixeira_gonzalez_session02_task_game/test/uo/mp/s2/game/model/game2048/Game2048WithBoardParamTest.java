package uo.mp.s2.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s2.game.model.Game2048;

/**
 * <p>
 * T�tulo: Clase Game2048WithBoardParamTest
 * <p>
 *  
 * @author Omar Teixeira Gonz�lez
 * @version 11/02/2021
 */

public class Game2048WithBoardParamTest {
	
	/**
	 * Pruebas del constructor con par�metro board de la clase Game2048: 
	 * Positivos:
	 * 1- La matriz cumple los requisitos -> Crea el tablero
	 * 
	 * Negativos (Pruebas de robustez):
	 * 2- La matriz es null -> Lanza la excepci�n
	 * 3- La matriz tiene una dimensi�n inferior al limite minimo -> Lanza la excepci�n
	 * 4- La matriz tiene una dimensi�n superior al l�mite m�ximo -> Lanza la excepci�n
	 * 5- Las filas de la matriz tienen distinto tama�o -> Lanza la excepci�n
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
	 * 2- La matriz es null -> Lanza la excepci�n
	 * GIVEN Game recibe null
	 * WHEN 
	 * THEN Lanza la excepci�n
	 */
	@Test
	public void testConstructorWithBoardParamNull() {
		try {
			new Game2048(null);
			fail("Esperaba excepci�n");
		}catch(RuntimeException msg) {
			assertEquals("El tablero no cumple los requisitos", msg.getMessage());
		}
	}
	
	/**
	 * 3- La matriz tiene una dimensi�n inferior al limite minimo -> Lanza la excepci�n
	 * GIVEN Game recibe una matriz de ceros que no cumple el limite minimo
	 * WHEN 
	 * THEN Lanza la excepci�n
	 */
	@Test
	public void testConstructorWithBoardParamUnderLowerLimit() {
		try {
			new Game2048(new int[][] {{0,0},{0,0}});
			fail("Esperaba excepci�n");
		}catch(RuntimeException msg) {
			assertEquals("El tablero no cumple los requisitos", msg.getMessage());
		}
	}
	
	/**
	 * 4- La matriz tiene una dimensi�n superior al l�mite m�ximo -> Lanza la excepci�n
	 * GIVEN Game recibe una matriz de ceros que no cumple el limite maximo
	 * WHEN 
	 * THEN Lanza la excepci�n
	 */
	@Test
	public void testConstructorWithBoardParamOverUpperLimit() {
		try {
			new Game2048(new int[][] {{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0}});
			fail("Esperaba excepci�n");
		}catch(RuntimeException msg) {
			assertEquals("El tablero no cumple los requisitos", msg.getMessage());
		}
	}
	
	/**
	 * 5- Las filas de la matriz tienen distinto tama�o -> Lanza la excepci�n
	 * GIVEN Game recibe una matriz de ceros cuyo numero de filas es distinto al numero de columnas
	 * WHEN 
	 * THEN Lanza la excepci�n
	 */
	@Test
	public void testConstructorWithBoardParamDifRowColumns() {
		try {
			new Game2048(new int[][] {{0,0,0},{0,0,0},{0,0}});
			fail("Esperaba excepci�n");
		}catch(RuntimeException msg) {
			assertEquals("El tablero no cumple los requisitos", msg.getMessage());
		}
	}
}
