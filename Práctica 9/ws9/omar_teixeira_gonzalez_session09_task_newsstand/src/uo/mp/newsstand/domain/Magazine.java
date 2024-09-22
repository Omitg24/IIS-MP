package uo.mp.newsstand.domain;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase Magazine
 * 
 * @author Omitg
 * @version 07-04-2021
 */
public class Magazine extends Publication {
//Constantes:
	/**
	 * Constante semanal
	 */
	public static int WEEKLY = 7;	
	/**
	 * Constante stock minimo
	 */
	public static int MIN_STOCK = 5;	
	/**
	 * Constante pedido minimo
	 */
	public static int MIN_ORDER = 20;
//Atributos:
	/**
	 * Atributo frecuencia
	 */
	private int frequency;
	
	/**
	 * Constructor con par�metros nombre, stock, ventas y frecuencia
	 * 
	 * @param name, nombre 
	 * @param stock, stock
	 * @param sales, ventas
	 * @param freq, frecuencia
	 */
	public Magazine(String name, int stock, int sales, int freq) {
		super(name, stock, sales);
		ArgumentChecks.isTrue( freq > 0);
		this.frequency = freq;
	}
	
	/**
	 * M�todo que devuelve el valor del atributo frecuencia
	 * 
	 * @return frequency, frecuencia de la revista
	 */
	public int getFrequency() {
		return frequency;
	}
	
	/**
	 * M�todo que devuelve una cadena de caracteres del objeto
	 * 
	 * @return cadena del objeto
	 */
	public String toString() {
		return super.toString() + "\t" + getFrequency();
	}

	/**
	 * M�todo que devuelve el objeto en formato serie
	 * 
	 * @return formato serie del objeto
	 */
	@Override
	public String serialize() {
		return "revista" 
				+ "\t" + getName() 
				+ "\t" + getStock() 
				+ "\t" + getSales() 
				+ "\t" + getFrequency();
	}
	
	/**
	 * M�todo que devuelve un pedido generado
	 * 
	 * @return order, pedido generado por el objeto
	 */
	@Override
	public Order generateOrders() {
		if (getStock() < MIN_STOCK) {
			return new Order(this.getName(), MIN_ORDER);
		} else {
			if (getFrequency() == WEEKLY) {
				return new Order(this.getName(), getSales());
			} else {
				return new Order(this.getName(), getSales() + getStock());
			}
		}
	}	
}
