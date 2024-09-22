package uo.mp.s3.dome.model;

import java.io.PrintStream;

import uo.mp.util.checks.ArgumentsCheck;

/**
 * Titulo: Clase VideoGame
 * 
 * @author Omitg
 * @version 18-02-2021
 */
public class VideoGame extends Item{
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
	 */
	public VideoGame(String theTittle, String author, int players, Platform platform) {
		super(theTittle);
		ArgumentsCheck.isTrue(author!=null && !author.trim().isEmpty(),
				"El autor no cumple los requisitos");
		ArgumentsCheck.isTrue(players>0, "El numero de jugadores debe de ser mayor a 0");		
		setGameDirector(author);
		setPlayers(players);
		setPlatform(platform);
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
	 * M�todo que imprime por pantalla los datos correspondientes del Cd, por
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
}
