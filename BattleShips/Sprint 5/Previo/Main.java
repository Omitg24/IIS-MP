package uo.mp.battleship;

import uo.mp.battleship.console.ConsoleGamePresenter;
import uo.mp.battleship.console.ConsolePlayerInteractor;
import uo.mp.battleship.console.ConsoleSessionInteractor;
import uo.mp.battleship.ranking.GameRanking;
import uo.mp.battleship.session.GameSession;
import uo.mp.battleship.util.IO;
import uo.mp2021.util.log.ConsoleSimpleLogger;

/**
 * Titulo: Clase Main
 *  
 * @author Omitg
 * @version 16-04-2021
 */
public class Main {
	/**
	 * Atributo session 
	 */
	private GameSession session;

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
	 * Método que configura el programa
	 * 
	 * @return this, programa configurado
	 */
	private Main configure() {
		IO.display("¡¡¡ WELCOME TO BATTLESHIPS !!!");
		IO.display("I hope you enjoy the game!\n");
		session = new GameSession();
		session.setSessionInteractor( new ConsoleSessionInteractor() );
		session.setGameInteractor( new ConsolePlayerInteractor() );
		session.setGamePresenter( new ConsoleGamePresenter() );
		session.setLogger( new ConsoleSimpleLogger() );
		session.setGameRanking( new GameRanking() );
		return this;
	}

	/**
	 * Método que corre el programa
	 */
	private void run() {
		session.run();
	}


}
