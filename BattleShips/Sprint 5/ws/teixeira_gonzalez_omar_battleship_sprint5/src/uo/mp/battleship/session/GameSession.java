package uo.mp.battleship.session;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import uo.mp.battleship.game.Game;
import uo.mp.battleship.interaction.GameInteractor;
import uo.mp.battleship.interaction.GamePresenter;
import uo.mp.battleship.interaction.RandomInteractor;
import uo.mp.battleship.player.Player;
import uo.mp.battleship.ranking.GameRanking;
import uo.mp.battleship.ranking.Score;
import uo.mp2021.util.checks.ArgumentChecks;
import uo.mp2021.util.log.SimpleLogger;
/**
 * Titulo: Clase GameSession
 * 
 * Descripción: Clase que crea la sesion del juego
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public class GameSession {
//Constantes:	
	/**
	 * Constante play
	 */
	public static final int PLAY = 1;
	/**
	 * Constante show my
	 */
	public static final int SHOW_MY=2;
	/**
	 * Constante show all
	 */
	public static final int SHOW_ALL=3;
	/**
	 * Constante exit
	 */
	public static final int EXIT=0;
//Atributos:			
	/**
	 * Atributo interactorGamer
	 */
	private GameInteractor interactorGame;
	/**
	 * Atributo presenterGame
	 */
	private GamePresenter presenterGame;
	/**
	 * Atributo interactorSession
	 */
	private SessionInteractor interactorSession;
	/**
	 * Atributo logger
	 */
	private SimpleLogger simpleLogger;
	/**
	 * Atributo ranking
	 */
	private GameRanking gameRanking;
	/**
	 * Atributo name
	 */	
	private String name;
	/**
	 * Atributo gameLevel
	 */	
	private GameLevel gameLevel;
	
	/**
	 * Método que corre el programa
	 */
	public void run() {
		try {
			fullSession();		
		} catch (FileNotFoundException e) {
			simpleLogger.log(e);
		} catch (ClassNotFoundException e) {
			simpleLogger.log(e);
		} catch (IOException e) {
			simpleLogger.log(e);
		} catch (RuntimeException e) {
			handleFatalErrorException(e);
		}
	}
		
	/**
	 * Método que lee la lista de puntuaciones 
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readRanking() throws FileNotFoundException, IOException, ClassNotFoundException {
		try {
			ObjectInputStream input = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(gameRanking.getRankingFile())));
			GameRanking grank = (GameRanking) input.readObject();
			gameRanking.appendListOfScores(grank.getRanking());
			input.close();
		} catch (EOFException e) {
			simpleLogger.log(e);
		}
		
	}		
	
	/**
	 * Método que reescribe el ranking
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void rewriteRanking() throws FileNotFoundException, IOException {
		ObjectOutputStream output = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(gameRanking.getRankingFile())));
		output.writeObject(gameRanking);
		output.close();
	}
	
	/**
	 * Método que implementa una sesión completa
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	private void fullSession() throws FileNotFoundException, ClassNotFoundException, IOException {
		readRanking();
		name = interactorSession.askUserName();
		int option;		
		do {						
			option = choiceMenuOption();			
		} while (option!=EXIT);
	}
	
	/**
	 * Método que manda escoger la opción del programa
	 * 
	 * @return option, opcion
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws NumberFormatException
	 */
	private int choiceMenuOption() throws FileNotFoundException, IOException {
		int option = interactorSession.askNextOption();		
		switch(option) {
		case EXIT:
			System.out.println("\n¡¡¡ THE GAME HAS ENDED !!!");			
			break;
		case PLAY:
			play();				
			break;
		case SHOW_MY:
			interactorSession.showPersonalRanking(gameRanking.getRankingFor(name));
			break;
		case SHOW_ALL:
			interactorSession.showRanking(gameRanking.getRanking());
			break;
		}
		return option;		
	}
	
	/**
	 * Método que crea lo necesario para que se juegue la partida
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private void play() throws FileNotFoundException, IOException {
		int level = levelSelect();
		boolean mode = interactorSession.askDebugMode();			
		Player player = new Player(name);
		Player computer = new Player("Computer");
		Game game = new Game(player, computer, level);	
		player.setInteractor(interactorGame);
		computer.setInteractor(new RandomInteractor(level));
		game.setPresenter(presenterGame);
		game.setDebugMode(mode);
		game.play();
		
		storeScore(gameLevel, game);
	}
	
	/**
	 * Método que selecciona el nivel a jugar
	 * 
	 * @return int, nivel a jugar
	 */
	private int levelSelect() {
		int size;
		gameLevel = interactorSession.askGameLevel();
		switch(gameLevel) {
		case SEA:
			size=10;
			break;
		case OCEAN:
			size=15;
			break;
		case PLANET:
			size=20;
			break;
		default:
			throw new RuntimeException("Internal error");
		} 
		return size;
	}	
	
	/**
	 * Método que almacena una puntuación en la lista de puntuaciones
	 * 
	 * @param level, nivel del juego
	 * @param game, partida
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private void storeScore(GameLevel level, Game game) throws FileNotFoundException, IOException {
		boolean vote = interactorSession.doYouWantToRegisterYourScore();
		if (vote) {						
			gameRanking.append(new Score(name, level, game.getTime()));
			rewriteRanking();
		}
	}
	
	/**
	 * Método que maneja la excepción
	 *  
	 * @param e, excepción
	 */
	private void handleFatalErrorException(RuntimeException e) {
		interactorSession.showFatalErrorMessage(e.getMessage());
		simpleLogger.log(e);
	}
	
	/**
	 * Método que asigna al atributo interactorSession el parámetro interactor
	 * 
	 * @param interactor, interactor
	 */
	public void setSessionInteractor(SessionInteractor interactor) {
		ArgumentChecks.isTrue(interactor!=null, 
				"SessionInteractor no cumple los parámetros");
		this.interactorSession=interactor;
	}
	
	/**
	 * Método que asigna al atributo interactorGame el parámetro interactor
	 * 
	 * @param interactor, interactor
	 */
	public void setGameInteractor(GameInteractor interactor) {
		ArgumentChecks.isTrue(interactor!=null, "GameInteractor no cumple los parámetros");
		this.interactorGame=interactor;
	}
		
	/**
	 * Método que asigna al atributo presenterGame el parámetro presenter
	 * 
	 * @param presenter, presentador
	 */
	public void setGamePresenter(GamePresenter presenter) {
		ArgumentChecks.isTrue(presenter!=null, "GamePresenter no cumple los parámetros");
		this.presenterGame=presenter;
	}
	
	/**
	 * Nétodo que asigna al atributo simpleLogger el parámetro logger
	 * 
	 * @param logger, logger
	 */
	public void setLogger(SimpleLogger logger) {
		ArgumentChecks.isTrue(logger!=null, "SimpleLogger no cumple los parámetros");
		this.simpleLogger=logger;
	}
	
	/**
	 * Método que asigna al atributo gameRanking el parámetro ranking
	 * 
	 * @param ranking, puntuacion
	 */
	public void setGameRanking(GameRanking ranking) {
		ArgumentChecks.isTrue(ranking!=null, "GameRanking no cumple los parámetros");
		this.gameRanking=ranking;
	}	
}
