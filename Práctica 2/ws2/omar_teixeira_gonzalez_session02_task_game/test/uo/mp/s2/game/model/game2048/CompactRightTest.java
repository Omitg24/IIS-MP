package uo.mp.s2.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import uo.mp.s2.game.model.Game2048;

/**
 * <p>
 * T�tulo: Clase CompactRightTest 
 * <p>
 *  
 * @author Omar Teixeira Gonz�lez
 * @version 11/02/2021
 */

public class CompactRightTest {
	
	/**
	 * Pruebas del m�todo compactRight de la clase Game2048:
	 * 1- Compactar a la derecha matriz semillena 1
	 * 2- Compactar a la derecha matriz semillena 2
	 * 3- Compactar a la derecha matriz semillena 3
	 * 4- Compactar a la derecha matriz semillena 4
	 * 5- Compactar a la derecha matriz semillena compactada a la izquierda 1
	 * 6- Compactar a la derecha matriz semillena compactada a la izquierda 2
	 * 7- Compactar a la derecha matriz semillena ya compactada a la derecha 1
	 * 8- Compactar a la derecha matriz semillena ya compactada a la derecha 2
	 */
	
	/**
	 * 1- Compactar a la derecha matriz semillena 1
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo compactRight
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactRightSemifull1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL11); //{{0,2,0},{0,2,0},{0,2,0}}
		game.compactRight();
		int[][] expected = {{0,0,2},{0,0,2},{0,0,2}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 2- Compactar a la derecha matriz semillena 2
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo compactRight
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactRightSemifull2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL12); //{{2,0,0},{2,0,0},{2,0,0}}
		game.compactRight();
		int[][] expected = {{0,0,2},{0,0,2},{0,0,2}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 3- Compactar a la derecha matriz semillena 3
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo compactRight
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactRightSemifull3() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL13); //{{0,0,2},{0,0,2},{0,0,2}}
		game.compactRight();
		int[][] expected = {{0,0,2},{0,0,2},{0,0,2}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 4- Compactar a la derecha matriz semillena 4
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo compactRight
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactRightSemifull4() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL21); //{{0,2,2},{0,2,2},{0,2,2}}
		game.compactRight();
		int[][] expected = {{0,2,2},{0,2,2},{0,2,2}};
		assertArrayEquals (expected, game.getBoard());
	}	
	
	/**
	 * 5- Compactar a la derecha matriz semillena compactada a la izquierda 1
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo compactRight
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactRightSemifullLeft1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL1_LEFTCOMPACTED); //{{2,0,0},{2,0,0},{2,0,0}}
		game.compactRight();
		int[][] expected = {{0,0,2},{0,0,2},{0,0,2}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 6- Compactar a la derecha matriz semillena compactada a la izquierda 2
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo compactRight
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactRightSemifullLeft2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL2_LEFTCOMPACTED); //{{2,2,0},{2,2,0},{2,2,0}}
		game.compactRight();
		int[][] expected = {{0,2,2},{0,2,2},{0,2,2}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 7- Compactar a la derecha matriz semillena ya compactada a la derecha 1
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo compactRight
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactRightSemifullRight1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL1_RIGHTCOMPACTED); //{{0,0,2},{0,0,2},{0,0,2}}
		game.compactRight();
		int[][] expected = {{0,0,2},{0,0,2},{0,0,2}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 8- Compactar a la derecha matriz semillena ya compactada a la derecha 2
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo compactRight
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactRightSemifullRight2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL2_RIGHTCOMPACTED); //{{0,2,2},{0,2,2},{0,2,2}}
		game.compactRight();
		int[][] expected = {{0,2,2},{0,2,2},{0,2,2}};
		assertArrayEquals (expected, game.getBoard());
	}
}
