package uo.mp.battleship.player;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.util.IO;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase HumanPlayer
 * 
 * Descripción: Clase que se encarga de representar el tablero del jugador
 * 
 * @author Omitg
 * @version 07-03-2021
 */
public class HumanPlayer extends Player {
//Atributos:
	/**
	 * Atributo myShips
	 */
	private Board myShips;
	/**
	 * Atributo opponentShips
	 */
	private Board opponentShips;
	
	/**
	 * Constructor con parámetro name de la clase HumanPlayer
	 * 
	 * @param name, nombre del jugador
	 */
	public HumanPlayer(String name) {
		super(name);
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
		}
		return false;		
	}
	
	/**
	 * Método que dispara a una posición del tablero del oponente, y en función 
	 * del daño del disparo devuelve 0, 1 o 2
	 * 
	 * @param position, coordenadas a donde disparar
	 * @return 0, 1 o 2, en función del daño que se ha hecho
	 */
	@Override
	public int shootAt(Coordinate position) {
		return opponentShips.shootAt(position);
	}
	
	/**
	 * Métoodo que selecciona las coordenadas a disparar a los barcos del oponente 
	 * mediante la entrada por teclado
	 * 
	 * @return coordenadas
	 */
	@Override
	public Coordinate makeChoice() {		
		Coordinate position = IO.readCoordinates(); 
		while (opponentShips.getNotFiredPositions().contains(position)) {
			position = IO.readCoordinates();
		}
		return position;
	}	
}
