package uo.mp.battleship.game;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.BoardBuilder;
import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.interaction.ConsoleInteraction;
import uo.mp.battleship.player.ComputerPlayer;
import uo.mp.battleship.player.HumanPlayer;
import uo.mp.battleship.player.Player;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase Game
 *  
 * @author Omitg
 * @version 07-03-2021
 */
public class Game {
//Constantes:
	/**
	 * Tama�o por defecto
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
	 * Constructor con par�metros human y computer que crea a los jugadores
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
	 * Constructor con par�metros human y computer que crea a los jugadores
	 * 
	 * @param human, persona que jugara contra el ordenador
	 * @param computer, el ordenador que jugara contra la persona
	 * @param size, tama�o de los tableros
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
	 * M�todo que modifica el valor del atributo mode
	 * 
	 * @param mode, modo de juego
	 */
	public void setDebugMode ( boolean mode ) {
		this.mode=mode;
	}
	
	/**
	 * M�todo que devuelve el valor del atributo mode
	 * 
	 * @return mode, modo de juego
	 */
	public boolean getDebugMode() {
		return mode;
	}
	
	/**
	 * M�todo que devuelve el valor del atributo human
	 * 
	 * @return human, jugador humano
	 */
	public Player getHuman() {
		return human;
	}

	/**
	 * M�todo que modifica el valor del atributo human
	 * 
	 * @param human, jugador humano
	 */
	public void setHuman(HumanPlayer human) {
		this.human = human;
	}

	/**
	 * M�todo que devuelve el valor del atributo computer
	 * 
	 * @return computer, ordenador
	 */
	public Player getComputer() {
		return computer;
	}

	/**
	 * M�todo que modifica el valor del atributo computer
	 * 
	 * @param computer, ordenador
	 */
	public void setComputer(ComputerPlayer computer) {
		this.computer = computer;
	}
	
	/**
	 * M�todo que inicia el juego
	 */
	public void play() {
		TurnSelector selector = new TurnSelector(human, computer);		
		while (true) {			
			while (selector.getTurn()) {				
				ConsoleInteraction.showGameStatus(human.getMyShips(), 
						computer.getMyShips(), NORMAL_MODE);
				if (human.getMyShips().isFleetSunk() || computer.getMyShips().isFleetSunk()) {
					System.out.println("\t\t       PLAYER WINS!");
					break;
				}
				Coordinate coordsHuman = human.makeChoice();				
				int shots = human.shootAt(coordsHuman);
				if (shots==2){
					System.out.println("\t\t       Hit and Sunk!");	
					selector.repeat();
				} else if (shots==1) {
					System.out.println("\t\t           Hit!");
					selector.repeat();
				} else if (shots==0){
					System.out.println("\t\t          Miss!");
					selector.next();
				}				
			}			
			while (!selector.getTurn()){			
				ConsoleInteraction.showGameStatus(human.getMyShips(), 
						computer.getMyShips(), NORMAL_MODE);
				if (human.getMyShips().isFleetSunk() || computer.getMyShips().isFleetSunk()) {
					System.out.println("\t\t       COMPUTER WINS!");
					break;
				}	
				Coordinate coordsComputer = computer.makeChoice();							
				int shots = computer.shootAt(coordsComputer);
				if (shots==2){
					System.out.println("\t\t       Hit and Sunk!");
					selector.repeat();
				} else if (shots==1) {
					System.out.println("\t\t           Hit!");
					selector.repeat();
				} else if (shots==0){
					System.out.println("\t\t          Miss!");
					selector.next();
				}			
			}	
			if (human.getMyShips().isFleetSunk() || computer.getMyShips().isFleetSunk()) {
				
				break;
			}
		}		
	}
}