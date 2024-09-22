package uo.mp.s2.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import uo.mp.s2.game.model.Game2048;

/**
 * <p>
 * T�tulo: Clase CompactLeftTest
 * <p>
 *  
 * @author Omar Teixeira Gonz�lez
 * @version 11/02/2021
 */

public class CompactLeftTest {
	
	/**
	 * Pruebas del m�todo compactLeft de la clase Game2048:
	 * 1- Compactar a la izquierda matriz semillena 1
	 * 2- Compactar a la izquierda matriz semillena 2
	 * 3- Compactar a la izquierda matriz semillena 3
	 * 4- Compactar a la izquierda matriz semillena 4
	 * 5- Compactar a la izquierda matriz semillena compactada a la derecha 1
	 * 6- Compactar a la izquierda matriz semillena compactada a la derecha 2
	 * 7- Compactar a la izquierda matriz semillena ya compactada a la izquierda 1
	 * 8- Compactar a la izquierda matriz semillena ya compactada a la izquierda 2
	 */
	
	/**
	 * 1- Compactar a la izquierda matriz semillena 1
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo compactLeft
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactLeftSemifull1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL11); //{{0,2,0},{0,2,0},{0,2,0}}
		game.compactLeft();
		int[][] expected = {{2,0,0},{2,0,0},{2,0,0}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 2- Compactar a la izquierda matriz semillena 2
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo compactLeft
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactLeftSemifull2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL12); //{{2,0,0},{2,0,0},{2,0,0}}
		game.compactLeft();
		int[][] expected = CodeForTest.SEMIFULL12;
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 3- Compactar a la izquierda matriz semillena 3
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo compactLeft
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactLefttSemifull3() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL13); //{{0,0,2},{0,0,2},{0,0,2}}
		game.compactLeft();
		int[][] expected = {{2,0,0},{2,0,0},{2,0,0}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 4- Compactar a la izquierda matriz semillena 4
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo compactLeft
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactLeftSemifull4() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL21); //{{0,2,2},{0,2,2},{0,2,2}};
		game.compactLeft();
		int[][] expected = {{2,2,0},{2,2,0},{2,2,0}};;
		assertArrayEquals (expected, game.getBoard());
	}	
	
	/**
	 * 5- Compactar a la izquierda matriz semillena compactada a la derecha 1
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo compactLeft
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactLeftSemifullRight1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL1_RIGHTCOMPACTED); //{{0,0,2},{0,0,2},{0,0,2}}
		game.compactLeft();
		int[][] expected = {{2,0,0},{2,0,0},{2,0,0}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 6- Compactar a la izquierda matriz semillena compactada a la derecha 2
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo compactLeft
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactLeftSemifullRight2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL2_RIGHTCOMPACTED); //{{0,2,2},{0,2,2},{0,2,2}}
		game.compactLeft();
		int[][] expected = {{2,2,0},{2,2,0},{2,2,0}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 7- Compactar a la izquierda matriz semillena ya compactada a la izquierda 1
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo compactLeft
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactLeftSemifullLeft1() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL1_LEFTCOMPACTED); //{{2,0,0},{2,0,0},{2,0,0}}
		game.compactLeft();
		int[][] expected = {{2,0,0},{2,0,0},{2,0,0}};
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 8- Compactar a la izquierda matriz semillena ya compactada a la izquierda 2
	 * GIVEN Game recibe una matriz semillena y se crea la matriz esperada
	 * WHEN Se llama al m�todo compactLeft
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testCompactLeftSemifullLeft2() {
		Game2048 game = new Game2048 (CodeForTest.SEMIFULL2_LEFTCOMPACTED); //{{2,2,0},{2,2,0},{2,2,0}}
		game.compactLeft();
		int[][] expected = {{2,2,0},{2,2,0},{2,2,0}};
		assertArrayEquals (expected, game.getBoard());
	}
}
