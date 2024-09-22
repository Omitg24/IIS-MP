package uo.mp.s2.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s2.game.model.Game2048;

/**
 * <p>
 * T�tulo: Clase Game2048WithIntParamTest 
 * <p>
 *  
 * @author Omar Teixeira Gonz�lez
 * @version 11/02/2021
 */

public class Game2048WithIntParamTest {
	
	/**
	 *  Pruebas para el constructor con par�metros de la clase Game2048:
	 *  Positivos:
	 *  1- La dimensi�n est� dentro de los limites -> Crea el tablero
	 *  2- La dimensi�n est� en el l�mite inferior -> Crea el tablero
	 *  3- La dimensi�n est� en el l�mite superior -> Crea el tablero
	 *  4- La dimensi�n est� por debajo del limite inverior -> Crea un tablero 3x3
	 *  5- La dimensi�n est� por encima del l�mite superior -> Crea un tablero 3x3
	 */
	
	//Positivos:
	
	/**
	 * 1- La dimensi�n est� dentro de los limites -> Crea el tablero
	 * GIVEN Game recibe una dimensi�n y crea una matriz con esa dimension (n�_filasXn�_columnas) 
	 * y se crea una matriz esperada
	 * WHEN 
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testConstructorWithDimensionParamInLimits() {
		Game2048 game = new Game2048(5);
		int[][] expected = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		assertArrayEquals(expected,game.getBoard());
	}
	
	/**
	 * 2- La dimensi�n est� en el l�mite inferior -> Crea el tablero
	 * GIVEN Game recibe una dimensi�n y crea una matriz con esa dimension (n�_filasXn�_columnas) 
	 * y se crea una matriz esperada
	 * WHEN 
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testConstructorWithDimensionParamInLowerLimit() {
		Game2048 game = new Game2048(3);
		int[][] expected = {{0,0,0},{0,0,0},{0,0,0}};
		assertArrayEquals(expected,game.getBoard());
	}
	
	/**
	 * 3- La dimensi�n est� en el l�mite superior -> Crea el tablero
	 * GIVEN Game recibe una dimensi�n y crea una matriz con esa dimension (n�_filasXn�_columnas) 
	 * y se crea una matriz esperada
	 * WHEN 
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testConstructorWithDimensionParamInUpperLimit() {
		Game2048 game = new Game2048(10);
		int[][] expected = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}};
		assertArrayEquals(expected,game.getBoard());	
	}
	
	/**
	 * 4- La dimensi�n est� por debajo del limite inverior -> Crea un tablero 3x3
	 * GIVEN Game recibe una dimensi�n incorrecta (inferior al limite inferior) y crea una matriz con 3x3 
	 * y se crea una matriz esperada
	 * WHEN 
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testConstructorWithDimensionParamUnderLowerLimit() {
		Game2048 game = new Game2048(2);
        int[][] expected = {{0,0,0},{0,0,0},{0,0,0}};
        assertArrayEquals(expected,game.getBoard());
	}
	
	/**
	 * 5- La dimensi�n est� por encima del l�mite superior -> Crea un tablero 3x3
	 * GIVEN Game recibe una dimensi�n incorrecta (superior al limite superior) y crea una matriz con 3x3 
	 * y se crea una matriz esperada
	 * WHEN 
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testConstructorWithDimensionParamOverUpperLimit() {
		Game2048 game = new Game2048(12);
        int[][] expected = {{0,0,0},{0,0,0},{0,0,0}};
        assertArrayEquals(expected,game.getBoard());
	}
}
