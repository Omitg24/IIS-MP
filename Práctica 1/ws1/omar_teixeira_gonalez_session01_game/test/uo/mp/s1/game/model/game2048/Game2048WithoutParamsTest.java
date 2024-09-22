package uo.mp.s1.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

import uo.mp.s1.game.model.Game2048;


public class Game2048WithoutParamsTest {
	
	/*
	 * Pruebas del constructor sin parámetros:
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
