package uo.mp.battleship.comparator;

import java.util.Comparator;

import uo.mp.battleship.ranking.Score;

/**
 * Titulo: Clase ScoresComparator
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public class ScoresComparator implements Comparator<Score>{

	/**
	 * Método que compara dos puntuaciones
	 */
	@Override
	public int compare(Score o1, Score o2) {
		int dif = o1.getLevel().compareTo(o2.getLevel());
		if (dif==0) {
			dif = (int) (o1.getTime() - o2.getTime());
			if (dif==0) {
				dif=o1.getDate().compareTo(o2.getDate());
			}
		}
		return dif;
	}

}
