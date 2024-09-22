package uo.mp.battleship.interaction;

import uo.mp.battleship.board.Coordinate;

/**
 * Titulo: Interfaz GameInteractor
 * 
 * Descripción: Interfaz que contiene un método que genera una coordenada y la devuelve
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public interface GameInteractor {
	/**
	 * Método que genera una coordenada a la que se va a disparar y la devuelve
	 * 
	 * @return coord, coordenada a la que se va a disparar
	 */
	Coordinate getTarget();
}
