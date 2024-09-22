package uo.mp.battleship.model.board;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;

/**
 * Titulo: Clase ShootAtTest
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public class ShootAtTest {
	
	/**
	 * Constante tama�o por defecto
	 */
	public static final int DEFAULT_SIZE = 10;
	
	/**
	 * Atributo tablero
	 */
	private Board board;
	
	/**
	 * Atributos coordenadas
	 */
	private Coordinate coords1, coords2, coords3;
	
	/**
	 * Creaci�n de objetos para su uso posterior
	 */
	@Before
	public void setUp() {
		board = new Board(DEFAULT_SIZE);
		coords1 = new Coordinate(0,8);
		coords2 = new Coordinate(0,0);
		coords3 = new Coordinate(4,6);
	}
	
	/**
	 * Pruebas del m�todo shootAt de la clase Board:
	 * 1- Despu�s de disparar a una casilla que a�n no ha sido disparada y que 
	 *    no contienen barco, el m�todo devolver� falso y la casilla en cuesti�n 
	 *    se marcar� como disparada. (-10).
	 * 2- Despu�s de disparar una casilla ya disparada que originalmente no 
	 *    conten�a un barco, el m�todo debe devolver false y la casilla permanecer� 
	 *    como disparada (-10).
	 * 3- Despu�s de disparar una casilla a�n no disparada que contiene un barco, 
	 *    el m�todo devolver� true y la casilla cambiar� a disparada (su valor 
	 *    en negativo).
	 � 4- Despu�s de disparar una casilla disparada que originalmente conten�a 
	 *    un barco, el contenido permanecer� igual y el m�todo devolver� true.
	 */
	
	/**
	 * 1- Despu�s de disparar a una casilla que a�n no ha sido disparada y que 
	 *    no contienen barco, el m�todo devolver� falso y la casilla en cuesti�n 
	 *    se marcar� como disparada. (-10).
	 * GIVEN Se crea un tablero y varias coordenadas
	 * WHEN Se dispara a una coordenada en la que no hay un barco
	 * THEN Se comprueba que el valor es el adecuado (-10) y devuelve false
	 */
	@Test
	public void testEmptySpace() {		
		board.shootAt(coords1);
		assertEquals(-10, board.getBoard()[coords1.getRow()][coords1.getCol()]);		
	}
	
	/**
	 * 2- Despu�s de disparar una casilla ya disparada que originalmente no 
	 *    conten�a un barco, el m�todo debe devolver false y la casilla permanecer� 
	 *    como disparada (-10).
	 * GIVEN Se crea un tablero y varias coordenadas
	 * WHEN Se dispara a una coordenada 2 veces en la que no hay un barco
	 * THEN Se comprueba que el valor es el adecuado (-10) y devuelve false 2 veces
	 */
	@Test
	public void testEmptySpace2Times() {		
		board.shootAt(coords1);
		board.shootAt(coords1);
		assertEquals(-10, board.getBoard()[coords1.getRow()][coords1.getCol()]);		
	}
	
	/**
	 * 3- Despu�s de disparar una casilla a�n no disparada que contiene un barco, 
	 *    el m�todo devolver� true y la casilla cambiar� a disparada (su valor 
	 *    en negativo).
	 * GIVEN Se crea un tablero y varias coordenadas
	 * WHEN Se dispara a una coordenada en la que hay un barco
	 * THEN Se comprueba que el valor es el adecuado (-1) y devuelve true
	 */
	@Test
	public void testShipSpace() {
		board.shootAt(coords2);
		assertEquals(-1, board.getBoard()[coords2.getRow()][coords2.getCol()]);					
	}
	
	/**
	 * 4- Despu�s de disparar una casilla disparada que originalmente conten�a 
	 *    un barco, el contenido permanecer� igual y el m�todo devolver� true.
	 * GIVEN Se crea un tablero y varias coordenadas
	 * WHEN Se dispara a una coordenada 2 veces en la que hay un barco
	 * THEN Se comprueba que el valor es el adecuado (-1) y devuelve true 2 veces
	 */
	@Test
	public void testShipSpace2Times() {
		board.shootAt(coords3);
		board.shootAt(coords3);
		assertEquals(-1, board.getBoard()[coords3.getRow()][coords3.getCol()]);		
	}
}
