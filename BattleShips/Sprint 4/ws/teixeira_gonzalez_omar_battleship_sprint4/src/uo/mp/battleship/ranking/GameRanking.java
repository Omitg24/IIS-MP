package uo.mp.battleship.ranking;

import java.util.ArrayList;
import java.util.List;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: CLase GameRanking
 * 
 * Descripci�n: Clase que almacena la lista de puntuaciones
 * 
 * @author Omitg
 * @version 16-04-2021
 */
public class GameRanking {
	/**
	 * Atributo ranking
	 */
	private List<Score> ranking = new ArrayList<Score>(); 
	
	/**
	 * M�todo que a�ade puntuaciones a la lista
	 * 
	 * @param score, puntuacion a a�adir
	 */
	public void append(Score score) {
		ArgumentChecks.isTrue(score!=null);
		ranking.add(score);
	}
	
	/**
	 * M�todo que devuelve una copia de la lista de puntuaciones
	 * 
	 * @return list, lista de puntuaciones
	 */
	public List<Score> getRanking(){
		return new ArrayList<Score>(ranking);
	}
	
	/**
	 * M�todo que devuelve una lista con las puntuaciones del usuario pasado 
	 * como parametro
	 * 
	 * @param userName, usuario
	 * @return scoresFor, lista con las puntuaciones del usuario
	 */
	public List<Score> getRankingFor(String userName) {
		ArgumentChecks.isTrue(userName!=null && !userName.trim().isEmpty());
		List<Score> scoresFor = new ArrayList<Score>();
		for (Score userScore : ranking) {
			if (userScore.getUserName().equals(userName)) {
				scoresFor.add(userScore);
			}
		}
		return scoresFor;
	}
}
