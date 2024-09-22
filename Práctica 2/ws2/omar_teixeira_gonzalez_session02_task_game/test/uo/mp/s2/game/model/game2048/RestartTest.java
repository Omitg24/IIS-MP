package uo.mp.s2.game.model.game2048;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.s2.game.model.Game2048;

/**
 * <p>
 * Título: Clase RestartTest 
 * <p>
 *  
 * @author Omar Teixeira González
 * @version 11/02/2021
 */

public class RestartTest {
	
	/**
	 * Pruebas del método restart de la clase Game2048
	 * 1- Resetea una matriz semillena
	 * 2- Resetea una matriz llena
	 * 3- Resetea una matriz vacía
	 */
	
	/**
	 * 1- Resetea una matriz semillena
	 * GIVEN Game recibe una matriz semillena
	 * WHEN Se llama al método restart
	 * THEN Compara que un valor dado es igual a la suma de los elementos de la matriz 
	 * obtenida (con el restart) en el método getSum de la clase CodeForTest 
	 */
	@Test
	public void testRestartSemifull() {
		Game2048 game = new Game2048(CodeForTest.SEMIFULL12);		
		game.restart();
		assertEquals(2,CodeForTest.getSum(game.getBoard()));
	}
	
	/**
	 * 2- Resetea una matriz llena
	 * GIVEN Game recibe una matriz llena
	 * WHEN Se llama al método restart
	 * THEN Compara que un valor dado es igual a la suma de los elementos de la matriz 
	 * obtenida (con el restart) en el método getSum de la clase CodeForTest 
	 */
	@Test
	public void testRestartFull() {
		Game2048 game = new Game2048(CodeForTest.FULL);		
		game.restart();
		assertEquals(2,CodeForTest.getSum(game.getBoard()));
	}
	
	/**
	 * 3- Resetea una matriz vacía
	 * GIVEN Game recibe una matriz vacia
	 * WHEN Se llama al método restart
	 * THEN Compara que un valor dado es igual a la suma de los elementos de la matriz 
	 * obtenida (con el restart) en el método getSum de la clase CodeForTest 
	 */
	@Test
	public void testRestartEmpty() {
		Game2048 game = new Game2048(CodeForTest.EMPTY);		
		game.restart();
		assertEquals(2,CodeForTest.getSum(game.getBoard()));
	}
	
}
