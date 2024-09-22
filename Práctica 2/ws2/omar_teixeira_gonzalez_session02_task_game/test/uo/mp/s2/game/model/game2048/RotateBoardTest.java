package uo.mp.s2.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import uo.mp.s2.game.model.Game2048;

/**
 * <p>
 * T�tulo: Clase RotateBoardTest 
 * <p>
 *  
 * @author Omar Teixeira Gonz�lez
 * @version 11/02/2021
 */

public class RotateBoardTest {
	
	/**
	 * Pruebas del m�todo rotateBoard de la clase Game2048:
	 * 1- Primera ejecuci�n de rotateBoard
	 * 2- Segunda ejecuci�n de rotateBoard
	 * 3- Tercera ejecuci�n de rotateBoard
	 * 4- Cuarta ejecuci�n de rotateBoard
	 */
	
	/**
	 * 1- Primera ejecuci�n de rotateBoard
	 * GIVEN Game recibe una matriz y se crea la matriz esperada tras ejecutar el m�todo rotateBoard
	 * WHEN Se llama al m�todo rotateBoard (introducido en un bucle segun el numero de veces a repetirlo)
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testRotateBoardFirst() {
		Game2048 game = new Game2048 (new int[][] {{1,2,3},{4,5,6},{7,8,9}});
		int[][] expected = new int[][] {{3,6,9},{2,5,8},{1,4,7}};
		int i=0;
		while (i<1) {
			game.rotateBoard();		
			i++;
		}
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 2- Segunda ejecuci�n de rotateBoard
	 * GIVEN Game recibe una matriz y se crea la matriz esperada tras ejecutar el m�todo rotateBoard
	 * WHEN Se llama al m�todo rotateBoard (introducido en un bucle segun el numero de veces a repetirlo)
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testRotateBoardSecond() {
		Game2048 game = new Game2048 (new int[][] {{1,2,3},{4,5,6},{7,8,9}});
		int[][] expected = new int[][] {{9,8,7},{6,5,4},{3,2,1}};
		int i=0;
		while (i<2) {
			game.rotateBoard();
			i++;
		}
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 3- Tercera ejecuci�n de rotateBoard
	 * GIVEN Game recibe una matriz y se crea la matriz esperada tras ejecutar el m�todo rotateBoard
	 * WHEN Se llama al m�todo rotateBoard (introducido en un bucle segun el numero de veces a repetirlo)
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testRotateBoardThird() {
		Game2048 game = new Game2048 (new int[][] {{1,2,3},{4,5,6},{7,8,9}});
		int[][] expected = new int[][] {{7,4,1},{8,5,2},{9,6,3}};
		int i=0;
		while (i<3) {
			game.rotateBoard();			
			i++;
		}
		assertArrayEquals (expected, game.getBoard());
	}
	
	/**
	 * 4- Cuarta ejecuci�n de rotateBoard
	 * GIVEN Game recibe una matriz y se crea la matriz esperada tras ejecutar el m�todo rotateBoard
	 * WHEN Se llama al m�todo rotateBoard (introducido en un bucle segun el numero de veces a repetirlo)
	 * THEN Compara que sea igual la matriz de game con la esperada
	 */
	@Test
	public void testRotateBoardFourth() {
		Game2048 game = new Game2048 (new int[][] {{1,2,3},{4,5,6},{7,8,9}});
		int[][] expected = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		int i=0;
		while (i<4) {
			game.rotateBoard();		
			i++;
		}
		assertArrayEquals (expected, game.getBoard());
	}
}
