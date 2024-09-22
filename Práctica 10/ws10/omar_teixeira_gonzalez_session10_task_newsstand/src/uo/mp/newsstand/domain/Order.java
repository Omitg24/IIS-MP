package uo.mp.newsstand.domain;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase Order
 * 
 * @author Omitg
 * @version 07-04-2021
 */
public class Order {
	/**
	 * Atributo nombre
	 */
	private String name;
	/**
	 * Atributo cantidad
	 */
	private int quantity;
	
	/**
	 * Constructor de pedidos con par�metros nombre y cantidad
	 *  
	 * @param name, nombre
	 * @param quantity, cantidad
	 */
	public Order(String name, int quantity){
		ArgumentChecks.isTrue( name != null );
		ArgumentChecks.isTrue( name.trim().isEmpty() == false );
		ArgumentChecks.isTrue( quantity > 0 );
		
		this.name = name;
		this.quantity = quantity;
	}
	
	/**
	 * M�todo que devuelve el valor del atributo nombre
	 *  
	 * @return name, nombre
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * M�todo que devuelve el valor del atributo cantidad
	 *  
	 * @return quantity, cantidad
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * M�todo que devuelve una cadena de caracteres del objeto
	 * 
	 * @return cadena del objeto
	 */
	public String toString(){
		return "Order: " + getName() + "\t" + getQuantity();
	}
	
	/**
	 * M�todo que devuelve el objeto en formato serie
	 * 
	 * @return formato serie del objeto
	 */
	public String serialize(){
		return  getName() + "\t" + getQuantity();
	}	
}
