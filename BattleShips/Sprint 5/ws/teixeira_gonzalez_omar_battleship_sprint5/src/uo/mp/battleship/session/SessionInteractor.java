package uo.mp.battleship.session;

import java.util.List;

import uo.mp.battleship.ranking.Score;

/**
 * Titulo: Interfaz SessionInteractor
 * 
 * Descripci�n: Interfaz que almacena los m�todos a implementar en 
 * ConsoleSessionInteractor
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public interface SessionInteractor {
	
	/**
	 * M�todo que pregunta el nivel de dificultad
	 * 
	 * @return gameLevel, nivel de dificultad
	 */
	GameLevel askGameLevel();
	
	/**
	 * M�todo que pregunta por el nombre de usuario
	 * 
	 * @return userName, nombre de usuario
	 */
	String askUserName();
	
	/**
	 * M�todo que pregunta por la siguiente opcion a realizar
	 * 
	 * @return option, opcion
	 */
	int askNextOption();
	
	/**
	 * M�todo que pregunta por el modo de juego que se busca
	 * 
	 * @return true, si es modo Debug
	 */
	boolean askDebugMode();
	
	/**
	 * M�todo que pregunta si se quiere guardar la puntuaci�n obtenida
	 * 
	 * @return true, si se quiere guardar
	 */
	boolean doYouWantToRegisterYourScore();
	
	/**
	 * M�tood que muestra la lista de ranking total
	 * 
	 * @param ranking, lista de ranking
	 */
	void showRanking(List<Score> ranking);
	
	/**
	 * M�toodo que muestra la lista de ranking personal
	 * 
	 * @param ranking, lista de ranking personal
	 */
	void showPersonalRanking(List<Score> ranking);
	
	/**
	 * M�todo que muestra el mensaje de error
	 * 
	 * @param message, mensaje a mostrar
	 */
	void showErrorMessage(String message);
	
	/**
	 * M�todo que muestra el mensaje de error fatal
	 * 
	 * @param message, mensaje a mostrar
	 */
	void showFatalErrorMessage(String message);
}
