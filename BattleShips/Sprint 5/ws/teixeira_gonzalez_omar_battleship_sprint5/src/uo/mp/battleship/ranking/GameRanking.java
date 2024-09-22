package uo.mp.battleship.ranking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: CLase GameRanking
 * 
 * Descripci�n: Clase que almacena la lista de puntuaciones
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public class GameRanking implements Serializable{
	/**
	 *  Constante serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo ranking
	 */
	private List<Score> ranking = new ArrayList<Score>(); 
	
	/**
	 * Atributo rankingFile
	 */
	private String rankingFile;
	
	/**
	 * Constructor con par�metro rankingFile
	 * 
	 * @param rankingFile, fichero
	 */
	public GameRanking(String rankingFile) {
		ArgumentChecks.isTrue(rankingFile!=null && !rankingFile.trim().isEmpty(), 
				"El fichero no es v�lido");
		this.rankingFile = rankingFile;
	}	
	
	/**
	 * M�todo que devuelve el fichero
	 * 
	 * @return rankingFile, fichero
	 */
	public String getRankingFile() {
		return rankingFile;
	}
	
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
	 * N�todo que a�ade una lista de puntuaciones
	 * 
	 * @param scores, puntuaciones a a�adir
	 */
	public void appendListOfScores(List<Score> scores) {
		ArgumentChecks.isTrue(scores!=null && !scores.isEmpty(), "La lista no es v�lida");
		for(Score s : scores) {
			append(s);
		}
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
