package uo.mp.s2.game.model.game2048;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.s2.game.model.Game2048;

/**
 * <p>
 * T�tulo: Clase NextTest
 * <p>
 *  
 * @author Omar Teixeira Gonz�lez
 * @version 11/02/2021
 */

public class NextTest {
	
	/**
	 * Pruebas del m�todo next de la clase Game2048:
	 * 1- Primera ejecuci�n de next
	 * 2- Segunda ejecuci�n de next
	 * 3- Tercera ejecuci�n de next
	 * 4- Cuarta ejecuci�n de next
	 * 5- Quinta ejecuci�n de next
	 * 6- Sexta ejecuci�n de next
	 * 7- S�ptima ejecuci�n de next
	 * 8- Octava ejecuci�n de next
	 * 9- Novena ejecuci�n de next
	 */
	
	/**
	 * 1- Primera ejecuci�n de next
	 * GIVEN Game llama al constructor sin par�metros, que crea una matriz 3x3 de 0s
	 * WHEN Se llama al m�todo next dentro de un bucle while, 
	 * que ejecuta el m�todo un numero determinado de veces
	 * THEN Compara que un valor dado es igual a la suma de los elementos de la matriz 
	 * obtenida (con el next) en el m�todo getSum de la clase CodeForTest 
	 */
	@Test
	public void testNextFirst() {
		Game2048 game = new Game2048();
		int i=0;
		while (i<1) {
			game.next();
			i+=1;			
		}		
		assertEquals(2,CodeForTest.getSum(game.getBoard()));		
	}

	/**
	 * 2- Segunda ejecuci�n de next
	 * GIVEN Game llama al constructor sin par�metros, que crea una matriz 3x3 de 0s
	 * WHEN Se llama al m�todo next dentro de un bucle while, 
	 * que ejecuta el m�todo un numero determinado de veces
	 * THEN Compara que un valor dado es igual a la suma de los elementos de la matriz 
	 * obtenida (con el next) en el m�todo getSum de la clase CodeForTest 
	 */
	@Test
	public void testNextSecond() {
		Game2048 game = new Game2048();
		int i=0;
		while (i<2) {
			game.next();
			i+=1;			
		}		
		assertEquals(4,CodeForTest.getSum(game.getBoard()));
	}
	
	/**
	 * 3- Tercera ejecuci�n de next
	 * GIVEN Game llama al constructor sin par�metros, que crea una matriz 3x3 de 0s
	 * WHEN Se llama al m�todo next dentro de un bucle while, 
	 * que ejecuta el m�todo un numero determinado de veces
	 * THEN Compara que un valor dado es igual a la suma de los elementos de la matriz 
	 * obtenida (con el next) en el m�todo getSum de la clase CodeForTest 
	 */
	@Test
	public void testNextThird() {
		Game2048 game = new Game2048();
		int i=0;
		while (i<3) {
			game.next();
			i+=1;			
		}		
		assertEquals(6,CodeForTest.getSum(game.getBoard()));
	}
	
	/**
	 * 4- Cuarta ejecuci�n de next
	 * GIVEN Game llama al constructor sin par�metros, que crea una matriz 3x3 de 0s
	 * WHEN Se llama al m�todo next dentro de un bucle while, 
	 * que ejecuta el m�todo un numero determinado de veces
	 * THEN Compara que un valor dado es igual a la suma de los elementos de la matriz 
	 * obtenida (con el next) en el m�todo getSum de la clase CodeForTest 
	 */
	@Test
	public void testNextFourth() {
		Game2048 game = new Game2048();
		int i=0;
		while (i<4) {
			game.next();
			i+=1;			
		}		
		assertEquals(8,CodeForTest.getSum(game.getBoard()));
	}
	
	/**
	 * 5- Quinta ejecuci�n de next
	 * GIVEN Game llama al constructor sin par�metros, que crea una matriz 3x3 de 0s
	 * WHEN Se llama al m�todo next dentro de un bucle while, 
	 * que ejecuta el m�todo un numero determinado de veces
	 * THEN Compara que un valor dado es igual a la suma de los elementos de la matriz 
	 * obtenida (con el next) en el m�todo getSum de la clase CodeForTest 
	 */
	@Test
	public void testNextFifth() {
		Game2048 game = new Game2048();
		int i=0;
		while (i<5) {
			game.next();
			i+=1;			
		}		
		assertEquals(10,CodeForTest.getSum(game.getBoard()));
	}
	
	/**
	 * 6- Sexta ejecuci�n de next
	 * GIVEN Game llama al constructor sin par�metros, que crea una matriz 3x3 de 0s
	 * WHEN Se llama al m�todo next dentro de un bucle while, 
	 * que ejecuta el m�todo un numero determinado de veces
	 * THEN Compara que un valor dado es igual a la suma de los elementos de la matriz 
	 * obtenida (con el next) en el m�todo getSum de la clase CodeForTest 
	 */
	@Test
	public void testNextSixth() {
		Game2048 game = new Game2048();
		int i=0;
		while (i<6) {
			game.next();
			i+=1;			
		}		
		assertEquals(12,CodeForTest.getSum(game.getBoard()));
	}
	
	/**
	 * 7- S�ptima ejecuci�n de next
	 * GIVEN Game llama al constructor sin par�metros, que crea una matriz 3x3 de 0s
	 * WHEN Se llama al m�todo next dentro de un bucle while, 
	 * que ejecuta el m�todo un numero determinado de veces
	 * THEN Compara que un valor dado es igual a la suma de los elementos de la matriz 
	 * obtenida (con el next) en el m�todo getSum de la clase CodeForTest 
	 */
	@Test
	public void testNextSeventh() {
		Game2048 game = new Game2048();
		int i=0;
		while (i<7) {
			game.next();
			i+=1;			
		}		
		assertEquals(14,CodeForTest.getSum(game.getBoard()));
	}
	
	/**
	 * 8- Octava ejecuci�n de next
	 * GIVEN Game llama al constructor sin par�metros, que crea una matriz 3x3 de 0s
	 * WHEN Se llama al m�todo next dentro de un bucle while, 
	 * que ejecuta el m�todo un numero determinado de veces
	 * THEN Compara que un valor dado es igual a la suma de los elementos de la matriz 
	 * obtenida (con el next) en el m�todo getSum de la clase CodeForTest 
	 */
	@Test
	public void testNextEighth() {
		Game2048 game = new Game2048();
		int i=0;
		while (i<8) {
			game.next();
			i+=1;			
		}		
		assertEquals(16,CodeForTest.getSum(game.getBoard()));
	}
	
	/**
	 * 9- Novena ejecuci�n de next
	 * GIVEN Game llama al constructor sin par�metros, que crea una matriz 3x3 de 0s
	 * WHEN Se llama al m�todo next dentro de un bucle while, 
	 * que ejecuta el m�todo un numero determinado de veces
	 * THEN Compara que un valor dado es igual a la suma de los elementos de la matriz 
	 * obtenida (con el next) en el m�todo getSum de la clase CodeForTest 
	 */
	@Test
	public void testNextNinth() {
		Game2048 game = new Game2048();
		int i=0;
		while (i<9) {
			game.next();
			i+=1;			
		}		
		assertEquals(18,CodeForTest.getSum(game.getBoard()));
	}
}
