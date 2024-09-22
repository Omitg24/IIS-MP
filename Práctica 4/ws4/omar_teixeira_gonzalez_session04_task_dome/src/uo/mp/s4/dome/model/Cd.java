package uo.mp.s4.dome.model;

import java.io.PrintStream;

import uo.mp.util.checks.ArgumentsCheck;

/**
 * Titulo: Clase Cd
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class Cd extends Item {
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
	 * Atributo tiempo, duraci�n del Cd
	 */
	private int playingTime;

	/**
	 * Constructor con par�metros de la clase Cd
	 * 
	 * @param theTitle,  titulo del CD, de tipo String
	 * @param theArtist, artista del CD, de tipo String
	 * @param tracks,    numero de pistas del CD, de tipo int
	 * @param time,      tiempo de duraci�n del CD, de tipo int
	 * @param basePrice, precio base del producto
	 */
	public Cd(String theTitle, String theArtist, int tracks, int time, double basePrice) {
		super(theTitle, basePrice);
		ArgumentsCheck.isTrue(theArtist != null && !theArtist.trim().isEmpty(), "El artista no cumple los requisitos");
		ArgumentsCheck.isTrue(tracks > 0, "El numero de pistas no cumple los requisitos");
		ArgumentsCheck.isTrue(time > 0, "El tiempo no cumple los requisitos");
		setArtist(theArtist);
		setNumberOfTracks(tracks);
		setPlayingTime(time);
	}
	
	/**
	 * Constructor para las pruebas del m�todo setBasePrice y setTitle
	 */
	public Cd() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * M�todo que modifica el valor del atributo artist
	 * 
	 * @param artist, artista del Cd, de tipo String
	 */
	private void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * M�todo que modifica el valor del atributo numberOfTracks
	 * 
	 * @param numberOfTracks, numero de pistas del Cd, de tipo int
	 */
	private void setNumberOfTracks(int numberOfTracks) {
		this.numberOfTracks = numberOfTracks;
	}

	/**
	 * M�todo que devuelve el valor del atributo artist
	 * 
	 * @return artist, artista del Cd
	 */
	public String getArtist() {
		return this.artist;
	}

	/**
	 * M�todo que devuelve el valor del atributo numberOfTracks
	 * 
	 * @return numberOfTracks, numero de pistas del Cd
	 */
	public int getNumberOfTracks() {
		return this.numberOfTracks;
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
	 * ejemplo: Titulo, duraci�n, artista, numero de pistas, etc...
	 * 
	 * @param out, lugar donde imprimir los datos, de tipo PrintStream
	 */
	public void print(PrintStream out) {
		ArgumentsCheck.isTrue(out != null, "La impresi�n no debe ser null");
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
	 * N�todo que devuelve las caracteristicas del Item
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
	 * M�todo que imprime los responsables de entre los objetos poseidos
	 * 
	 * @param out, lugar de impresion del m�todo
	 */
	public void printResponsible(PrintStream out) {
		ArgumentsCheck.isTrue(out != null, "La impresi�n no debe ser null");
		if (getOwn()) {
			out.println("\t--> " + getArtist());
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
	
	public double totalValue() {
		return (getBasePrice()+TAX);
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
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + numberOfTracks;
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