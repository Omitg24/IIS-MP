package uo.mp.s1.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s1.game.model.Game2048;


public class Game2048WithIntParamTest {
	/*
	 *  Pruebas para el constructor con par�metros de la clase Game2048:
	 *  
	 *  Positivos:
	 *  1- La dimensi�n est� dentro de los limites -> Crea el tablero
	 *  2- La dimensi�n est� en el l�mite inferior -> Crea el tablero
	 *  3- La dimensi�n est� en el l�mite superior -> Crea el tablero
	 *  
	 *  Negativos:
	 *  4- La dimensi�n est� por debajo del limite inverior -> Lanza la excepci�n
	 *  5- La dimensi�n est� por encima del l�mite superior -> Lanza la excepci�n
	 */
	
	//Positivos:
	
	/**
	 *  1- La dimensi�n est� dentro de los limites -> Crea el tablero
	 */
	@Test
	public void testConstructorWithDimensionParamInLimits() {
		Game2048 game = new Game2048(5);
		int[][] expected = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		assertArrayEquals(expected,game.getBoard());
	}
	
	/**
	 *  2- La dimensi�n est� en el l�mite inferior -> Crea el tablero
	 */
	@Test
	public void testConstructorWithDimensionParamInLowerLimit() {
		Game2048 game = new Game2048(3);
		int[][] expected = {{0,0,0},{0,0,0},{0,0,0}};
		assertArrayEquals(expected,game.getBoard());
	}
	
	/**
	 * 3- La dimensi�n est� en el l�mite superior -> Crea el tablero
	 */
	@Test
	public void testConstructorWithDimensionParamInUpperLimit() {
		Game2048 game = new Game2048(10);
		int[][] expected = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}};
		assertArrayEquals(expected,game.getBoard());	
	}
	
	//Negativos:
	
	/*
	 * 4- La dimensi�n est� por debajo del limite inverior -> Lanza la excepci�n
	 */
	@Test
	public void testConstructorWithDimensionParamUnderLowerLimit() {
		try{
            new Game2048(2);
            fail("Esperaba excepci�n");
        }catch (RuntimeException msg){
            assertEquals("La dimension no cumple los requisitos", msg.getMessage());
        }
	}
	
	/*
	 * 5- La dimensi�n est� por encima del l�mite superior -> Lanza la excepci�n
	 */
	@Test
	public void testConstructorWithDimensionParamOverUpperLimit() {
		try{
            new Game2048(12);
            fail("Esperaba excepci�n");
        }catch (RuntimeException msg){
            assertEquals("La dimension no cumple los requisitos", msg.getMessage());
        }
	}
}
