package uo.mp.s2.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s2.game.model.Game2048;

/**
 * <p>
 * Título: Clase IsBoardFullTest
 * <p>
 *  
 * @author Omar Teixeira González
 * @version 11/02/2021
 */

public class IsBoardFullTest {
	
	/**
	 * Pruebas del método isBoardFull de la clase Game2048:
	 * 1- Matriz completamente llena -> Devuelve true
	 * 2- Matriz parcialmente llena -> Devuelve false
	 * 3- Matriz vacía -> Devuelve false
	 */
			
	/**
	 * 1- Matriz completamente llena -> Devuelve true
	 * GIVEN Game recibe una matriz llena.
	 * WHEN Se llama al método isBoardFull
	 * THEN Compara que el resultado obtenido del método sea true
	 */
	@Test
	public void testIsBoardFull() {
		Game2048 game = new Game2048(CodeForTest.FULL); //{{2,2,2},{2,2,2},{2,2,2}}
		assertTrue (game.isBoardFull());
	}
		
	/**
	 * 2- Matriz parcialmente llena -> Devuelve false
	 * GIVEN Game recibe una matriz semillena.
	 * WHEN Se llama al método isBoardFull
	 * THEN Compara que el resultado obtenido del método sea false
	 */
	@Test
	public void testNotIsBoardFull() {
		Game2048 game = new Game2048(CodeForTest.SEMIFULL22); //{{2,2,0},{2,2,0},{2,2,0}}
		assertFalse (game.isBoardFull());
	}
	
	/**
	 * 3- Matriz vacía -> Devuelve false
	 * GIVEN Game recibe una matriz vacía.
	 * WHEN Se llama al método isBoardFull
	 * THEN Compara que el resultado obtenido del método sea false
	 */
	@Test
	public void testEmptyIsBoardFull() {
		Game2048 game = new Game2048 (CodeForTest.EMPTY); //{{0,0,0},{0,0,0},{0,0,0}};
		assertFalse (game.isBoardFull());
	}
}
