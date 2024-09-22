package uo.mp.battleship.interaction;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.player.Player;

/**
 * Titulo: Inferfaz GamePresenter
 * 
 * Descripción: Interfaz que muestra los estados de la partida
 * 
 * @author Omitg
 * @version 24-03-2021
 */
public interface GamePresenter {
	
	/**
	 * Método que imprime el contenido del juego, es decir, 
	 * los dos tableros en función del debugMode
	 * 
	 * @param left, tablero de la izquierda (del jugador)
	 * @param right, tablero de la derecha (del ordenador)
	 * @param gameMode, modo de juego
	 */
	void showGameStatus(Board left, Board right, boolean gameMode);
	
	/**
	 * Método que muestra el mensaje de Game Over
	 */
	void showGameOver();
	
	/**
	 * Método que muestra el ganador de la partida
	 * 
	 * @param theWinner, ganador de la partida
	 */
	void showWinner(Player theWinner);
	
	/**
	 * Método que imprime si el disparo ha sido tocado, hundido o fallido
	 * 
	 * @param impact, impacto recibido
	 */
	void showHitOrMiss(int impact);
	
	/**
	 * Método que imprime el turno
	 * 
	 * @param player, jugador o ordenador
	 */
	void showTurn(Player player);
	
	/**
	 * Método que muestra las coordenadas a las que se disparan
	 * 
	 * @param coordinate, coordenadas a las que se disparan
	 */
	void showShootingAt(Coordinate coordinate);
}
