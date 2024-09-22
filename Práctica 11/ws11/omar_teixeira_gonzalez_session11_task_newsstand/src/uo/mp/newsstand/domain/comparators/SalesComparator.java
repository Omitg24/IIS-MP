package uo.mp.newsstand.domain.comparators;

import java.util.Comparator;

import uo.mp.newsstand.domain.Publication;

/**
 * Titulo: Clase SalesComparator
 * 
 * @author Omitg
 * @version 22-04-2021
 */
public class SalesComparator implements Comparator<Publication> {

	/**
	 * Método que compara dos publicaciones
	 * 
	 * @return dif, diferencia entre las publicaciones
	 */
	@Override
	public int compare(Publication o1, Publication o2) {
		int dif = o1.getSales() - o2.getSales();
		return dif;
	}
}
