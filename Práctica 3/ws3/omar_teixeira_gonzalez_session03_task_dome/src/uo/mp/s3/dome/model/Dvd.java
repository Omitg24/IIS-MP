package uo.mp.s3.dome.model;

import java.io.PrintStream;

import uo.mp.util.checks.ArgumentsCheck;

/**
 * Titulo: Clase Dvd
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class Dvd extends Item {
//Atributos:
	/**
	 * Atributo director, director del Dvd
	 */
	private String director;
	
	/**
	 * Atributo tiempo, duraci�n del Dvd
	 */
	private int playingTime;

	/**
	 * Constructor con par�metros de la clase Dvd
	 * 
	 * @param theTitle,    titulo del Dvd, de tipo String
	 * @param theDirector, director del Dvd, de tipo String
	 * @param time,        duraci�n del Dvd, de tipo String
	 */
	public Dvd(String theTitle, String theDirector, int time) {
		super(theTitle);
		ArgumentsCheck.isTrue(theDirector != null && !theDirector.trim().isEmpty(),
				"El director no cumple los requisitos");
		ArgumentsCheck.isTrue(time>0, "El tiempo no cumple los requisitos");
		setDirector(theDirector);
		setPlayingTime(time);
	}

	/**
	 * M�todo que modifica el valor del atributo director
	 * 
	 * @param director, director del Dvd, de tipo String
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * M�todo que devuelve el valor del atributo director
	 * 
	 * @return director, director del Dvd
	 */
	public String getDirector() {
		return this.director;
	}
	
	/**
	 * M�todo que modifica el valor del atributo playingTime
	 * 
	 * @param playingTime, duraci�n del Cd o Dvd, de tipo int
	 */
	protected void setPlayingTime(int playingTime) {
		this.playingTime = playingTime;
	}
	
	/**
	 * M�todo que devuelve el valor del atributo playingTime
	 * 
	 * @return playingTime, duraci�n del Cd o Dvd
	 */
	public int getPlayingTime() {
		return this.playingTime;
	}
	
	/**
	 * M�todo que imprime por pantalla los datos correspondientes del Cd, por
	 * ejemplo: Titulo, duraci�n, director, etc...
	 * 
	 * @param out, lugar donde imprimir los datos, de tipo PrintStream
	 */
	public void print(PrintStream out) {
		out.println("DVD: " + getTitle() + " (" + getPlayingTime() + " mins)");
		out.println("Director: " + getDirector());
		if (getOwn()) {
			out.println("You own it");
		} else {
			out.println("You do not own it");
		}
		out.println("Comment: " + getComment()+ "\n");
	}
}
