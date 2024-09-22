package uo.mp.s2.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import uo.mp.s2.game.model.Game2048;

/**
 * <p>
 * T�tulo: Clase MoveUpTest 
 * <p>
 * 
 * @author Omar Teixeira Gonz�lez
 * @version 11/02/2021
 */

public class MoveUpTest {
	
	/**
	 * Pruebas del m�todo moveUp de la clase Game2048:
	 * 1- Mover hacia arriba matriz semillena 1
	 * 2- Mover hacia arriba matriz semillena 2
	 * 3- Mover hacia arriba matriz semillena 3
	 * 4- Mover hacia arriba matriz semillena 4
	 * 5- Mover hacia arriba matriz semillena compactada hacia abajo 1
	 * 6- Mover hacia arriba matriz semillena compactada hacia abajo 2
	 * 7- Mover hacia arriba matriz semillena ya compactada hacia arriba 1
	 * 8- Mover hacia arriba matriz semillena ya compactada hacia arriba 2
	 */
	
	/**
	 * 1- Mover hacia arriba matriz semillena 1
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveUp
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveUpSemifull1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL32); //{{0,0,0},{2,2,2},{0,0,0}};
		game.moveUp();
		int[][] expected = {{2,2,2},{0,0,0},{0,0,0}};
		assertArrayEquals (expected, game.getBoard());		
	}
	
	/**
	 * 2- Mover hacia arriba matriz semillena 2
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveUp
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveUpSemifull2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL33); //{{2,2,2},{0,0,0},{0,0,0}}
		game.moveUp();
		int[][] expected = {{2,2,2},{0,0,0},{0,0,0}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 3- Mover hacia arriba matriz semillena 3
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveUp
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveUpSemifull3() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL31); //{{0,0,0},{0,0,0},{2,2,2}}
		game.moveUp();
		int[][] expected = {{2,2,2},{0,0,0},{0,0,0}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 4- Mover hacia arriba matriz semillena 4
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveUp
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveUpSemifull4() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL41); //{{0,0,0},{2,2,2},{2,2,2}}
		game.moveUp();
		int[][] expected = {{4,4,4},{0,0,0},{0,0,0}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 5- Mover hacia arriba matriz semillena compactada hacia abajo 1
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveUp
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveUpSemifullDown1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL3_DOWNCOMPACTED); //{{0,0,0},{0,0,0},{2,2,2}}
		game.moveUp();
		int[][] expected = {{2,2,2},{0,0,0},{0,0,0}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 6- Mover hacia arriba matriz semillena compactada hacia abajo 2
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveUp
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveUpSemifullDown2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL4_DOWNCOMPACTED); //{{0,0,0},{2,2,2},{2,2,2}}
		game.moveUp();
		int[][] expected = {{4,4,4},{0,0,0},{0,0,0}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 7- Mover hacia arriba matriz semillena ya compactada hacia arriba 1
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveUp
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveUpSemifullUp1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL3_UPCOMPACTED); //{{2,2,2},{0,0,0},{0,0,0}}
		game.moveUp();
		int[][] expected = {{2,2,2},{0,0,0},{0,0,0}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 8- Mover hacia arriba matriz semillena ya compactada hacia arriba 2
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveUp
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveUpSemifullUp2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL4_UPCOMPACTED); //{{2,2,2},{2,2,2},{0,0,0}}
		game.moveUp();
		int[][] expected = {{4,4,4},{0,0,0},{0,0,0}};
		assertArrayEquals (expected, game.getBoard());
	}
}
