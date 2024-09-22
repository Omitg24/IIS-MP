package uo.mp.battleship.ranking;

import java.io.Serializable;
import java.util.Date;

import uo.mp.battleship.session.GameLevel;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Titulo: Clase Score
 * 
 * Descripci�n: Clase que representa la puntuaci�n de los jugadores
 * 
 * @author Omitg
 * @version 07-05-2021
 */
public class Score implements Serializable{
	/**
	 * Constante serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo userName
	 */
	private String userName;
	/**
	 * Atributo time
	 */
	private long time;
	/**
	 * Atributo date
	 */
	private Date date;
	/**
	 * Atributo level
	 */
	private GameLevel level;		
	
	/**
	 * Constructor con par�metros de Score
	 * 
	 * @param userName, usuario
	 * @param level, nivel
	 * @param time, tiempo
	 */
	public Score(String userName, GameLevel level, long time) {
		ArgumentChecks.isTrue(userName!=null && !userName.trim().isEmpty(), 
				"El nombre de usuario no cumple los requisitos");
		ArgumentChecks.isTrue(time>0, 
				"El tiempo no cumple los requisitos");
		this.userName=userName;
		this.level=level;
		this.time=time;
		date = new Date();
		
	}
	
	/**
	 * M�todo que devuelve el usuario
	 * 
	 * @return userName, usuario
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * M�todo que devuelve el tiempo
	 * 
	 * @return time, tiempo
	 */
	public long getTime() {
		return time;
	}
	
	/**
	 * M�todo que devuelve la fecha
	 * 
	 * @return date, fecha
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * M�todo que devuelve el nivel
	 * 
	 * @return level, nivel
	 */
	public GameLevel getLevel() {
		return level;
	}	
	
	/**
	 * M�todo que devuelve una cadena con los datos de la puntuaci�n
	 * 
	 * @return string, cadena
	 */
	public String toString() {
		return "User: " + getUserName() + ", Time: " + getTime() + ", Date: " + 
				getDate() + ", Level: " + getLevel();
	}
}
