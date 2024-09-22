package uo.mp.battleship.game;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.BoardBuilder;
import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.interaction.GamePresenter;
import uo.mp.battleship.player.Player;
import uo.mp2021.util.checks.ArgumentChecks;
import uo.mp2021.util.checks.StateChecks;

/**
 * Titulo: Clase Game
 *  
 * Descripción: Clase que lanza el juego
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public class Game {
//Constantes:
	/**
	 * Tamaño por defecto
	 */
	public static final int DEFAULT_SIZE = 10;	
	/**
	 * Modo normal
	 */
	public static final boolean NORMAL_MODE = false;	
	/**
	 * Modo debug
	 */
	public static final boolean DEBUG_MODE = true;	
//Atributos	
	/**
	 * Atributo humano
	 */
	private Player human;	
	/**
	 * Atributo ordenador
	 */
	private Player computer;	
	/**
	 * Atributo modo
	 */
	private boolean mode;	
	/**
	 * Atributo presentador
	 */
	private GamePresenter presenter;	
	/**
	 * Atributo tiempo
	 */
	private int time;
	
	/**
	 * Constructor con parámetros human y computer que crea a los jugadores
	 * 
	 * @param user, persona que jugara contra el ordenador
	 * @param computer, el ordenador que jugara contra la persona
	 */
	public Game(Player user, Player computer) {
		ArgumentChecks.isTrue(user!=null && computer!=null, 
				"Los parametros no cumplen los requisitos");
		Board boardH = new Board(DEFAULT_SIZE);
		Board boardC = new Board(DEFAULT_SIZE);
		
		setHuman(user);
		setComputer(computer);
		
		user.setMyShips(boardH);
		user.setOpponentShips(boardC);
		
		computer.setMyShips(boardC);
		computer.setOpponentShips(boardH);
		
		setDebugMode(NORMAL_MODE);
	}
	
	/**
	 * Constructor con parámetros human y computer que crea a los jugadores
	 * 
	 * @param user, persona que jugara contra el ordenador
	 * @param computer, el ordenador que jugara contra la persona
	 * @param size, tamaño de los tableros
	 */
	public Game(Player user, Player computer, int size) {	
		ArgumentChecks.isTrue(user!=null && computer!=null && 
				size>=BoardBuilder.MIN_SIZE && size<=BoardBuilder.MAX_SIZE, 
				"Los parametros no cumplen los requisitos");
		
		Board boardH = new Board(size);
		Board boardC = new Board(size);		
		
		setHuman(user);
		setComputer(computer);			
		
		user.setMyShips(boardH);
		user.setOpponentShips(boardC);		
		
		computer.setMyShips(boardC);
		computer.setOpponentShips(boardH);
		
		setDebugMode(NORMAL_MODE);
	}	
	
	/**
	 * Método que modifica el valor del atributo mode
	 * 
	 * @param mode, modo de juego
	 */
	public void setDebugMode ( boolean mode ) {
		this.mode=mode;
	}
	
	/**
	 * Método que devuelve el valor del atributo mode
	 * 
	 * @return mode, modo de juego
	 */
	public boolean getDebugMode() {
		return mode;
	}
	
	/**
	 * Método que devuelve el valor del atributo human
	 * 
	 * @return human, jugador humano
	 */
	public Player getHuman() {
		return human;
	}

	/**
	 * Método que modifica el valor del atributo human
	 * 
	 * @param user, jugador humano
	 */
	public void setHuman(Player user) {
		this.human = user;
	}

	/**
	 * Método que devuelve el valor del atributo computer
	 * 
	 * @return computer, ordenador
	 */
	public Player getComputer() {
		return computer;
	}

	/**
	 * Método que modifica el valor del atributo computer
	 * 
	 * @param computer, ordenador
	 */
	public void setComputer(Player computer) {
		this.computer = computer;
	}
	
	/**
	 * Método que modifica el valor del atributo presenter
	 * 
	 * @param arg, nuevo presenter
	 */
	public void setPresenter(GamePresenter arg) {
		ArgumentChecks.isTrue(arg!=null, "El argumento no cumple los requisitos");
		this.presenter=arg;
	}
	
	/**
	 * Método que devuelve el tiempo que ha transcurrido entre el inicio y la
	 * finalización del juego
	 * 
	 * @return time, tiempo
	 */
	public long getTime() {		
		return time;
	}	
	
	/**
	 * Método que inicia el juego
	 */
	public void play() {		
		StateChecks.isTrue(presenter!=null, "No se ha invocado al método setPresenter");
		TurnSelector selector = new TurnSelector(human, computer);			
		int initial = (int) System.currentTimeMillis();
		while (true) {			
			while (selector.getTurn()) {				
				presenter.showGameStatus(human.getMyShips(), computer.getMyShips(), getDebugMode());
				if (human.getMyShips().isFleetSunk() || computer.getMyShips().isFleetSunk()) {
					presenter.showGameOver();
					presenter.showWinner(human);
					time = (int) System.currentTimeMillis() - initial;
					break;
				}
				shootHuman(selector);		
			}			
			while (!selector.getTurn()){				
				presenter.showGameStatus(human.getMyShips(), computer.getMyShips(), getDebugMode());
				if (human.getMyShips().isFleetSunk() || computer.getMyShips().isFleetSunk()) {
					presenter.showGameOver();
					presenter.showWinner(computer);
					time = (int) System.currentTimeMillis() - initial;
					break;
				}
				shootComputer(selector);
			}	
			if (human.getMyShips().isFleetSunk() || computer.getMyShips().isFleetSunk()) {	
				time = (int) System.currentTimeMillis() - initial;
				break;
			}
		}
	}
	
	/**
	 * Método que se encarga de la partida del humano
	 */
	private void shootHuman(TurnSelector selector) {			
		Coordinate coordsHuman = human.getTarget();
		int size = human.getOpponentShips().getSize();
		int[][] opponentBoard = human.getOpponentShips().getBoard();
		while (coordsHuman.getRow()>=size || coordsHuman.getCol()>=size || 
				opponentBoard[coordsHuman.getRow()][coordsHuman.getCol()]==-1) {
			System.out.println("\n -> ATTENTION! Introduce a valid coordinate!");
			coordsHuman = human.getTarget();
		}
		presenter.showShootingAt(coordsHuman);
		int shots = human.shootAt(coordsHuman);
		if (shots==2){
			presenter.showHitOrMiss(shots);
			presenter.showTurn(human);
			selector.repeat();
		} else if (shots==1) {
			presenter.showHitOrMiss(shots);
			presenter.showTurn(human);
			selector.repeat();
		} else if (shots==0){
			presenter.showHitOrMiss(shots);
			presenter.showTurn(computer);
			selector.next();
		}		
	}
	
	/**
	 * Método que se encarga de la partida del computer
	 */
	private void shootComputer(TurnSelector selector) {	
		Coordinate coordsComputer = computer.getTarget();		
		presenter.showShootingAt(coordsComputer);
		int shots = computer.shootAt(coordsComputer);
		if (shots==2){
			presenter.showHitOrMiss(shots);
			presenter.showTurn(computer);
			selector.repeat();
		} else if (shots==1) {
			presenter.showHitOrMiss(shots);
			presenter.showTurn(computer);
			selector.repeat();
		} else if (shots==0){
			presenter.showHitOrMiss(shots);
			presenter.showTurn(human);
			selector.next();
		}
	}
}