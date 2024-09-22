package uo.mp.s1.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import uo.mp.s1.game.model.Game2048;

public class CompactDownTest {
	
	/*
	 * Pruebas del método compactDown de la clase Game2048:
	 * 1- Compactar hacia arriba matriz semillena 1
	 * 2- Compactar hacia arriba matriz semillena 2
	 * 3- Compactar hacia arriba matriz semillena 3
	 * 4- Compactar hacia arriba matriz semillena 4
	 * 5- Compactar hacia arriba matriz semillena compactada hacia arriba 1
	 * 6- Compactar hacia arriba matriz semillena compactada hacia arriba 2
	 * 7- Compactar hacia arriba matriz semillena ya compactada hacia abajo 1
	 * 8- Compactar hacia arriba matriz semillena ya compactada hacia abajo 2
	 */
	
	/**
	 * 1- Compactar hacia arriba matriz semillena 1
	 */
	@Test
	public void testCompactUpSemifull1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL11); //{{0,2,0},{0,2,0},{0,2,0}}
		game.compactDown();
		int[][] expected = game.getBoard();
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 2- Compactar hacia arriba matriz semillena 2
	 */
	@Test
	public void testCompactUpSemifull2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL21); //{{0,2,2},{0,2,2},{0,2,2}}
		game.compactDown();
		int[][] expected = game.getBoard();
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 3- Compactar hacia arriba matriz semillena 3
	 */
	@Test
	public void testCompactUpSemifull3() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL31); //{{0,0,0},{0,0,0},{2,2,2}}
		game.compactDown();
		int[][] expected = game.getBoard();
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 4- Compactar hacia arriba matriz semillena 4
	 */
	@Test
	public void testCompactUpSemifull4() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL41); //{{0,0,0},{2,2,2},{2,2,2}}
		game.compactDown();
		int[][] expected = game.getBoard();
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 5- Compactar hacia arriba matriz semillena compactada hacia arriba 1
	 */
	@Test
	public void testCompactUpSemifullUp1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL3_UPCOMPACTED); //{{2,2,2},{0,0,0},{0,0,0}}
		game.compactDown();
		int[][] expected = game.getBoard();
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 6- Compactar hacia arriba matriz semillena compactada hacia arriba 2
	 */
	@Test
	public void testCompactUpSemifullUp2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL4_UPCOMPACTED); //{{2,2,2},{2,2,2},{0,0,0}}
		game.compactDown();
		int[][] expected = game.getBoard();
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 7- Compactar hacia arriba matriz semillena ya compactada hacia abajo 1
	 */
	@Test
	public void testCompactUpSemifullDown1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL3_DOWNCOMPACTED); //{{0,0,0},{0,0,0},{2,2,2}}
		game.compactDown();
		int[][] expected = game.getBoard();
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 8- Compactar hacia arriba matriz semillena ya compactada hacia abajo 2
	 */
	@Test
	public void testCompactUpSemifullDown2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL4_DOWNCOMPACTED); //{{0,0,0},{2,2,2},{2,2,2}}
		game.compactDown();
		int[][] expected = game.getBoard();
		assertArrayEquals (expected, game.getBoard());
	}
}
