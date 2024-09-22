package uo.mp.battleship.player;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.util.IO;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase HumanPlayer
 * 
 * @author Omitg
 * @version 12-02-2021
 */
public class HumanPlayer {
	/**
	 * Atributo myShips
	 */
	private Board myShips;
	
	/**
	 * Atributo opponentShips
	 */
	private Board opponentShips;
	
	/**
	 * Atributo name
	 */
	private String name;
	
	/**
	 * Constructor con parámetro name de la clase HumanPlayer
	 * 
	 * @param name, nombre del jugador
	 */
	public HumanPlayer(String name) {
		ArgumentChecks.isTrue(name!=null && !name.trim().isEmpty(), 
				"El nombre no es valido");
		setName(name);
	}
	
	/**
	 * Método que devuelve el valor del atributo name
	 * 
	 * @return name, nombre del jugador
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Método que modifica el valor del atributo name
	 * 
	 * @param name, nombre del jugador
	 */
	private void setName(String name) {
		this.name=name;
	}
	
	/**
	 * Método que modifica el valor del atributo myShips
	 * 
	 * @param board, tablero que pasara a ser myShips
	 */
	public void setMyShips(Board board) {
		ArgumentChecks.isTrue(board!=null, "El tablero ha de ser distino de null");
		this.myShips = board;		
	}
	
	/**
	 * Método que modifica el valor del atributo opponentShips
	 * 
	 * @param board, tablero que pasara a ser opponentShips
	 */
	public void setOpponentShips(Board board) {
		ArgumentChecks.isTrue(board!=null, "El tablero ha de ser distino de null");
		this.opponentShips = board;
	}
	
	/**
	 * Método que dispara a una posición del tablero del oponente, y si hay un barco, 
	 * devuelve true
	 * 
	 * @param position, coordenadas a donde disparar
	 * @return true o false, en función de si hay un barco en dichas coordendas
	 */
	public boolean shootAt(Coordinate position) {
		return opponentShips.shootAt(position);
	}
	
	/**
	 * Método que devuelve el valor del atributo myShips
	 * 
	 * @return myShips, barcos del jugador
	 */
	public Board getMyShips() {
		return myShips;
	}
	
	/**
	 * Método que devuelve el valor del atributo opponentShips
	 * 
	 * @return opponentShips, barcos del oponente
	 */
	public Board getOpponentShips() {
		return opponentShips;
	}
	
	/**
	 * Método que analiza si ha ganado el jugador, al hundir todos los barcos 
	 * del oponente
	 * 
	 * @return true o false, si ha derribado todos los barcos del oponente
	 */
	public boolean hasWon() {
		if (opponentShips.isFleetSunk()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Métoodo que selecciona las coordenadas a disparar a los barcos del oponente 
	 * mediante la entrada
	 * por teclado
	 * 
	 * @return coordenadas
	 */
	public Coordinate makeChoice(){		
		return IO.readCoordinates();		
	}
}
