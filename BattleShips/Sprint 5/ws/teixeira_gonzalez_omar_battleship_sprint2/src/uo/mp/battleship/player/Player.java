package uo.mp.battleship.player;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Superclase Player
 * 
 * Descripci�n: Clase que engloba a las subclases HumanPlayer y ComputerPlayer
 * @author Omitg
 *
 */
public abstract class Player {
	/**
	 * Atributo name
	 */
	protected String name;
	
	/**
	 * Constructor con par�metros, que crea la superclase
	 */
	public Player() {
		super();
	}
	
	/**
	 * Constructor con par�metro name, que crea la superclase
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
	 * M�todo que modifica el valor del atributo name
	 * 
	 * @param name, nombre del jugador
	 */
	protected void setName(String name) {
		this.name=name;
	}
	
	/**
	 * M�todo que devuelve el valor del atributo name
	 * 
	 * @return name, nombre del jugador
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * M�todo que analiza si ha ganado el jugador, al hundir todos los barcos 
	 * del oponente
	 * 
	 * @return true o false, si ha derribado todos los barcos del oponente
	 */
	public abstract boolean hasWon();
	
	/**
	 * M�todo que dispara a una posici�n del tablero del oponente, y en funci�n 
	 * del da�o del disparo devuelve 0, 1 o 2
	 * 
	 * @param position, coordenadas a donde disparar
	 * @return 0, 1 o 2, en funci�n del da�o que se ha hecho
	 */
	public abstract int shootAt(Coordinate position);
	
	/**
	 * M�toodo que selecciona las coordenadas a disparar a los barcos del oponente 
	 * mediante la entrada por teclado o automatica
	 * 
	 * @return coordenadas
	 */
	public abstract Coordinate makeChoice();
	
	/**
	 * M�todo que devuelve el valor del atributo myShips
	 * 
	 * @return myShips, barcos del jugador
	 */
	public abstract Board getMyShips();
	
	/**
	 * M�todo que devuelve el valor del atributo opponentShips
	 * 
	 * @return opponentShips, barcos del oponente
	 */
	public abstract Board getOpponentShips();

}