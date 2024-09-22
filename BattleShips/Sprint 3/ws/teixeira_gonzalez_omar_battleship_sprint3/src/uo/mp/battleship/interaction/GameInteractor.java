package uo.mp.battleship.interaction;

import uo.mp.battleship.board.Coordinate;

/**
 * Titulo: Interfaz GameInteractor
 * 
 * Descripci�n: Interfaz ue contiene un m�todo que genera una coordenada y la devuelve
 * 
 * @author Omitg
 * @version 24-03-2021
 */
public interface GameInteractor {
	/**
	 * M�todo que genera una coordenada a la que se va a disparar y la devuelve
	 * 
	 * @return coord, coordenada a la que se va a disparar
	 */
	Coordinate getTarget();
}
