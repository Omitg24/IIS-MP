package uo.mp.battleship.session;

import java.util.List;

import uo.mp.battleship.ranking.Score;

/**
 * Titulo: Interfaz SessionInteractor
 * 
 * Descripción: Interfaz que almacena los métodos a implementar en 
 * ConsoleSessionInteractor
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public interface SessionInteractor {
	
	/**
	 * Método que pregunta el nivel de dificultad
	 * 
	 * @return gameLevel, nivel de dificultad
	 */
	GameLevel askGameLevel();
	
	/**
	 * Método que pregunta por el nombre de usuario
	 * 
	 * @return userName, nombre de usuario
	 */
	String askUserName();
	
	/**
	 * Método que pregunta por la siguiente opcion a realizar
	 * 
	 * @return option, opcion
	 */
	int askNextOption();
	
	/**
	 * Método que pregunta por el modo de juego que se busca
	 * 
	 * @return true, si es modo Debug
	 */
	boolean askDebugMode();
	
	/**
	 * Método que pregunta si se quiere guardar la puntuación obtenida
	 * 
	 * @return true, si se quiere guardar
	 */
	boolean doYouWantToRegisterYourScore();
	
	/**
	 * Métood que muestra la lista de ranking total
	 * 
	 * @param ranking, lista de ranking
	 */
	void showRanking(List<Score> ranking);
	
	/**
	 * Métoodo que muestra la lista de ranking personal
	 * 
	 * @param ranking, lista de ranking personal
	 */
	void showPersonalRanking(List<Score> ranking);
	
	/**
	 * Método que muestra el mensaje de error
	 * 
	 * @param message, mensaje a mostrar
	 */
	void showErrorMessage(String message);
	
	/**
	 * Método que muestra el mensaje de error fatal
	 * 
	 * @param message, mensaje a mostrar
	 */
	void showFatalErrorMessage(String message);
}
