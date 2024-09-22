package uo.mp.battleship.model.board;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;

/**
 * Titulo: Clase IsFleetSunkTest
 * 
 * @author Omitg
 * @version 07-03-2021
 */
public class IsFleetSunkTest {
	
	/**
	 * Constante tamaño por defecto
	 */
	public static final int DEFAULT_SIZE = 10;
	
	/**
	 * Atributo tablero
	 */
	private Board board;
	
	/**
	 * Atributos coordenadas
	 */
	private Coordinate coordsS1, coordsS2, coordsS3, coordsS4, coordsD5, coordsD6;
	
	/**
	 * Atributos coordenadas
	 */
	private Coordinate coordsD7, coordsD8, coordsD9, coordsD10, coordsC11, coordsC12;
	
	/**
	 * Atributos coordenadas
	 */
	private Coordinate coordsC13, coordsC14, coordsC15, coordsC16;
	
	/**
	 * Atributos coordenadas
	 */
	private Coordinate coordsB17, coordsB18, coordsB19, coordsB20, coordsF;
	
	/**
	 * Creación de objetos para su uso posterior
	 */
	@Before
	public void setUp() {
		board = new Board (DEFAULT_SIZE);
		
		coordsS1 = new Coordinate (0,0);
		coordsS2 = new Coordinate (2,0);
		coordsS3 = new Coordinate (4,0);
		coordsS4 = new Coordinate (6,0);
		
		coordsD5 = new Coordinate (0,2);
		coordsD6 = new Coordinate (1,2);
		coordsD7 = new Coordinate (3,2);
		coordsD8 = new Coordinate (4,2);
		coordsD9 = new Coordinate (6,2);
		coordsD10 = new Coordinate (7,2);
		
		coordsC11 = new Coordinate (0,4);
		coordsC12 = new Coordinate (1,4);
		coordsC13 = new Coordinate (2,4);		
		coordsC14 = new Coordinate (4,4);
		coordsC15 = new Coordinate (5,4);
		coordsC16 = new Coordinate (6,4);
		
		coordsB17 = new Coordinate (4,6);
		coordsB18 = new Coordinate (5,6);
		coordsB19 = new Coordinate (6,6);
		coordsB20 = new Coordinate (7,6);
		
		coordsF = new Coordinate (0,8);		
	}
	
	/**
	 * Pruebas del método isFleetSunk de la clase Board:
	 * 1- Varios barcos a flote y dispara a una casilla sin barco -> Devuelve false
	 * 2- Varios barcos a flote y dispara a una casilla con barco que no hunde --
	 * 	-> Devuelve false
	 * 3- Varios barcos a flote y dispara a una casilla con un barco que hunde --
	 * 	-> Devuelve false
	 * 4- Un unico barco al que dispara y no hunde -> Devuelve false
	 * 5- Un unico barco al que dispara y hunde -> Devuelve true*
	 */
	
	/**
	 * 1- Varios barcos a flote y dispara a una casilla sin barco -> Devuelve false
	 * GIVEN Se crea un tablero y varias coordenadas
	 * WHEN Se dispara a una coordeanda vacia
	 * THEN Se comprueba que la flota no se ha hundido
	 */
	@Test
	public void testSomeShipsShootFail() {
		board.shootAt(coordsF);		
		assertFalse(board.isFleetSunk());
	}
	
	/**
	 * 2- Varios barcos a flote y dispara a una casilla con barco que no hunde --
	 * 	-> Devuelve false
	 * GIVEN Se crea un tablero y varias coordenadas
	 * WHEN Se dispara a una coordeanda con barco que no hunde
	 * THEN Se comprueba que la flota no se ha hundido
	 */
	@Test
	public void testSomeShipsShootOkButNoSunk() {
		board.shootAt(coordsD6);		
		assertFalse(board.isFleetSunk());
	}
	
	/**
	 * 3- Varios barcos a flote y dispara a una casilla con un barco que hunde --
	 * 	-> Devuelve false
	 * GIVEN Se crea un tablero y varias coordenadas
	 * WHEN Se dispara a una coordeanda con barco que hunde
	 * THEN Se comprueba que la flota no se ha hundido
	 */
	@Test
	public void testSomeShipsShootOkAndSunk() {
		board.shootAt(coordsD5);
		board.shootAt(coordsD6);				
		assertFalse(board.isFleetSunk());
	}
	
	/**
	 * 4- Un unico barco al que dispara y no hunde -> Devuelve false
	 * GIVEN Se crea un tablero y varias coordenadas
	 * WHEN Se dispara a un barco que no hunde
	 * THEN Se comprueba que la flota no se ha hundido
	 */
	@Test
	public void testOneShipFleetNotSunk() {
		board.shootAt(coordsS1);
		board.shootAt(coordsS2);
		board.shootAt(coordsS3);
		board.shootAt(coordsS4);
		board.shootAt(coordsD5);
		board.shootAt(coordsD6);
		board.shootAt(coordsD7);
		board.shootAt(coordsD8);
		board.shootAt(coordsD9);
		board.shootAt(coordsD10);
		board.shootAt(coordsC11);
		board.shootAt(coordsC12);
		board.shootAt(coordsC13);
		board.shootAt(coordsC14);
		board.shootAt(coordsC15);
		board.shootAt(coordsC16);
		board.shootAt(coordsB17);
		board.shootAt(coordsB18);
		board.shootAt(coordsB19);		
		assertFalse(board.isFleetSunk());		
	}
	
	/**
	 * 5- Un unico barco al que dispara y hunde -> Devuelve true
	 * GIVEN Se crea un tablero y varias coordenadas
	 * WHEN Se dispara a un barco que hunde
	 * THEN Se comprueba que la flota se ha hundido
	 */
	@Test
	public void testOneShipFleetSunk() {
		board.shootAt(coordsS1);
		board.shootAt(coordsS2);
		board.shootAt(coordsS3);
		board.shootAt(coordsS4);
		board.shootAt(coordsD5);
		board.shootAt(coordsD6);
		board.shootAt(coordsD7);
		board.shootAt(coordsD8);
		board.shootAt(coordsD9);
		board.shootAt(coordsD10);
		board.shootAt(coordsC11);
		board.shootAt(coordsC12);
		board.shootAt(coordsC13);
		board.shootAt(coordsC14);
		board.shootAt(coordsC15);
		board.shootAt(coordsC16);
		board.shootAt(coordsB17);
		board.shootAt(coordsB18);
		board.shootAt(coordsB19);
		board.shootAt(coordsB20);		
		assertTrue(board.isFleetSunk());		
	}
}
