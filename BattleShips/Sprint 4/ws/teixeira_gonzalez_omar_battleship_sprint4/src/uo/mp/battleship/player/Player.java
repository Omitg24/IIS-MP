package uo.mp.battleship.player;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.interaction.GameInteractor;
import uo.mp2021.util.checks.ArgumentChecks;
import uo.mp2021.util.checks.StateChecks;

/**
 * Titulo: Superclase Player
 * 
 * Descripci�n: Clase que engloba a las subclases HumanPlayer y ComputerPlayer
 * 
 * @author Omitg
 * @version 16-04-2021
 */
public class Player implements GameInteractor{
	/**
	 * Atributo myShips
	 */
	private Board myShips;
	/**
	 * Atributo opponentShips
	 */
	private Board opponentShips;
	
	/**
	 * Atributo name
	 */
	private String name;
	
	/**
	 * Atributo interactor
	 */
	private GameInteractor interactor;	
	
	/**
	 * Constructor con par�metro name, que crea la superclase
	 * 
	 * @param name, nombre del jugador
	 */
	public Player(String name) {
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
		StateChecks.isTrue(interactor!=null, "El m�todo setInteractor no se ha ejecutado previamente");
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
	public int shootAt(Coordinate position) {
		StateChecks.isTrue(interactor!=null, "El m�todo setInteractor no se ha ejecutado previamente");				
		return opponentShips.shootAt(position);
	}	
	
	/**
	 * M�todo que modifica el valor del atributo interactor
	 * 
	 * @param arg, nuevo interactor
	 */
	public void setInteractor(GameInteractor arg) {
		ArgumentChecks.isTrue(arg!=null, "El argumento no cumple los requisitos");
		this.interactor=arg;
	}	
	
	/**
	 * M�todo que genera una coordenada a la que se va a disparar y la devuelve
	 * 
	 * @return coord, coordenada a la que se va a disparar
	 */
	@Override
	public Coordinate getTarget() {
		return interactor.getTarget();
	}
}