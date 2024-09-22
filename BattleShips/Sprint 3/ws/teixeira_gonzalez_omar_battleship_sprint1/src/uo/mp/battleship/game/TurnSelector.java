package uo.mp.battleship.game;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase TurnSelector
 * 
 * Descripción: Clase que maneja los turnos de juego. Empieza el usuario
 * 
 * @author Omitg
 * @version 12-02-2021
 */
public class TurnSelector {
	/**
	 * Constante turno del jugador
	 */
	public static final int PLAYER_TURN = 1;
	
	/**
	 * Constante turno del ordenador
	 */
	public static final int COMPUTER_TURN = 0;
	
	/**
	 * Atributo turn
	 */
	private int turn;
	
	/**
	 * Constructor que inicializa el turno, empieza el jugador
	 */
	public TurnSelector() {
		setTurn(PLAYER_TURN);
	}
	
	/**
	 * Método alterna el turno entre el jugador y la maquina
	 * 
	 * @return turn, quien lleva el turno
	 */
	public int next() {		
		if (getTurn() == PLAYER_TURN) {
			setTurn(COMPUTER_TURN);
			return PLAYER_TURN;
		}else { 
			setTurn(PLAYER_TURN);
			return COMPUTER_TURN;
		}		
	}
	
	/**
	 * Método que modifica el valor del atributo turn
	 * 
	 * @param turn, turno del juego
	 */
	public void setTurn(int turn) {
		ArgumentChecks.isTrue(turn==0 || turn==1, 
				"El parámetro no cumple los requisitos");
		this.turn = turn;
	}	
	
	/**
	 * Método que devuelve el valor del atributo turn
	 * 
	 * @return turn, turno del juego
	 */
	public int getTurn() {
		return turn;
	}
}

