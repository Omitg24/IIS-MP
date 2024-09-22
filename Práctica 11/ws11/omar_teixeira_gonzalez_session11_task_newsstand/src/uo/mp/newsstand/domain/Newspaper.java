package uo.mp.newsstand.domain;

/**
 * Titulo: Clase Newspaper
 * 
 * @author Omitg
 * @version 07-04-2021
 */
public class Newspaper extends Publication {

	/**
	 * Constructor con parámetros nombre, stock y ventas
	 * 
	 * @param name,  nombre
	 * @param stock, stock
	 * @param sales, ventas
	 */
	public Newspaper(String name, int stock, int sales) {
		super(name, stock, sales);
	}

	/**
	 * Método que devuelve un pedido generado
	 * 
	 * @return order, pedido generado por el objeto
	 */
	@Override
	public Order generateOrders() {
		return new Order(getName(), getSales() + (getStock() * 2));
	}

	/**
	 * Método que devuelve el objeto en formato serie
	 * 
	 * @return formato serie del objeto
	 */
	@Override
	public String serialize() {
		return "revista" + "\t" + getName() + "\t" + getStock() + "\t" + getSales();
	}
}
