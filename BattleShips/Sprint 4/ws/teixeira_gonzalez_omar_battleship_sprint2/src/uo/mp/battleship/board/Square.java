package uo.mp.battleship.board;

import uo.mp.battleship.board.squares.Ship;
import uo.mp.battleship.board.squares.Target;
import uo.mp.battleship.board.squares.Water;

/**
 * Titulo: Clase Square
 * 
 * Descripcion: Clase que contiene informaci�n de cada casilla en la que se divide 
 * el tablero, contiene objetos Ship y/u objetos Water, pertenecientes a las clases 
 * correspondientes, habr� 10 barcos, el resto de casillas ser�n de tipo Water
 * 
 * @author Omitg
 * @version 07-03-2021
 */
public class Square {
//Atributos:
	/**
	 * Atributo contenido
	 */
	private Target content;
	
	/**
	 * Atributo barco
	 */
	private Ship ship;
	
	/**
	 * Atributo agua
	 */
	private Water water;
	
	/**
	 * Atributo casilla disparada
	 */
	private boolean shootedSquare;
	
	/**
	 * M�todo que marca la casilla como disparada y en caso de haber un barco 
	 * llama al shootAt de Ship y viceversa en el caso del agua
	 * 
	 * @return 0, 1 o 2, en funci�n de a lo que se ha disparado en la casilla
	 */
	public int shootAt() {
		shootedSquare=true;
		return content.shootAt();
	}
	
	/**
	 * M�todo que devuelve si la caslla ha sido disparada
	 * 
	 * @return true o false, en funci�n de si ha sido disparada
	 */
	public boolean isShot() {		
		return shootedSquare;
	}
	
	/**
	 * M�todo que devuelve true si la casilla la ocupa un barco y este barco 
	 * ha recibido un disparo
	 * 
	 * @return true o false, en funci�n de si un barco ha sido disparado
	 */
	public boolean hasImpact() {		
		if (content.hasImpact()) {
			return true;
		}
		return false;
	}
	
	/**
	 * M�todo que devuelve el caracter correspondiente a la casilla, mediante 
	 * llamadas a los m�todos toFiredChar y toChar de Ship y Water
	 * 
	 * @return char, valores char de los barcos o el agua
	 */
	public char toChar() {
		if (isShot()) {
			return content.toFiredChar();
		} else {
			return content.toChar();
		}		
	}
	
	/**
	 * M�todo que guarda en el atributo content un barco o agua y lo devuelve
	 * 
	 * @param squareTarget, barco o agua a almacenar en la casilla
	 * @return content, contenido de la casilla 
	 */
	public Square setContent(Target squareTarget) {
		this.content = squareTarget;
		return this;
	}	
	
	/**
	 * M�todo que devuelve el valor de la casilla
	 * 
	 * @return content, contenido de la casilla
	 */
	public Target contentInSquare() {
		return content;
	}
	
	/**
	 * M�todo que devuelve true si la casilla tiena un barco o agua
	 * 
	 * @return true o false, en funci�n de si tiene un barco o agua
	 */
	public boolean hasContent() {
		if (content.equals(ship) || content.equals(water)) {
			return true;
		}
		return false;
	}
}
