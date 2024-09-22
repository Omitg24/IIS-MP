package uo.mp.s1.game.model.game2048;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.s1.game.model.Game2048;

public class RestartTest {
	
	/*
	 * Pruebas del m�todo restart:
	 * 1- Resetea una matriz semillena
	 * 2- Resetea una matriz llena
	 * 3- Resetea una matriz vac�a
	 */
	
	/**
	 * 1- Resetea una matriz semillena
	 */
	@Test
	public void testRestartSemifull() {
		Game2048 game = new Game2048(CodeForTest.SEMIFULL12);		
		game.restart();
		assertEquals(2,CodeForTest.getSum(game.getBoard()));
	}
	
	/**
	 * 2- Resetea una matriz llena
	 */
	@Test
	public void testRestartFull() {
		Game2048 game = new Game2048(CodeForTest.FULL);		
		game.restart();
		assertEquals(2,CodeForTest.getSum(game.getBoard()));
	}
	
	/**
	 * 3- Resetea una matriz vac�a
	 */
	@Test
	public void testRestartEmpty() {
		Game2048 game = new Game2048(CodeForTest.EMPTY);		
		game.restart();
		assertEquals(2,CodeForTest.getSum(game.getBoard()));
	}
	
}
