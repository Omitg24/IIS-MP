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
 * @version 12-02-2021
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
	private Coordinate coords1, coords2, coords3, coords4, coords5, coords6;
	
	/**
	 * Atributos coordenadas
	 */
	private Coordinate coords7, coords8, coords9, coords10, coords11, coords12;
	
	/**
	 * Atributos coordenadas
	 */
	private Coordinate coords13, coords14, coords15, coords16;
	
	/**
	 * Atributos coordenadas
	 */
	private Coordinate coords17, coords18, coords19, coords20, coordsF;
	
	/**
	 * Creación de objetos para su uso posterior
	 */
	@Before
	public void setUp() {
		board = new Board (DEFAULT_SIZE);
		
		coords1 = new Coordinate (0,0);
		coords2 = new Coordinate (2,0);
		coords3 = new Coordinate (4,0);
		coords4 = new Coordinate (6,0);
		
		coords5 = new Coordinate (0,2);
		coords6 = new Coordinate (1,2);
		coords7 = new Coordinate (3,2);
		coords8 = new Coordinate (4,2);
		coords9 = new Coordinate (6,2);
		coords10 = new Coordinate (7,2);
		
		coords11 = new Coordinate (0,4);
		coords12 = new Coordinate (1,4);
		coords13 = new Coordinate (2,4);		
		coords14 = new Coordinate (4,4);
		coords15 = new Coordinate (5,4);
		coords16 = new Coordinate (6,4);
		
		coords17 = new Coordinate (4,6);
		coords18 = new Coordinate (5,6);
		coords19 = new Coordinate (6,6);
		coords20 = new Coordinate (7,6);
		
		coordsF = new Coordinate (8,0);		
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
		boolean test = board.shootAt(coordsF);
		assertFalse(test);
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
		boolean test = board.shootAt(coords6);
		assertTrue(test);
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
		boolean test = board.shootAt(coords5);
		boolean test2 = board.shootAt(coords6);
		assertTrue(test);
		assertTrue(test2);		
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
		assertTrue(board.shootAt(coords1));
		assertTrue(board.shootAt(coords2));
		assertTrue(board.shootAt(coords3));
		assertTrue(board.shootAt(coords4));
		assertTrue(board.shootAt(coords5));
		assertTrue(board.shootAt(coords6));
		assertTrue(board.shootAt(coords7));
		assertTrue(board.shootAt(coords8));
		assertTrue(board.shootAt(coords9));
		assertTrue(board.shootAt(coords10));
		assertTrue(board.shootAt(coords11));
		assertTrue(board.shootAt(coords12));
		assertTrue(board.shootAt(coords13));
		assertTrue(board.shootAt(coords14));
		assertTrue(board.shootAt(coords15));
		assertTrue(board.shootAt(coords16));
		assertTrue(board.shootAt(coords17));
		assertTrue(board.shootAt(coords18));
		assertTrue(board.shootAt(coords19));		
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
		assertTrue(board.shootAt(coords1));
		assertTrue(board.shootAt(coords2));
		assertTrue(board.shootAt(coords3));
		assertTrue(board.shootAt(coords4));
		assertTrue(board.shootAt(coords5));
		assertTrue(board.shootAt(coords6));
		assertTrue(board.shootAt(coords7));
		assertTrue(board.shootAt(coords8));
		assertTrue(board.shootAt(coords9));
		assertTrue(board.shootAt(coords10));
		assertTrue(board.shootAt(coords11));
		assertTrue(board.shootAt(coords12));
		assertTrue(board.shootAt(coords13));
		assertTrue(board.shootAt(coords14));
		assertTrue(board.shootAt(coords15));
		assertTrue(board.shootAt(coords16));
		assertTrue(board.shootAt(coords17));
		assertTrue(board.shootAt(coords18));
		assertTrue(board.shootAt(coords19));
		assertTrue(board.shootAt(coords20));
		assertTrue(board.isFleetSunk());		
	}
}
