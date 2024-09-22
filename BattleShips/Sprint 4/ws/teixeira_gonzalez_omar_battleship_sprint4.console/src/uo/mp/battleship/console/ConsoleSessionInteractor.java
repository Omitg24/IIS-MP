package uo.mp.battleship.console;

import java.io.IOException;
import java.util.List;

import uo.mp.battleship.ranking.Score;
import uo.mp.battleship.session.GameLevel;
import uo.mp.battleship.session.SessionInteractor;
import uo.mp.battleship.util.IO;
import uo.mp2021.util.checks.ArgumentChecks;
import uo.mp2021.util.log.ConsoleSimpleLogger;

/**
 * Titulo: Clase ConsoleSessionInteractor 
 * 
 * Descripción: Clase que crea los métodos para proporcionar entrada 
 * y salida del usuario
 * 
 * @author Omitg
 * @version 16-04-2021
 */
public class ConsoleSessionInteractor implements SessionInteractor{	
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
	/**
	 * Atributo Logger
	 */
	private ConsoleSimpleLogger logger = new ConsoleSimpleLogger();
	/**
	 * Método que pregunta el nivel de dificultad
	 * 
	 * @return gameLevel, nivel de dificultad
	 */
	@Override
	public GameLevel askGameLevel() {			
		System.out.println("Level? (S)ea, (O)cean, (P)lanet");
		
		String gameLevel = inputKeyboard().toUpperCase();
		
		while (!gameLevel.equals("S") && !gameLevel.equals("O") && 
				!gameLevel.equals("P")) {
			System.out.println("Please, select a valid level!");
			gameLevel = inputKeyboard();
		}
		
		if (gameLevel.equals("S")) {
			return GameLevel.SEA;
		} else if (gameLevel.equals("O")) {
			return GameLevel.OCEAN;
		} else {
			return GameLevel.PLANET;
		}
	}
	
	/**
	 * Método que pregunta por el nombre de usuario
	 * 
	 * @return userName, nombre de usuario
	 */
	@Override
	public String askUserName() {
		System.out.println("Player name?");
		String name = inputKeyboard();
		return name;
	}
	
	/**
	 * Método que pregunta por la siguiente opcion a realizar
	 * 
	 * @return option, opcion
	 */
	@Override
	public int askNextOption() {
		System.out.println("Available options:");
		System.out.println("   1- Play a new game\n"
						 + "   2- Show my results\n"
						 + "   3- Show all results\n"
						 + "   0- Exit\n"
						 + "Option? ");
		int option = IO.readInt();
		while (option!=PLAY && option!=SHOW_MY && option!=SHOW_ALL && option!=EXIT) {
			System.out.println("Please, select a valid option!");
			option = IO.readInt();
		}
		return option;
	}
	
	/**
	 * Método que pregunta por el modo de juego que se busca
	 * 
	 * @return true, si es modo Debug
	 */
	@Override
	public boolean askDebugMode() {
		System.out.println("Do you want to play in debug mode? (y)es, (n)o");
		
		String answer = inputKeyboard().toLowerCase();
		while (!answer.equals("y") && !answer.equals("n")) {
			System.out.println("Please, select a valid answer!");
			answer = inputKeyboard();
		}		
		return answer.equals("y") ? true : false;
	}
	
	/**
	 * Método que pregunta si se quiere guardar la puntuación obtenida
	 * 
	 * @return true, si se quiere guardar
	 */
	@Override
	public boolean doYouWantToRegisterYourScore() {
		System.out.println("Do you want to store your score? (y)es, (n)o");
		
		String answer = inputKeyboard().toLowerCase();
		while (!answer.equals("y") && !answer.equals("n")) {
			System.out.println("Please, select a valid answer!");
			answer = inputKeyboard();
		}
		
		return answer.equals("y") ? true : false;
	}

	/**
	 * Métood que muestra la lista de ranking total
	 * 
	 * @param rankings, lista de ranking
	 */
	@Override
	public void showRanking(List<Score> rankings) {
		ArgumentChecks.isTrue(rankings!=null);
		System.out.println("\nShow all results!");
		System.out.println("Result: Won!");
		System.out.println("UserName   .Date     .Hour    .Level  .Time");				
		try {
			for (Score score : rankings){
				String s = String.format("%-10.10s %td/%<tm/%<tY %<tT %-6.6s %4d", 
						score.getUserName(), 
						score.getDate(), 
						score.getLevel(),						
						score.getTime());
				System.out.println(s);
			}
			System.out.println();
		} catch (RuntimeException e) {
			handleException(e);
		}
	}

	/**
	 * Métoodo que muestra la lista de ranking personal
	 * 
	 * @param rankings, lista de ranking personal
	 */
	@Override
	public void showPersonalRanking(List<Score> rankings) {
		ArgumentChecks.isTrue(rankings!=null);
		System.out.println("\nShow my result!");
		System.out.println("Result: Won!");
		System.out.println("Date       .Hour    .Level .Time");
		try {
			for (Score score : rankings) {
				String s = String.format("%td/%<tm/%<tY %<tT %-6.6s %4d",
						score.getDate(),
						score.getLevel(),
						score.getTime());
				System.out.println(s);
			}
			System.out.println();
		} catch (RuntimeException e) {
			handleException(e);
		}
	}
	
	/**
	 * Método que maneja la excepción
	 * 
	 * @param e, excepción
	 */
	private void handleException(RuntimeException e) {
		showErrorMessage(e.getMessage());
		logger.log(e);
	}

	/**
	 * Método que muestra el mensaje de error
	 * 
	 * @param message, mensaje a mostrar
	 */
	@Override
	public void showErrorMessage(String message) {
		System.out.println("There has been a problem processing your option");
		System.out.println(message);		
		System.out.println("Please, try it again.");
	}
	
	/**
	 * Método que muestra el mensaje de error fatal
	 * 
	 * @param message, mensaje a mostrar
	 */
	@Override
	public void showFatalErrorMessage(String message) {
		System.out.println("There has been a technical problem");
		System.out.println(message);		
		System.out.println("The program has to stop.");
	}
	
	/**
	 * Método que registra la entrada por teclado
	 * 
	 * @return String, entrada por teclado en formato String
	 * @throws IOException 
	 */
	private String inputKeyboard(){
		String input = null;		
		try {
			input = IO.keyboard();
		} catch (IOException e) {
			showErrorMessage(e.getMessage());
			logger.log(e);
		}		
		return input;
	}	
}
