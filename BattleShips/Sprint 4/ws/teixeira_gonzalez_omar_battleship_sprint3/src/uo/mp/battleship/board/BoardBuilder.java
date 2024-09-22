package uo.mp.battleship.board;

import java.util.ArrayList;
import java.util.List;

import uo.mp.battleship.board.squares.Ship;
import uo.mp.battleship.board.squares.Water;
import uo.mp2021.util.checks.ArgumentChecks;
import uo.mp2021.util.checks.StateChecks;

/**
 * Titulo: Clase BoardBuilder
 * 
 * Descripción: Clase que se encarga de generar el tablero
 * 
 * @author Omitg
 * @version 24-03-2021
 */
public class BoardBuilder {
	/**
	 * Tamaño minimo del tablero
	 */
	public static final int MIN_SIZE = 10;
	
	/**
	 * Tamaño máximo del tablero
	 */
	public static final int MAX_SIZE = 15;
	
//Atributos:	
	/**
	 * Atributo tablero
	 */
	private Square[][] board;
	
	/**
	 * Atributo tamaño
	 */
	private int size;
	
	/*
	 * Atributop lista de barcos (flota)
	 */
	protected static List<Ship> ships;

	/**
	 * Método que settea el tamaño de la dimension del tablero, debe de ser 
	 * entre 5 y 15
	 * 
	 * @param size, tamaño del tablero
	 * @return board, devuelve el tablero
	 */
	public BoardBuilder of(int size) {		
		ArgumentChecks.isTrue(size>=MIN_SIZE && size<=MAX_SIZE, 
				"El tamaño no respeta los límites");		
		setSize(size);
		return this;
	}
	
	/**
	 * Método que crea la flota para el atributo fleet
	 * 
	 * @param fleet, lista de barcos (flota)
	 * @return this, BoarBuilder con la flota
	 */
	public BoardBuilder forFleet(List<Ship> fleet) {
		ships=fleet;		
		return this;
	}
		
	/**
	 * Método que construye el tablero situando a los barcos en una posición 
	 * fija
	 * 
	 * @return board, tablero con los barcos situados
	 */
	public Square[][] build() {	
		buildWater();				
				
		board[0][0].setContent(ships.get(0));
		board[0][2].setContent(ships.get(1));
		board[0][4].setContent(ships.get(2));
		board[0][6].setContent(ships.get(3));
		
		board[2][0].setContent(ships.get(4));
		board[2][1].setContent(ships.get(4));
		board[2][3].setContent(ships.get(5));
		board[2][4].setContent(ships.get(5));
		board[2][6].setContent(ships.get(6));
		board[2][7].setContent(ships.get(6));
		
		board[4][0].setContent(ships.get(7));
		board[4][1].setContent(ships.get(7));
		board[4][2].setContent(ships.get(7));
		board[4][4].setContent(ships.get(8));
		board[4][5].setContent(ships.get(8));
		board[4][6].setContent(ships.get(8));
		
		
		board[6][4].setContent(ships.get(9));
		board[6][5].setContent(ships.get(9));
		board[6][6].setContent(ships.get(9));
		board[6][7].setContent(ships.get(9));			
		return board;	
	}
	
	/**
	 * Método que crea el tablero con todo objetos Water
	 * 
	 * @return board, tablero con Water
	 */
	private Square[][] buildWater() {
		of(size);
		forFleet(createFleet());
		StateChecks.isTrue(size>=MIN_SIZE && size<=MAX_SIZE, 
				"El tamaño no respeta los límites");
		StateChecks.isTrue(ships.size()==10 && ships!=null, 
				"La flota no respeta los requisitos");
		board = new Square[getSize()][getSize()];
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length;j++) {
				board[i][j] = new Square();
				board[i][j] = new Square().setContent(new Water());
			}
		}
		return board;
	}
	
	/**
	 * Método que setea el tamaño del tablero
	 * 
	 * @param size, tamaño del tablero
	 */
	private void setSize(int size) {
		this.size=size;
	}
	
	/**
	 * Método que devuelve el tamaño del tablero
	 * 
	 * @return size, tamaño del tablero
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Método que crea la flota de barcos
	 * 
	 * @return ships, flota de barcos
	 */
	public static List<Ship> createFleet(){
		ships = new ArrayList<Ship>();
		
		Ship submarine1 = new Ship(Ship.SUBMARINE);
		Ship submarine2 = new Ship(Ship.SUBMARINE);
		Ship submarine3 = new Ship(Ship.SUBMARINE);
		Ship submarine4 = new Ship(Ship.SUBMARINE);		
		Ship destroyer1 = new Ship(Ship.DESTROYER);
		Ship destroyer2 = new Ship(Ship.DESTROYER);
		Ship destroyer3 = new Ship(Ship.DESTROYER);
		Ship cruiser1 = new Ship(Ship.CRUISER);
		Ship cruiser2 = new Ship(Ship.CRUISER);		
		Ship battleship = new Ship (Ship.BATTLESHIP);
		
		ships.add(submarine1);
		ships.add(submarine2);
		ships.add(submarine3);
		ships.add(submarine4);
		
		ships.add(destroyer1);
		ships.add(destroyer2);
		ships.add(destroyer3);
		
		ships.add(cruiser1);
		ships.add(cruiser2);
		
		ships.add(battleship);
		return ships;
	}
}