package uo.mp.s2.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import uo.mp.s2.game.model.Game2048;

/**
 * <p>
 * T�tulo: Clase MoveLeftTest 
 * <p>
 * 
 * @author Omar Teixeira Gonz�lez
 * @version 11/02/2021
 */

public class MoveLeftTest {

	/**
	 * Pruebas del m�todo moveLeft de la clase Game2048:
	 * 1- Mover a la izquierda matriz semillena 1
	 * 2- Mover a la izquierda matriz semillena 2
	 * 3- Mover a la izquierda matriz semillena 3
	 * 4- Mover a la izquierda matriz semillena 4
	 * 5- Mover a la izquierda matriz semillena compactada a la derecha 1
	 * 6- Mover a la izquierda matriz semillena compactada a la derecha 2
	 * 7- Mover a la izquierda matriz semillena compactada a la izquierda 1
	 * 8- Mover a la izquierda matriz semillena compactada a la izquierda 2
	 */
	
	/**
	 * 1- Mover a la izquierda matriz semillena 1
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveLeft
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveLeftSemifull1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL11); //{{0,2,0},{0,2,0},{0,2,0}}
		game.moveLeft();
		int[][] expected = {{2,0,0},{2,0,0},{2,0,0}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 2- Mover a la izquierda matriz semillena 2
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveLeft
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveLeftSemifull2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL23); //{{2,0,2},{2,0,2},{2,0,2}}
		game.moveLeft();
		int[][] expected = {{4,0,0},{4,0,0},{4,0,0}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 3- Mover a la izquierda matriz semillena 3
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveLeft
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveLeftSemifull3() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL13); //{{0,0,2},{0,0,2},{0,0,2}}
		game.moveLeft();
		int[][] expected = {{2,0,0},{2,0,0},{2,0,0}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 4- Mover a la izquierda matriz semillena 4
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveLeft
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveLeftSemifull4() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL21); //{{0,2,2},{0,2,2},{0,2,2}}
		game.moveLeft();
		int[][] expected = {{4,0,0},{4,0,0},{4,0,0}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 5- Mover a la izquierda matriz semillena compactada a la derecha 1
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveLeft
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveLeftSemifullRight1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL1_RIGHTCOMPACTED); //{{0,0,2},{0,0,2},{0,0,2}}
		game.moveLeft();
		int[][] expected = {{2,0,0},{2,0,0},{2,0,0}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 6- Mover a la izquierda matriz semillena compactada a la derecha 2
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveLeft
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveLeftSemifullRight2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL2_RIGHTCOMPACTED); //{{0,2,2},{0,2,2},{0,2,2}}
		game.moveLeft();
		int[][] expected = {{4,0,0},{4,0,0},{4,0,0}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 7- Mover a la izquierda matriz semillena compactada a la izquierda 1
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveLeft
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveLeftSemifullLeft1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL1_LEFTCOMPACTED); //{{2,0,0},{2,0,0},{2,0,0}}
		game.moveLeft();
		int[][] expected = {{2,0,0},{2,0,0},{2,0,0}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 8- Mover a la izquierda matriz semillena compactada a la izquierda 2
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveLeft
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveLeftSemifullLeft2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL2_LEFTCOMPACTED); //{{2,2,0},{2,2,0},{2,2,0}}
		game.moveLeft();
		int[][] expected = {{4,0,0},{4,0,0},{4,0,0}};
		assertArrayEquals (expected, game.getBoard());
	}	
}
