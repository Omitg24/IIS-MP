package uo.mp.newsstand.service.serializers;

import java.util.ArrayList;
import java.util.List;
import uo.mp.newsstand.domain.Order;

/**
 * Titulo: Clase OrderSerializer
 * 
 * @author Omitg
 * @version 07-04-2021
 */
public class OrderSerializer {

	/**
	 * Returns a list of String out of a list of Orders
	 * @param orders, the list of orders to convert
	 * @return a list of String-serialized orders
	 */
	public List<String> serialize(List<Order> orders) {
		List<String> result = new ArrayList<String>();
		for (Order order: orders) {
			result.add(order.serialize());
		}
		return result;
	}
}
