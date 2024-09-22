package uo.mp.battleship.console;

import java.util.ArrayList;
import java.util.List;

import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.interaction.GameInteractor;
import uo.mp.battleship.util.IO;

/**
 * Titulo: Clase ConsolePlayerInteractor
 * 
 * Descripci�n: Clase que lee las coordenadas introducidas por el jugador
 * 
 * @author Omitg
 * @version 24-03-2021
 */
public class ConsolePlayerInteractor implements GameInteractor{
	/**
	 * Atributo lista de coordenadas
	 */
	private List<Coordinate> coords = new ArrayList<Coordinate>();
	
	/**
	 * M�todo que devuelve las coordenadas introducidas por el jugador
	 * 
	 * @return target, coordenadas introducidas
	 */
	@Override
	public Coordinate getTarget() {			
		Coordinate target = IO.readCoordinates();		
		while(coords.contains(target)) {
			target = IO.readCoordinates();
		}
		coords.add(target);
		return target;
	}
}
