package uo.mp.s4.dome.model;

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
	 * @param basePrice, precio base del producto
	 */
	public Dvd(String theTitle, String theDirector, int time, double basePrice) {
		super(theTitle, basePrice);
		ArgumentsCheck.isTrue(theDirector != null && !
				theDirector.trim().isEmpty(),
				"El director no cumple los requisitos");
		ArgumentsCheck.isTrue(time>0, "El tiempo no cumple los requisitos");
		setDirector(theDirector);
		setPlayingTime(time);
	}
	
	/**
	 * Constructor para las pruebas del m�todo setBasePrice y setTitle
	 */
	public Dvd() {
		// TODO Auto-generated constructor stub
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
	
	/**
	 * N�todo que devuelve las caracteristicas del Item
	 * 
	 * @return result, caracteristicas del Item
	 */
	public String toString() {
		String result = super.toString();
		result = result + "DVD: (" + getPlayingTime()+ " mins)\n";
		result = result + "Director: " + getDirector() + "\n";
		return result;
	}
	
	/**
	 * M�todo que imprime los responsables de entre los objetos poseidos
	 * 
	 * @param out, lugar de impresion del m�todo
	 */
	public void printResponsible(PrintStream out) {
		ArgumentsCheck.isTrue(out != null, "La impresi�n no debe ser null");
		if (getOwn()) {
			out.println("\t--> " + getDirector());
		}
		
	}
	
	/**
	 * M�todo que compara dos items mediante su titulo y arista(director/autor
	 * 
	 * @param item, item a compara, de tip Item
	 * @return true o false, en funci�n de si son iguales o no
	 */
	public boolean isLike(Item item) {
		ArgumentsCheck.isTrue(item!=null, "El item no puede ser null");
		if (item instanceof Dvd) {
			if (this.getTitle().equals(item.getTitle()) 
					&& this.getDirector().equals(((Dvd) item).getDirector())) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public double totalValue() {
		return getBasePrice();
	}
	
	/**
	 * M�todo hashCode, devuelve caracteristicas del objeto
	 * 
	 * @return result, las caracteristicas del objeto
	 */	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + playingTime;
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
		super.equals(obj);
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dvd other = (Dvd) obj;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (playingTime != other.playingTime)
			return false;
		return true && super.equals(obj);
	}
}
