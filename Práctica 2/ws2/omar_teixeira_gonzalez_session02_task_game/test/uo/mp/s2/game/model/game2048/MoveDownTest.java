package uo.mp.s2.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import uo.mp.s2.game.model.Game2048;

/**
 * <p>
 * T�tulo: Clase MoveDownTest 
 * <p>
 * 
 * @author Omar Teixeira Gonz�lez
 * @version 11/02/2021
 */

public class MoveDownTest {
	
	/**
	 * Pruebas del m�todo moveDown de la clase Game2048:
	 * 1- Mover hacia abajo matriz semillena 1
	 * 2- Mover hacia abajo matriz semillena 2
	 * 3- Mover hacia abajo matriz semillena 3
	 * 4- Mover hacia abajo matriz semillena 4
	 * 5- Mover hacia abajo matriz semillena compactada hacia arriba 1
	 * 6- Mover hacia abajo matriz semillena compactada hacia arriba 2
	 * 7- Mover hacia abajo matriz semillena ya compactada hacia abajo 1
	 * 8- Mover hacia abajo matriz semillena ya compactada hacia abajo 2
	 */
	
	/**
	 * 1- Mover hacia abajo matriz semillena 1
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveDown
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveDownSemifull1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL32); //{{0,0,0},{2,2,2},{0,0,0}};
		game.moveDown();
		int[][] expected = {{0,0,0},{0,0,0},{2,2,2}};
		assertArrayEquals (expected, game.getBoard());		
	}
	
	/**
	 * 2- Mover hacia abajo matriz semillena 2
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveDown
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveDownSemifull2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL33); //{{2,2,2},{0,0,0},{0,0,0}}
		game.moveDown();
		int[][] expected = {{0,0,0},{0,0,0},{2,2,2}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 3- Mover hacia abajo matriz semillena 3
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveDown
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveDownSemifull3() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL31); //{{0,0,0},{0,0,0},{2,2,2}}
		game.moveDown();
		int[][] expected = {{0,0,0},{0,0,0},{2,2,2}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 4- Mover hacia abajo matriz semillena 4
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveDown
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveDownSemifull4() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL41); //{{0,0,0},{2,2,2},{2,2,2}}
		game.moveDown();
		int[][] expected = {{0,0,0},{0,0,0},{4,4,4}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 5- Mover hacia abajo matriz semillena compactada hacia arriba 1
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveDown
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveDownSemifullUp1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL3_UPCOMPACTED); //{{2,2,2},{0,0,0},{0,0,0}}
		game.moveDown();
		int[][] expected = {{0,0,0},{0,0,0},{2,2,2}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 6- Mover hacia abajo matriz semillena compactada hacia arriba 2
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveDown
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveDownSemifullUp2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL4_UPCOMPACTED); //{{2,2,2},{2,2,2},{0,0,0}}
		game.moveDown();
		int[][] expected = {{0,0,0},{0,0,0},{4,4,4}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 7- Mover hacia abajo matriz semillena ya compactada hacia abajo 1
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveDown
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveDownSemifullDown1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL3_DOWNCOMPACTED); //{{0,0,0},{0,0,0},{2,2,2}}
		game.moveDown();
		int[][] expected = {{0,0,0},{0,0,0},{2,2,2}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 8- Mover hacia abajo matriz semillena ya compactada hacia abajo 2
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo moveDown
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testMoveDownSemifullDown2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL4_DOWNCOMPACTED); //{{0,0,0},{2,2,2},{2,2,2}}
		game.moveDown();
		int[][] expected = {{0,0,0},{0,0,0},{4,4,4}};
		assertArrayEquals (expected, game.getBoard());
	}	
}

