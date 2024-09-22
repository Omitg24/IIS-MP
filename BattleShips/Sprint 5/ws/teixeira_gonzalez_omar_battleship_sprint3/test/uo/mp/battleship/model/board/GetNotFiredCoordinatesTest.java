package uo.mp.battleship.model.board;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;



import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;

/**
 * Titulo: Clase GetNotFiredCoordinatesTest
 *  
 * @author Omitg
 * @version 24-03-2021
 */
public class GetNotFiredCoordinatesTest {
	
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
	 * Atributo lista no disparadas
	 */
	private List<Coordinate> notFired;
	
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
			
	}
	
	/**
	 * Pruebas del método getNotFiredCoordinates de la clase Board:
	 * 1- Tablero nuevo
	 * 2- Tablero con una casilla disparada
	 * 3- Tablero con una casilla disparada 2 veces
	 * 4- Tablero con muchas casillas disparadas
	 */
		
	/**
	 * 1- Tablero nuevo
	 * GIVEN Se crea un tablero y varias coordenadas
	 * WHEN No se dispara a ninguna casilla
	 * THEN Se comprueba que el tamaño de la lista son todas las casillas del 
	 *      tablero y que cada una coincide con otra
	 */
	@Test
	public void testNewBoard() {
		List<Coordinate> list = board.getNotFiredPositions(); 
		assertEquals(100,list.size());	
		
		notFired = new ArrayList<Coordinate>();		
		for (int i=0; i<board.getBoard().length;i++) {
			for (int j=0; j<board.getBoard()[i].length; j++) {
				if (board.getBoard()[i][j]>=0) {
					notFired.add(new Coordinate(i,j));
				}
			}
		}
		
		for (int i=0; i<list.size();i++) {
			assertEquals(notFired.get(i).toString(),list.get(i).toString());
		}
	}
	
	/**
	 * 2- Tablero con una casilla disparada
	 * GIVEN Se crea un tablero y varias coordenadas
	 * WHEN Se dispara a una casilla
	 * THEN Se comprueba que el tamaño de la lista son todas las casillas del 
	 *      tablero salvo una y que el resto coincide
	 */
	@Test
	public void testOneShot() {
		board.shootAt(coords4);
		
		List<Coordinate> list = board.getNotFiredPositions();		
		assertEquals(99,list.size());		
		
		notFired = new ArrayList<Coordinate>();		
		for (int i=0; i<board.getBoard().length;i++) {
			for (int j=0; j<board.getBoard()[i].length; j++) {
				if (board.getBoard()[i][j]>=0) {
					notFired.add(new Coordinate(i,j));
				}
			}
		}
		
		for (int i=0; i<list.size();i++) {
			assertEquals(notFired.get(i).toString(),list.get(i).toString());
		}
	}
	
	/**
	 * 3- Tablero con una casilla disparada 2 veces
	 * GIVEN Se crea un tablero y varias coordenadas
	 * WHEN Se dispara a una casilla dos veces
	 * THEN Se comprueba que el tamaño de la lista son todas las casillas del 
	 *      tablero salvo una y que el resto coincide
	 */
	@Test
	public void testOneShot2Times() {
		board.shootAt(coords4);
		board.shootAt(coords4);
		
		List<Coordinate> list = board.getNotFiredPositions();	
		assertEquals(99,list.size());		
		
		notFired = new ArrayList<Coordinate>();		
		for (int i=0; i<board.getBoard().length;i++) {
			for (int j=0; j<board.getBoard()[i].length; j++) {
				if (board.getBoard()[i][j]>=0) {
					notFired.add(new Coordinate(i,j));
				}
			}
		}
		
		for (int i=0; i<list.size();i++) {
			assertEquals(notFired.get(i).toString(),list.get(i).toString());
		}
	}
	
	/**
	 * 4- Tablero con muchas casillas disparadas
	 * GIVEN Se crea un tablero y varias coordenadas
	 * WHEN Se disparan a todas las casillas creadas
	 * THEN Se comprueba que el tamaño de la lista son todas menos el 
	 * 		total de las disparadas y que cada una de las restantes coinciden
	 */
	@Test
	public void testSomeShots() {
		board.shootAt(coords1);		
		board.shootAt(coords2);
		board.shootAt(coords3);
		board.shootAt(coords4);
		board.shootAt(coords5);
		board.shootAt(coords6);
		board.shootAt(coords7);
		board.shootAt(coords8);
		board.shootAt(coords9);
		board.shootAt(coords10);
		board.shootAt(coords11);
		board.shootAt(coords12);
		board.shootAt(coords13);
		board.shootAt(coords14);
		board.shootAt(coords15);
		board.shootAt(coords16);
		
		List<Coordinate> list = board.getNotFiredPositions();		
		assertEquals(84,list.size());	
		
		notFired = new ArrayList<Coordinate>();		
		for (int i=0; i<board.getBoard().length;i++) {
			for (int j=0; j<board.getBoard()[i].length; j++) {
				if (board.getBoard()[i][j]>=0) {
					notFired.add(new Coordinate(i,j));
				}
			}
		}
		
		for (int i=0; i<list.size();i++) {
			assertEquals(notFired.get(i).toString(),list.get(i).toString());
		}
	}	
}
