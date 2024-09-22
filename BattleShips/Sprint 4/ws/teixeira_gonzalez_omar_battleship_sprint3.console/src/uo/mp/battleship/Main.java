package uo.mp.battleship;

import uo.mp.battleship.console.ConsoleGamePresenter;
import uo.mp.battleship.console.ConsolePlayerInteractor;
import uo.mp.battleship.game.Game;
import uo.mp.battleship.interaction.GamePresenter;
import uo.mp.battleship.interaction.RandomInteractor;
import uo.mp.battleship.player.Player;

/**
 * Titulo: Clase Main
 * 
 * Descripción: Clase que ejecuta el programa
 * 
 * @author Omitg
 * @version 24-03-2021
 */
public class Main {
	/**
	 * Constante por defecto
	 */
	public static final int DEFAULT=10;
	
	/**
	 * Atributo game
	 */
	private Game game;	 
	
	/**
	 * Método estatico que lanza el programa
	 * 
	 * @param args, argumento a analizar
	 */
	public static void main(String[] args) {
		new Main()
			.configure()
			.run();
	}
	
	/**
	 * Método que configura el algoritmo
	 * 
	 * @return this, app configurada
	 */
	private Main configure() {
		// Create presenter and interactors to act as game interface 
		ConsolePlayerInteractor consoleInteractor = new ConsolePlayerInteractor(); 
		RandomInteractor randomInteractor = new RandomInteractor( DEFAULT ); 
		GamePresenter presenter = new ConsoleGamePresenter();
		
		// create players and game
		Player user = new Player("User");
		Player computer = new Player("Computer");
		game = new Game( user, computer, DEFAULT );
		
		// Set presenter and interactors
		user.setInteractor( consoleInteractor );
		computer.setInteractor( randomInteractor );
		game.setPresenter( presenter );
		return this;
	}

	/**
	 * Método que lanza el programa
	 */
	private void run() {
		game.play();
	}
}
