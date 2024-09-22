package uo.mp.battleship.game;

import uo.mp.battleship.player.Player;

/**
 * Titulo: Clase TurnSelector
 * 
 * Descripción: Clase que maneja los turnos de juego. Empieza el usuario
 * 
 * @author Omitg
 * @version 07-03-2021
 */
public class TurnSelector {
//Constantes:
	/**
	 * Constantes turno del jugador y del ordenador
	 */
	public static final boolean PLAYER_TURN = true, COMPUTER_TURN = false;
//Atributo:
	/**
	 * Atributos usuario y ordenador
	 */ 
	private Player user, computer;
	
	/**
	 * Atributo turn
	 */
	private boolean turn;
	
	/**
	 * Constructor que inicializa el turno, empieza el jugador
	 * 
	 * @param user, jugador humano
	 * @param computer, jugador ordenador
	 */
	public TurnSelector(Player user, Player computer) {
		setTurn(PLAYER_TURN);
		this.user=user;
		this.computer=computer;
	}
	
	/**
	 * Método alterna el turno entre el jugador y la maquina
	 * 
	 * @return turn, quien lleva el turno
	 */
	public Player next() {
		if (getTurn()) {
			setTurn(COMPUTER_TURN);
			return computer;
		} else {
			setTurn(PLAYER_TURN);
			return user;
		}
	}
		
	/**
	 * Método que modifica el valor del atributo turn
	 * 
	 * @param turn, turno del juego
	 */
	private void setTurn(boolean turn) {		
		this.turn = turn;
	}	
	
	/**
	 * Método que devuelve el valor del atributo turn
	 * 
	 * @return turn, turno del juego
	 */
	public boolean getTurn() {
		return turn;
	}
	
	/**
	 * Método que establece que el turno debe ser repetido  
	 */
	public void repeat() {
		if (getTurn()) {
			setTurn(PLAYER_TURN);
		} else {
			setTurn(COMPUTER_TURN);
		}
	}
}

