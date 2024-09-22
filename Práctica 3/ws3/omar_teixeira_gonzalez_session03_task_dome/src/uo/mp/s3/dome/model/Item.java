package uo.mp.s3.dome.model;

import java.io.PrintStream;

import uo.mp.util.checks.ArgumentsCheck;

/**
 * Titulo: Clase Item
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class Item {
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
	 * Constructor sin par�metros de la clase Item con la creaci�n de la superclase
	 */
	public Item() {
		super();
	}

	/**
	 * Constructor con par�metros de la clase Item con la creaci�n de la superclase
	 * 
	 * @param theTitle, titulo del Cd, Dvd o VideoGame, de tipo String
	 */
	public Item(String theTitle) {
		super();
		ArgumentsCheck.isTrue(theTitle != null && !theTitle.trim().isEmpty(), "El titulo no cumple los requisitos");		
		setTitle(theTitle);		
		setOwn(true);
		setComment("No comment");
	}

	/**
	 * M�todo que modifica el valor del atributo titulo
	 * 
	 * @param title, titulo del Cd, Dvd o VideoGame, de tipo String
	 */
	protected void setTitle(String title) {
		this.title = title;
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
	 * @param comment, comentario que acompa�a al Cd,al Dvd o al VideoGame, de tipo String
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
	 * M�todo que imprime el item introducido
	 * 
	 * @param out, lugar donde se imprimira el item, de tipo PrintStream
	 */
	public void print(PrintStream out) {
		// Vac�o (magia del polimorfismo)
	}
}