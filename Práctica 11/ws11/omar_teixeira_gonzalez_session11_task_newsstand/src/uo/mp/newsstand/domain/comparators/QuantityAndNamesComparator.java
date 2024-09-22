package uo.mp.newsstand.domain.comparators;

import java.util.Comparator;

import uo.mp.newsstand.domain.Order;

/**
 * Titulo: Clase QuantityAndNamesComparator
 * 
 * @author Omitg
 * @version 22-04-2021
 */
public class QuantityAndNamesComparator implements Comparator<Order> {

	/**
	 * Método que compara dos pedidos
	 * 
	 * @return dif, diferencia entre los pedidos
	 */
	@Override
	public int compare(Order o1, Order o2) {
		int dif = o1.getQuantity() - o2.getQuantity();
		if (dif == 0) {
			dif = o1.getName().compareTo(o2.getName());
		}
		return dif;
	}

}
