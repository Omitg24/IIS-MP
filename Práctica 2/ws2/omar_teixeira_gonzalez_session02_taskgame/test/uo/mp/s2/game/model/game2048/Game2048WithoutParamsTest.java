package uo.mp.s2.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

import uo.mp.s2.game.model.Game2048;

/**
 * <p>
 * T�tulo: Clase Game2048WithoutParamsTest 
 * <p>
 *  
 * @author Omar Teixeira Gonz�lez
 * @version 11/02/2021
 */

public class Game2048WithoutParamsTest {
	
	/**
	 * Pruebas del constructor sin par�metros de la clase Game2048:
	 * 1- Genera el tablero
	 */
	
	/**
	 * 1- Genera el tablero
	 */
	@Test
	public void testConstructorWithoutParams() {
		Game2048 game = new Game2048();
		int[][] expected= {{0,0,0},{0,0,0},{0,0,0}};
		assertArrayEquals(expected,game.getBoard());
	}
}
