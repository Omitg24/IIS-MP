/**
 * 
 */
package uo.mp.shopping.processor.service;

import uo.mp.checks.ArgumentChecks;
import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.invoice.Billable;
import uo.mp.shopping.model.Product;
import uo.mp.shopping.processor.comparators.ComparatorByBPAndCode;
import uo.mp.sort.Collections;

public class Shopper {
	
	private static final double FAMILY__DISCOUNT = 0.03;
	
	private List<Product> cart = new ArrayList<>();    // carrito 
	
	private String userID;
	
	public Shopper(String userID) {
		ArgumentChecks.isTrue(userID!=null && !userID.trim().isEmpty(), 
				"El codigo de usuario no cumple los requisitos");
		this.userID = userID;
	}
	
	public String getUserID() {
		return userID;
	}
	
	/**
	 * Añade la lista de productos que se compran
	 * NO incluye los repetidos. 
	 * Guarda en el log mensaje "PRODUCTO REPETIDO y los datos del producto
	 * 
	 */
	public void addProducts(List<Product> products) {
		for(int i = 0; i<products.size(); i++) {
//			if (cart.contains(products.get(i))){
//				System.out.println("PRODUCTO REPETIDO" + products.get(i).toString());
//			} else {
//				cart.add(products.get(i));
//			}
			cart.add(products.get(i));
		}
	}	
	
	/**
	 * Calcula el coste total del carrito sin descuento
	 * 
	 */
	public double calculateCostWithoutDiscount() {
		double total = 0;
		for (Product p : cart) {
			total = total + p.getCost();
		}		
		return total;
	}
		
	/**
	 * Calcula el coste total del carrito (con descuento si lo tiene)
	 * 
	 */
	public double calculateCost() {
		double total = calculateCostWithoutDiscount() - (calculateCostWithoutDiscount()*getDiscount()); 
		return total;
	}
	
	/**
	 * Calcula el descuento 
	 * 
	 */
	public double getDiscount() {
		String[] id = getUserID().split("");
		if (id[0].equals("L")) {
			return FAMILY__DISCOUNT;
		} else {
			return 0.0;
		}
	}
	
		
	/**
	 * Devuelve una copia del carrito (para pruebas)
	 */
	public List<Product> getCartForTest() {
		return new ArrayList<>(cart);
	}

	

	/**
	 * Devuelve copia ordenada de productos del carrito
	 * Ordena por precio y a igual precio por código
	 * 
	 */
	public List<Product> getSortedProducts() {
		Collections.sort(cart, new ComparatorByBPAndCode());
		return cart;
	}
	

	/**
	 * Genera lista de Billables a partir de lista de Products
	 *
	 */
	public List<Billable> getBillables() {
		List<Billable> billables = new ArrayList<>();
		for (Product p : cart) {
			billables.add(p);
		}
		return billables;
	}
	

}
