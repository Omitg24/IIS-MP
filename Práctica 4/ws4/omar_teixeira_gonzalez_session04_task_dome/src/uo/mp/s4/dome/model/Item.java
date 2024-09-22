package uo.mp.s4.dome.model;

import java.io.PrintStream;

import uo.mp.util.checks.ArgumentsCheck;

/**
 * Titulo: Clase Item
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public abstract class Item {
//Constantes:
	/**
	 * Constante precio m�ximo
	 */
	public static final double MAX_PRICE=10000.0;
	
//Atributos:
	/**
	 * Atribto title, titulo del Cd, Dvd o VideoGame
	 */
	private String title;

	/**
	 * Atributo gotIt, posesi�n del Cd, Dvd o VideoGame
	 */
	private boolean gotIt;

	/**
	 * Atributo comment, comentario sobre el Cd, Dvd o VideoGame
	 */
	private String comment;
	
	/**
	 * Atributo basePrice, precio base del Cd
	 */
	private double basePrice;

	/**
	 * Constructor sin par�metros de la clase Item con la creaci�n de la superclase
	 */
	public Item() {
		super();
	}

	/**
	 * Constructor con par�metros de la clase Item con la creaci�n de la superclase
	 * 
	 * @param theTitle, titulo del Cd, Dvd o VideoGame, de tipo String
	 * @param basePrice, precio base del producto
	 */
	public Item(String theTitle, double basePrice) {
		super();
		ArgumentsCheck.isTrue(theTitle != null && !theTitle.trim().isEmpty(), 
				"El titulo no cumple los requisitos");
		ArgumentsCheck.isTrue(basePrice>=0.0 && basePrice<=MAX_PRICE,
				"El precio base no cumple los requisitos");
		setBasePrice(basePrice);
		setTitle(theTitle);		
		setOwn(true);
		setComment("No comment");
	}

	/**
	 * M�todo que modifica el valor del atributo titulo
	 * 
	 * @param title, titulo del Cd, Dvd o VideoGame, de tipo String
	 */
	public void setTitle(String title) {
		if (title!=null) {
			this.title = title;
		}
	}

	/**
	 * M�todo que modifica el valor del atributo basePrice
	 * 
	 * @param basePrice, precio base del Cd, Dvd o VideoGame
	 */
	public void setBasePrice(double basePrice) {
		if (basePrice>=0.0) {
			this.basePrice = basePrice;
		}
	}
	
	/**
	 * M�todo que modifica el valor del atributo ownIt
	 * 
	 * @param ownIt, posesi�n del Cd, Dvd o VideoGame, de tipo boolean
	 */
	public void setOwn(boolean ownIt) {
		gotIt = ownIt;
	}

	/**
	 * M�todo que modifica el valor del atributo comment
	 * 
	 * @param comment, comentario que acompa�a al Cd,al Dvd o al VideoGame, 
	 * 		  de tipo String
	 */
	public void setComment(String comment) {
		if (comment!=null) {
			this.comment = comment;
		}		
	}
	
	/**
	 * M�todo que devuelve el valor del atributo comment
	 * 
	 * @return comment, comentario que acompa�a al Cd, al Dvd o VideoGame
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * M�todo que devuelve el valor del atributo gotIt
	 * 
	 * @return gotIt, posesi�n del Cd, Dvd o VideoGame
	 */
	public boolean getOwn() {
		return gotIt;
	}

	/**
	 * M�todo que devuelve el valor del atributo title
	 * 
	 * @return title, titulo del Cd, Dvd o VideoGame
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * M�todo que devuelve el valor del atributo basePrice
	 * 
	 * @return basePrice, precio base del Cd, Dvd o VideoGame
	 */
	public double getBasePrice() {
		return basePrice;
	}	

	/**
	 * M�todo abstracto que imprime el item introducido
	 * 
	 * @param out, lugar donde se imprimira el item, de tipo PrintStream
	 */
	public abstract void print(PrintStream out);
	
	/**
	 * N�todo que devuelve las caracteristicas del Item
	 * 
	 * @return result, caracteristicas del Item
	 */
	public String toString() {
		String result = "This is the superclass of the Items:\nTitle: " + getTitle() + "\n";
		result = result + "Base price: " + getBasePrice() + " $\n";
		if (getOwn()) {
			result = result + "You own it\n";
		}else {
			result = result + "You dont own it\n";
		}
		result = result + "Comment : " + getComment() + "\n";
		return result;
	}	
	
	/**
	 * M�todo abstracto que imprime los responsables del Cd, Dvd o VideoGame
	 *  
	 * @param out, lugar donde se imprimira el item, de tipo PrintStream
	 */
	public abstract void printResponsible(PrintStream out);
	
	/**
	 * M�todo abstracto que compara items
	 * 
	 * @param theItem, el item a comparar
	 * @return true o false dependiendo de si el objeto esta o no
	 */
	public abstract boolean isLike(Item theItem);
	
	/**
	 * M�todo abstracto que devuelve el total de precios de los items 
	 * 
	 * @return result, resultado del valor total de los items
	 */
	public abstract double totalValue();
		

	/**
	 * M�todo hashCode, devuelve caracteristicas del objeto
	 * 
	 * @return result, las caracteristicas del objeto
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + (gotIt ? 1231 : 1237);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	/**
	 * M�todoo equals, que compara objetos 
	 * 
	 * @param obj, objeto a comparar
	 * @return true o false, en funci�n de si son iguales
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (gotIt != other.gotIt)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}