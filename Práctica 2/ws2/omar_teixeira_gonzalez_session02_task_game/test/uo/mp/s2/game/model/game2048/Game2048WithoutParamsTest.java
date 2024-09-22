package uo.mp.s2.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

import uo.mp.s2.game.model.Game2048;

/**
 * <p>
 * Título: Clase Game2048WithoutParamsTest 
 * <p>
 *  
 * @author Omar Teixeira González
 * @version 11/02/2021
 */

public class Game2048WithoutParamsTest {
	
	/**
	 * Pruebas del constructor sin parámetros de la clase Game2048:
	 * 1- Genera el tablero
	 */
	
	/**
	 * 1- Genera el tablero
	 * GIVEN Se llama al constructor sin parametros, que crea una matriz 3x3 de 0s,
	 * se crea una matriz esperada, también de 0s
	 * WHEN 
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testConstructorWithoutParams() {
		Game2048 game = new Game2048();
		int[][] expected= {{0,0,0},{0,0,0},{0,0,0}};
		assertArrayEquals(expected,game.getBoard());
	}
}
