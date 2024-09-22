package uo.mp.s5.dome.model;

import java.io.PrintStream;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase Cd
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class Cd extends Item implements Borrowable{
//Constantes:
	/**
	 * Tasa
	 */
	public static final double TAX = 2;	
	
//Atributos:
	/**
	 * Atributo artist, artista del Cd
	 */
	private String artist;

	/**
	 * Atributo numberOfTracks, numero de pistas del Cd
	 */
	private int numberOfTracks;
	
	/**
	 * Atributo tiempo, duración del Cd
	 */
	private int playingTime;
	
	/**
	 * Atributo de si esta disponible
	 */
	private boolean isAvailable;
	
	/**
	 * Constructor con parámetros de la clase Cd
	 * 
	 * @param theTitle,  titulo del CD, de tipo String
	 * @param theArtist, artista del CD, de tipo String
	 * @param tracks,    numero de pistas del CD, de tipo int
	 * @param time,      tiempo de duración del CD, de tipo int
	 * @param basePrice, precio base del producto
	 */
	public Cd(String theTitle, String theArtist, int tracks, int time, double basePrice) {
		super(theTitle, basePrice);
		ArgumentChecks.isTrue(theArtist != null && !theArtist.trim().isEmpty(), "El artista no cumple los requisitos");
		ArgumentChecks.isTrue(tracks > 0, "El numero de pistas no cumple los requisitos");
		ArgumentChecks.isTrue(time > 0, "El tiempo no cumple los requisitos");
		setArtist(theArtist);
		setNumberOfTracks(tracks);
		setPlayingTime(time);
		this.isAvailable = true;
	}
	
	/**
	 * Constructor con parámetros de la clase Cd
	 * 
	 * @param theTitle,  titulo del CD, de tipo String
	 * @param theArtist, artista del CD, de tipo String
	 * @param tracks,    numero de pistas del CD, de tipo int
	 * @param time,      tiempo de duración del CD, de tipo int
	 * @param basePrice, precio base del producto
	 * @param gotIt, si es propietario o no
	 */
	public Cd(String theTitle, String theArtist, int tracks, int time, double basePrice, boolean gotIt) {
		super(theTitle, basePrice);
		ArgumentChecks.isTrue(theArtist != null && !theArtist.trim().isEmpty(), "El artista no cumple los requisitos");
		ArgumentChecks.isTrue(tracks > 0, "El numero de pistas no cumple los requisitos");
		ArgumentChecks.isTrue(time > 0, "El tiempo no cumple los requisitos");
		setArtist(theArtist);
		setNumberOfTracks(tracks);
		setPlayingTime(time);
		setOwn(gotIt);
		this.isAvailable = true;
	}
	
	/**
	 * Constructor para las pruebas del método setBasePrice y setTitle
	 */
	public Cd() {
	}

	/**
	 * Método que modifica el valor del atributo artist
	 * 
	 * @param artist, artista del Cd, de tipo String
	 */
	private void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * Método que modifica el valor del atributo numberOfTracks
	 * 
	 * @param numberOfTracks, numero de pistas del Cd, de tipo int
	 */
	private void setNumberOfTracks(int numberOfTracks) {
		this.numberOfTracks = numberOfTracks;
	}

	/**
	 * Método que devuelve el valor del atributo artist
	 * 
	 * @return artist, artista del Cd
	 */
	public String getArtist() {
		return this.artist;
	}

	/**
	 * Método que devuelve el valor del atributo numberOfTracks
	 * 
	 * @return numberOfTracks, numero de pistas del Cd
	 */
	public int getNumberOfTracks() {
		return this.numberOfTracks;
	}
	
	/**
	 * Método que modifica el valor del atributo playingTime
	 * 
	 * @param playingTime, duración del Cd o Dvd, de tipo int
	 */
	protected void setPlayingTime(int playingTime) {
		this.playingTime = playingTime;
	}
	
	/**
	 * Método que devuelve el valor del atributo playingTime
	 * 
	 * @return playingTime, duración del Cd o Dvd
	 */
	public int getPlayingTime() {
		return this.playingTime;
	}	

	/**
	 * Método que imprime por pantalla los datos correspondientes del Cd, por
	 * ejemplo: Titulo, duración, artista, numero de pistas, etc...
	 * 
	 * @param out, lugar donde imprimir los datos, de tipo PrintStream
	 */
	public void print(PrintStream out) {
		ArgumentChecks.isTrue(out != null, "La impresión no debe ser null");
		out.println("CD: " + getTitle() + " (" + getPlayingTime() + " mins)");
		out.println("Artist: " + getArtist());
		out.println("Tracks: " + getNumberOfTracks());
		if (getOwn()) {
			out.println("You own it");
		} else {
			out.println("You do not own it");
		}
		out.println("Comment: " + getComment()+ "\n");
	}
	
	/**
	 * Nétodo que devuelve las caracteristicas del Item
	 * 
	 * @return result, caracteristicas del Item
	 */
	public String toString() {
		String result = super.toString();
		result = result + "CD: (" + getPlayingTime() + " mins)\n";
		result = result +"Artist: " + getArtist() + "\n";
		result = result + "Tracks: " + getNumberOfTracks() + "\n";
		return result;
	}

	/**
	 * Método que imprime los responsables de entre los objetos poseidos
	 * 
	 * @param out, lugar de impresion del método
	 */
	public void printResponsible(PrintStream out) {
		ArgumentChecks.isTrue(out != null, "La impresión no debe ser null");
		if (getOwn()) {
			out.println("\t--> " + getArtist());
		}
		
	}

	/**
	 * Método que compara dos items mediante su titulo y arista(director/autor
	 * 
	 * @param item, item a compara, de tip Item
	 * @return true o false, en función de si son iguales o no
	 */
	public boolean isLike(Item item) {
		ArgumentChecks.isTrue(item!=null, "El item no puede ser null");
		if (item instanceof Cd) {
			if (this.getTitle().equals(item.getTitle()) 
					&& this.getArtist().equals(((Cd) item).getArtist())) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Método que devuelve el precio final del cd
	 * 
	 * @return precio final del cd
	 */
	public double totalValue() {
		return (getBasePrice()+TAX);
	}
	
	/**
	 * Método que devuelve true o false si un cd esta disponible
	 * 
	 * @return true o false
	 */
	public boolean isAvailable() {
		return this.getOwn() && this.isAvailable;
	}
	
	/**
	 * Método que presta un cd y cambia el estado del atributo isAvailable a 
	 * false tras prestarlo
	 */
	public void borrow() {
		this.isAvailable=false;
	}
	
	/**
	 * Método que devuelve un cd y cambia el estado del atributo isAvailable a 
	 * true tras devolverlo
	 */
	public void giveBack() {
		this.isAvailable=true;
	}
	/**
	 * Método hashCode, devuelve caracteristicas del objeto
	 * 
	 * @return result, las caracteristicas del objeto
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + numberOfTracks;
		result = prime * result + playingTime;
		return result;
	}
	
	/**
	 * Métodoo equals, que compara objetos 
	 * 
	 * @param obj, objeto a comparar
	 * @return true o false, en función de si son iguales
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
		Cd other = (Cd) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (numberOfTracks != other.numberOfTracks)
			return false;
		if (playingTime != other.playingTime)
			return false;
		return true && super.equals(obj);
	}
}