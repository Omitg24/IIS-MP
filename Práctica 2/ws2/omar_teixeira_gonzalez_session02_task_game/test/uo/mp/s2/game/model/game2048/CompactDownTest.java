package uo.mp.s2.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import uo.mp.s2.game.model.Game2048;

/**
 * <p>
 * Título: Clase CompactDownTest 
 * <p>
 *  
 * @author Omar Teixeira González
 * @version 11/02/2021
 */

public class CompactDownTest {
	
	/**
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
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al método compactDown
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactDownSemifull1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL11); //{{0,2,0},{0,2,0},{0,2,0}}
		game.compactDown();
		int[][] expected = {{0,2,0},{0,2,0},{0,2,0}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 2- Compactar hacia arriba matriz semillena 2
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al método compactDown
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactDownSemifull2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL21); //{{0,2,2},{0,2,2},{0,2,2}}
		game.compactDown();
		int[][] expected = {{0,2,2},{0,2,2},{0,2,2}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 3- Compactar hacia arriba matriz semillena 3
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al método compactDown
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactDownSemifull3() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL31); //{{0,0,0},{0,0,0},{2,2,2}}
		game.compactDown();
		int[][] expected = {{0,0,0},{0,0,0},{2,2,2}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 4- Compactar hacia arriba matriz semillena 4
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al método compactDown
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactDownSemifull4() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL41); //{{0,0,0},{2,2,2},{2,2,2}}
		game.compactDown();
		int[][] expected = {{0,0,0},{2,2,2},{2,2,2}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 5- Compactar hacia arriba matriz semillena compactada hacia arriba 1
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al método compactDown
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactDownSemifullUp1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL3_UPCOMPACTED); //{{2,2,2},{0,0,0},{0,0,0}}
		game.compactDown();
		int[][] expected = {{0,0,0},{0,0,0},{2,2,2}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 6- Compactar hacia arriba matriz semillena compactada hacia arriba 2
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al método compactDown
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactDownSemifullUp2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL4_UPCOMPACTED); //{{2,2,2},{2,2,2},{0,0,0}}
		game.compactDown();
		int[][] expected = {{0,0,0},{2,2,2},{2,2,2}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 7- Compactar hacia arriba matriz semillena ya compactada hacia abajo 1
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al método compactDown
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactDownSemifullDown1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL3_DOWNCOMPACTED); //{{0,0,0},{0,0,0},{2,2,2}}
		game.compactDown();
		int[][] expected = {{0,0,0},{0,0,0},{2,2,2}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 8- Compactar hacia arriba matriz semillena ya compactada hacia abajo 2
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al método compactDown
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactDownSemifullDown2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL4_DOWNCOMPACTED); //{{0,0,0},{2,2,2},{2,2,2}}
		game.compactDown();
		int[][] expected = {{0,0,0},{2,2,2},{2,2,2}};
		assertArrayEquals (expected, game.getBoard());
	}
}
