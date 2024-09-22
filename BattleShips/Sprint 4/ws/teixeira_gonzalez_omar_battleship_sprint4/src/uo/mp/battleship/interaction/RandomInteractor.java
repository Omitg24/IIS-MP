package uo.mp.battleship.interaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uo.mp.battleship.board.Coordinate;

/**
 * Titulo: Clase RandomInteractor
 * 
 * Descripción: Clase que genera coordenadas aleatorias para que dispare el ordenador
 * 
 * @author Omitg
 * @version 16-04-2021
 */
public class RandomInteractor implements GameInteractor{
//Atributos:
	/**
	 * Atributo lista de coordenadas
	 */
	private List<Coordinate> coords = new ArrayList<Coordinate>();	
	/**
	 * Atributo tamaño
	 */
	private int size;	
	
	/**
	 * Método que setea el tamaño del tablero
	 * 
	 * @param i, tamaño del tablero
	 */
	public RandomInteractor(int i) {
		this.size=i;
	}
	
	/**
	 * Método que devuelve la coordenada a la que dispara el ordenador
	 * 
	 * @return coord, coordenada a la que dispara
	 */
	@Override
	public Coordinate getTarget() {
		Random r = new Random();
		int col = r.nextInt(size);
		int row = r.nextInt(size);
		Coordinate coord = new Coordinate(col, row);	
		for (int i=0; i<coords.size();i++) {
			if (coords.get(i).equals(coord)) {
				col = r.nextInt(size);
				row = r.nextInt(size);
				coord = new Coordinate(col, row);
			}
		}
		coords.add(coord);
		return coord;
	}
}
