package uo.mp.s5.dome.model;

import java.io.PrintStream;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase VideoGame
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class VideoGame extends Item{
//Constantes:
	/**
	 * Tasa
	 */
	public static final double TAX = 0.1;
	
//Enumeraciones:
	/**
	 * Enumerador Platform
	 */
	public enum Platform{
	/**
	 * Plataforma Xbox
	 */
	XBOX,
	/**
	 * Plataforma PlayStation
	 */
	PLAYSTATION,
	/**
	 * Plataforma Nintendo
	 */
	NINTENDO};
	
//Atributos:	
	/**
	 * Autor del videojuego
	 */
	private String author;
			
	/**
	 * Numero de jugadores del videojuego
	 */
	private int players;
	
	/**
	 * Plataforma en la que se jugar� el juego
	 */
	private Platform platform;

	/**
	 * Constructor con par�emtros de la clase VideoGame
	 * 
	 * @param theTittle, titulo del videojuego
	 * @param author, autor del videojuego
	 * @param players, numero de jugadores
	 * @param platform, plataforma en la que se jugar�
	 * @param basePrice, precio base del producto
	 */
	public VideoGame(String theTittle, String author, int players, Platform platform, double basePrice) {
		super(theTittle, basePrice);
		ArgumentChecks.isTrue(author!=null && !author.trim().isEmpty(),
				"El autor no cumple los requisitos");
		ArgumentChecks.isTrue(players>0, "El numero de jugadores debe de ser mayor a 0");		
		setGameDirector(author);
		setPlayers(players);
		setPlatform(platform);
	}
	
	/**
	 * Constructor para las pruebas del m�todo setBasePrice y setTitle
	 */
	public VideoGame() {		
	}

	/**
	 * M�todo que devuelve el valor del atributo author
	 * 
	 * @return author, autor del videojuego
	 */
	public String getGameDirector() {
		return author;
	}

	/**
	 * M�todo que modifica el valor del atributo author
	 * 
	 * @param author, autor del videojuego, de tipo String
	 */
	public void setGameDirector(String author) {
		this.author = author;
	}

	/**
	 * M�todo que devuelve el valor del atributo players
	 * 
	 * @return players, numero de jugadores del juego
	 */
	public int getPlayers() {
		return players;
	}

	/**
	 * M�todo que modifica el valor del atributo players
	 * 
	 * @param players, numero de jugadores del juego, de tipo int
	 */
	public void setPlayers(int players) {
		this.players = players;
	}
	
	/**
	 * M�todo que devuelve el valor del atributo platform
	 * 
	 * @return platform, plataforma en la que se jugar� el juego
	 */
	public Platform getPlatform() {
		return platform;
	}
	
	/**
	 * M�todo que modifica el valor del atributo platform
	 * 
	 * @param platform, plataforma en la que se jugar� el juego, de tipo Platform (enumeraci�n)
	 */
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	
	
	
	/**
	 * M�todo que imprime por pantalla los datos correspondientes del VideoGame, por
	 * ejemplo: Titulo, author, jugadores, plataforma, etc...
	 * 
	 * @param out, lugar donde imprimir los datos, de tipo PrintStream
	 */
	public void print(PrintStream out) {
		out.println("Videogame: " + getTitle());
		out.println("Game Director: " + getGameDirector());
		if (getOwn()) {
			out.println("You own it");
		} else {
			out.println("You do not own it");
		}
		out.println("Comment: " + getComment());
		out.println("Players: " + getPlayers());
		out.println("Platform: " + getPlatform()+ "\n");
	}
	
	/**
	 * N�todo que devuelve las caracteristicas del Item
	 * 
	 * @return result, caracteristicas del Item
	 */
	public String toString() {		
		String result = super.toString();
		result = result + "Game Director: " + getGameDirector() + "\n";
		result = result + "Number of players: " + getPlayers() + "\n";
		result = result + "Platform: " + getPlatform() + "\n";
		return result;
	}
	
	/**
	 * M�todo que imprime los responsables de entre los objetos poseidos
	 * 
	 * @param out, lugar de impresion del m�todo
	 */
	public void printResponsible(PrintStream out) {
		ArgumentChecks.isTrue(out != null, "La impresi�n no debe ser null");
		if (getOwn()) {
			out.println("\t--> " + getGameDirector());
		}
		
	}
	
	/**
	 * M�todo que compara dos items mediante su titulo y arista/director/autor
	 * 
	 * @param item, item a compara, de tip Item
	 * @return true o false, en funci�n de si son iguales o no
	 */
	public boolean isLike(Item item) {
		ArgumentChecks.isTrue(item!=null, "El item no puede ser null");
		if (item instanceof VideoGame) {
			if (this.getTitle().equals(item.getTitle()) 
					&& this.getGameDirector().equals(((VideoGame) item).getGameDirector())) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * M�todo que devuelve el precio final del videogame
	 * 
	 * @return precio final del videogame
	 */
	public double totalValue() {
		return (getBasePrice()+(getBasePrice()*TAX));
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
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((platform == null) ? 0 : platform.hashCode());
		result = prime * result + players;
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
		VideoGame other = (VideoGame) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (platform != other.platform)
			return false;
		if (players != other.players)
			return false;
		return true && super.equals(obj);
	}	
}
