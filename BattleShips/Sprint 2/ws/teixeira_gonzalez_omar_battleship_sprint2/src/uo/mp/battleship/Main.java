package uo.mp.battleship;

import uo.mp.battleship.game.Game;
import uo.mp.battleship.player.ComputerPlayer;
import uo.mp.battleship.player.HumanPlayer;

/**
 * Titulo: Clase Main
 * 
 * Descripción: Clase que ejecuta el proyecto Battleships
 * 
 * @author Omitg
 * @version 07-03-2021
 */
public class Main {
//Atributos:
	/**
	 * Atributo game
	 */
	private Game game;
	
	/**
	 * Método que lanza el programa 
	 * 
	 * @param args, argumento a analizar
	 */
	public static void main(String[] args) {
		new Main()
			.configure()
			.run();		
	}
	
	/**
	 * Método que configura el juego
	 * 
	 * @return this, la configuración
	 */
	private Main configure() {
		System.out.println("---------------------- BATTLESHIPS ----------------------");
		HumanPlayer user = new HumanPlayer("User");
		ComputerPlayer computer = new ComputerPlayer("Computer");
		game = new Game(user, computer);
		return this;
	}
		
	/**
	 * Método que ejecuta el programa
	 */
	private void run() {
		game.play();
	}
}
