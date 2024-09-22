package uo.mp.battleship.player;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Superclase Player
 * 
 * Descripción: Clase que engloba a las subclases HumanPlayer y ComputerPlayer
 * @author Omitg
 *
 */
public abstract class Player {
	/**
	 * Atributo name
	 */
	protected String name;
	
	/**
	 * Constructor con parámetros, que crea la superclase
	 */
	public Player() {
		super();
	}
	
	/**
	 * Constructor con parámetro name, que crea la superclase
	 * 
	 * @param name, nombre del jugador
	 */
	public Player(String name) {
		super();
		ArgumentChecks.isTrue(name!=null && !name.trim().isEmpty(), 
				"El nombre no es valido");
		setName(name);
	}
	
	/**
	 * Método que modifica el valor del atributo name
	 * 
	 * @param name, nombre del jugador
	 */
	protected void setName(String name) {
		this.name=name;
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
	 * Método que analiza si ha ganado el jugador, al hundir todos los barcos 
	 * del oponente
	 * 
	 * @return true o false, si ha derribado todos los barcos del oponente
	 */
	public abstract boolean hasWon();
	
	/**
	 * Método que dispara a una posición del tablero del oponente, y en función 
	 * del daño del disparo devuelve 0, 1 o 2
	 * 
	 * @param position, coordenadas a donde disparar
	 * @return 0, 1 o 2, en función del daño que se ha hecho
	 */
	public abstract int shootAt(Coordinate position);
	
	/**
	 * Métoodo que selecciona las coordenadas a disparar a los barcos del oponente 
	 * mediante la entrada por teclado o automatica
	 * 
	 * @return coordenadas
	 */
	public abstract Coordinate makeChoice();
	
	/**
	 * Método que devuelve el valor del atributo myShips
	 * 
	 * @return myShips, barcos del jugador
	 */
	public abstract Board getMyShips();
	
	/**
	 * Método que devuelve el valor del atributo opponentShips
	 * 
	 * @return opponentShips, barcos del oponente
	 */
	public abstract Board getOpponentShips();

}