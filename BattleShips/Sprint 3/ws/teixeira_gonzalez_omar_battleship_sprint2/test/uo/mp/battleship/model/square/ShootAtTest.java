package uo.mp.battleship.model.square;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.board.Square;
import uo.mp.battleship.board.squares.Ship;
import uo.mp.battleship.board.squares.Water;

/**
 * Titulo: Clase ShootAtTest
 * 
 * @author Omitg
 * @version 07-03-2021
 */
public class ShootAtTest {
	/**
	 * Atributos barco
	 */
	private static final int SUBMARINE = 1, DESTROYER = 2, CRUISER = 3, BATTLESHIP = 4;
	/**
	 * Atributo tamaño por defecto
	 */
	private static final int SIZE_FOR_TEST = 10;
	/**
	 * Atributo tablero
	 */
	private static Board board;
	
	/**
	 * Creación de objetos para su posterior uso
	 */
	@BeforeClass
	public static void setUpBeforeClass(){
		Square[][] boardForTest = new Square[SIZE_FOR_TEST][SIZE_FOR_TEST];
		
		board = new Board(SIZE_FOR_TEST);
		
		Ship s1 = new Ship(SUBMARINE);
		Ship s2 = new Ship(SUBMARINE);
		Ship s3 = new Ship(SUBMARINE);
		Ship s4 = new Ship(SUBMARINE);

		Ship d1 = new Ship(DESTROYER);
		Ship d2 = new Ship(DESTROYER);
		Ship d3 = new Ship(DESTROYER);

		Ship c1 = new Ship(CRUISER);
		Ship c2 = new Ship(CRUISER);

		Ship b = new Ship(BATTLESHIP);

		boardForTest[0][0] = new Square().setContent(s1);
		boardForTest[0][1] = new Square().setContent(new Water());
		boardForTest[0][2] = new Square().setContent(s2);
		boardForTest[0][3] = new Square().setContent(new Water());
		boardForTest[0][4] = new Square().setContent(s3);
		boardForTest[0][5] = new Square().setContent(new Water());
		boardForTest[0][6] = new Square().setContent(s4);
		boardForTest[0][7] = new Square().setContent(new Water());

		for (int i=0; i<SIZE_FOR_TEST; i++) {
			boardForTest[1][i] = new Square().setContent(new Water());
		}
	
		boardForTest[2][0] = new Square().setContent(d1);
		boardForTest[2][1] = new Square().setContent(d1);
		boardForTest[2][2] = new Square().setContent(new Water());
		boardForTest[2][3] = new Square().setContent(d2);
		boardForTest[2][4] = new Square().setContent(d2);
		boardForTest[2][5] = new Square().setContent(new Water());
		boardForTest[2][6] = new Square().setContent(d3);
		boardForTest[2][7] = new Square().setContent(d3);

		for (int i=0; i<SIZE_FOR_TEST; i++) {
			boardForTest[3][i] = new Square().setContent(new Water());
		}

		boardForTest[4][0] = new Square().setContent(c1);
		boardForTest[4][1] = new Square().setContent(c1);
		boardForTest[4][2] = new Square().setContent(c1);
		boardForTest[4][3] = new Square().setContent(new Water());
		boardForTest[4][4] = new Square().setContent(c2);
		boardForTest[4][5] = new Square().setContent(c2);
		boardForTest[4][6] = new Square().setContent(c2);
		boardForTest[4][7] = new Square().setContent(new Water());

		for (int i=0; i<SIZE_FOR_TEST; i++) {
			boardForTest[5][i] = new Square().setContent(new Water());
		}

		boardForTest[6][0] = new Square().setContent(new Water());
		boardForTest[6][1] = new Square().setContent(new Water());
		boardForTest[6][2] = new Square().setContent(new Water());
		boardForTest[6][3] = new Square().setContent(new Water());
		boardForTest[6][4] = new Square().setContent(b);
		boardForTest[6][5] = new Square().setContent(b);
		boardForTest[6][6] = new Square().setContent(b);
		boardForTest[6][7] = new Square().setContent(b);

		for (int i=0; i<SIZE_FOR_TEST; i++) {
			boardForTest[7][i] = new Square().setContent(new Water());
		}
		
		board.setSquaresForTest(boardForTest);
	}
	
	/**
	 * Pruebas del método shootAt de la clase Square:
	 * 1- Disparo al agua, devuelve 0
	 * 2- Disparo al submarino, devuelve 2
	 * 3- Disparo a un destructor, devuelve 1
	 * 4- Disparo y hundimiento a un destructor, devuelve 2
	 */
	
	/**
	 * 1- Disparo al agua, devuelve 0
	 * GIVEN Se crean barcos y se situan en un tablero
	 * WHEN Se llama al método shootAt apuntando a una casilla con agua
	 * THEN Se comprueba que devuelve 0
	 */
	@Test
	public void testShootWater() {
		assertEquals(0, board.shootAt(new Coordinate(0,1)));
	}
	
	/**
	 * 2- Disparo al submarino, devuelve 2
	 * GIVEN Se crean barcos y se situan en un tablero
	 * WHEN Se llama al método shootAt apuntando a una casilla con submarino
	 * THEN Se comprueba que devuelve 2
	 */
	@Test
	public void testShootSubmarine() {
		assertEquals(2, board.shootAt(new Coordinate(0,0)));
	}
	
	/**
	 * 3- Disparo a un destructor, devuelve 1
	 * GIVEN Se crean barcos y se situan en un tablero
	 * WHEN Se llama al método shootAt apuntando a una casilla con un destructor
	 * THEN Se comprueba que devuelve 1
	 */
	@Test
	public void testShootDestructor() {
		assertEquals(1, board.shootAt(new Coordinate(0,2)));
	}
	
	/**
	 * 4- Disparo y hundimiento a un destructor, devuelve 2
	 * GIVEN Se crean barcos y se situan en un tablero
	 * WHEN Se llama al método shootAt apuntando a las dos casillas del destructor
	 * THEN Se comprueba que devuelve 2
	 */
	@Test
	public void testShootToSunkDestructor() {		
		board.shootAt(new Coordinate(3,2));
		assertEquals(2, board.shootAt(new Coordinate(4,2)));
	}
}
