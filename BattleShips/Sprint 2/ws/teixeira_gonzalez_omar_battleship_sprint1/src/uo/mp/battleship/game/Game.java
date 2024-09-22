package uo.mp.battleship.game;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.BoardBuilder;
import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.interaction.ConsoleInteraction;
import uo.mp.battleship.player.ComputerPlayer;
import uo.mp.battleship.player.HumanPlayer;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase Game
 *  
 * @author Omitg
 * @version 12-02-20201
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
	private HumanPlayer human;
	
	/**
	 * Atributo ordenador
	 */
	private ComputerPlayer computer;
	
	/**
	 * Atributo modo
	 */
	private boolean mode;
	
	/**
	 * Constructor con parámetros human y computer que crea a los jugadores
	 * 
	 * @param human, persona que jugara contra el ordenador
	 * @param computer, el ordenador que jugara contra la persona
	 */
	public Game(HumanPlayer human, ComputerPlayer computer) {
		ArgumentChecks.isTrue(human!=null && computer!=null, 
				"Los parametros no cumplen los requisitos");
		Board boardH = new Board(DEFAULT_SIZE);
		Board boardC = new Board(DEFAULT_SIZE);
		
		setHuman(human);
		setComputer(computer);
		
		human.setMyShips(boardH);
		human.setOpponentShips(boardC);
		
		computer.setMyShips(boardC);
		computer.setOpponentShips(boardH);
		
		setDebugMode(NORMAL_MODE);
	}
	
	/**
	 * Constructor con parámetros human y computer que crea a los jugadores
	 * 
	 * @param human, persona que jugara contra el ordenador
	 * @param computer, el ordenador que jugara contra la persona
	 * @param size, tamaño de los tableros
	 */
	public Game(HumanPlayer human, ComputerPlayer computer, int size) {	
		ArgumentChecks.isTrue(human!=null && computer!=null && 
				size>=BoardBuilder.MIN_SIZE && size<=BoardBuilder.MAX_SIZE, 
				"Los parametros no cumplen los requisitos");
		Board boardH = new Board(size);
		Board boardC = new Board(size);
		
		setHuman(human);
		setComputer(computer);			
		
		human.setMyShips(boardH);
		human.setOpponentShips(boardC);
		
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
	public HumanPlayer getHuman() {
		return human;
	}

	/**
	 * Método que modifica el valor del atributo human
	 * 
	 * @param human, jugador humano
	 */
	public void setHuman(HumanPlayer human) {
		this.human = human;
	}

	/**
	 * Método que devuelve el valor del atributo computer
	 * 
	 * @return computer, ordenador
	 */
	public ComputerPlayer getComputer() {
		return computer;
	}

	/**
	 * Método que modifica el valor del atributo computer
	 * 
	 * @param computer, ordenador
	 */
	public void setComputer(ComputerPlayer computer) {
		this.computer = computer;
	}
	
	/**
	 * Método que inicia el juego
	 */
	public void play() {
		TurnSelector ts = new TurnSelector();
		int turn = ts.next();
		while (!human.hasWon() && !computer.hasWon()) {
			ConsoleInteraction.showGameStatus(human.getMyShips(), 
					computer.getMyShips(), NORMAL_MODE);
			if (turn==1) {			
				Coordinate coordsHuman = human.makeChoice();
				human.shootAt(coordsHuman);
				if (human.shootAt(coordsHuman)){
					System.out.println("\t\t       IMPACT: HIT");
				} else {
					System.out.println("\t\t       IMPACT: MISS");
				}
				turn=ts.next();				
			} else {
				Coordinate coordsComputer = computer.makeChoice();
				computer.shootAt(coordsComputer);			
				if (computer.shootAt(coordsComputer)){
					System.out.println("\t\t       IMPACT: HIT");
				} else {
					System.out.println("\t\t       IMPACT: MISS");
				}
				turn=ts.next();				
			}		
		}		
	}
}
