package uo.mp.battleship.player;

import java.util.Random;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase ComputerPlayer
 * 
 * Descripci�n: Clase que se encarga de representar el tablero del computador
 *  
 * @author Omitg
 * @version 07-03-2021
 */
public class ComputerPlayer extends Player {
	
	/**
	 * Atributo myShips
	 */
	private Board myShips;
	/**
	 * Atributo opponentShips
	 */
	private Board opponentShips;
	
	/**
	 * Constructor con par�metro name de la clase ComputerPlayer
	 * 
	 * @param name, nombre del ordenador
	 */
	public ComputerPlayer(String name) {
		super("computer");
	}
	
	/**
	 * M�todo que modifica el valor del atributo myShips
	 * 
	 * @param board, tablero que pasara a ser myShips
	 */
	public void setMyShips(Board board) {
		ArgumentChecks.isTrue(board!=null, "El tablero ha de ser distino de null");
		this.myShips = board;		
	}

	/**
	 * M�todo que modifica el valor del atributo opponentShips
	 * 
	 * @param board, tablero que pasara a ser opponentShips
	 */
	public void setOpponentShips(Board board) {
		ArgumentChecks.isTrue(board!=null, "El tablero ha de ser distino de null");
		this.opponentShips = board;
	}
	
	/**
	 * M�todo que devuelve el valor del atributo myShips
	 * 
	 * @return myShips, barcos del jugador
	 */
	public Board getMyShips() {
		return myShips;
	}

	/**
	 * M�todo que devuelve el valor del atributo opponentShips
	 * 
	 * @return opponentShips, barcos del oponente
	 */
	public Board getOpponentShips() {
		return opponentShips;
	}

	/**
	 * M�todo que analiza si ha ganado el jugador, al hundir todos los barcos 
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
	 * M�todo que dispara a una posici�n del tablero del oponente, y en funci�n 
	 * del da�o del disparo devuelve 0, 1 o 2
	 * 
	 * @param position, coordenadas a donde disparar
	 * @return 0, 1 o 2, en funci�n del da�o que se ha hecho
	 */
	@Override
	public int shootAt(Coordinate position) {
		return opponentShips.shootAt(position);
	}	
	
	/**
	 * M�toodo que selecciona las coordenadas a disparar a los barcos del oponente 
	 * aleatoriamente
	 * 
	 * @return coordenadas
	 */
	@Override
	public Coordinate makeChoice() {
		Random r = new Random();
		int n = r.nextInt(opponentShips.getNotFiredPositions().size());		
		return opponentShips.getNotFiredPositions().get(n);
	}
}
