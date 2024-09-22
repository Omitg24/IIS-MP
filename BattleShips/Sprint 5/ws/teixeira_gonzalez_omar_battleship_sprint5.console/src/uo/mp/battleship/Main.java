package uo.mp.battleship;

import uo.mp.battleship.console.ConsoleGamePresenter;
import uo.mp.battleship.console.ConsolePlayerInteractor;
import uo.mp.battleship.console.ConsoleSessionInteractor;
import uo.mp.battleship.ranking.GameRanking;
import uo.mp.battleship.session.GameSession;
import uo.mp2021.util.log.FileSimpleLogger;

/**
 * Titulo: Main
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public class Main {
	/**
	 * Constante fichero ranking
	 */
	private static final String RANKING_FILE = "battleship.rnk";
	/**
	 * Constante fichero log
	 */
	private static final String LOG_FILE = "battleship.log";

	/**
	 * Atributo session
	 */
	private GameSession session;

	/**
	 * Método que ejecuta el programa
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
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ WELCOME TO BATTLESHIPS! ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("I hope you enjoy!\n");
		session = new GameSession();
		session.setSessionInteractor( new ConsoleSessionInteractor());
		session.setGameInteractor( new ConsolePlayerInteractor());
		session.setGamePresenter( new ConsoleGamePresenter());
		session.setLogger( new FileSimpleLogger(LOG_FILE));
		session.setGameRanking( new GameRanking(RANKING_FILE) );
		return this;
	}
	
	/**
	 * Método que lanza el programa
	 */
	private void run() {
		session.run();
	}

}
